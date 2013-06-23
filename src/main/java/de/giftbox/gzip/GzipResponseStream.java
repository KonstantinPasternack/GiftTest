package de.giftbox.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GzipResponseStream extends ServletOutputStream {
	private static final Logger log = LoggerFactory
			.getLogger(GzipResponseStream.class);

	private HttpServletResponse response;
	private ServletOutputStream servletOutStream;
	private ByteArrayOutputStream byteOutStream;
	private GZIPOutputStream gzipOutStream;
	private boolean closed;

	public GzipResponseStream(HttpServletResponse response) throws IOException {
		this.response = response;
		this.servletOutStream = response.getOutputStream();
		this.byteOutStream = new ByteArrayOutputStream();
		this.gzipOutStream = new GZIPOutputStream(this.byteOutStream);
	}

	public boolean isClosed() {
		return closed;
	}

	@Override
	public void close() throws IOException {
		checkIfClosed("This stream has already been closed", false);

		if (!closed) {
			gzipOutStream.finish();
			byte[] bytes = this.byteOutStream.toByteArray();

			response.addHeader("Content-Length", Integer.toString(bytes.length));
			response.addHeader("Content-Encoding", "gzip");

			servletOutStream.write(bytes);
			servletOutStream.flush();
			servletOutStream.close();

			closed = true;
		}
	}

	@Override
	public void flush() throws IOException {
		checkIfClosed("Cannot flush a closed stream", false);

		if (!closed) {
			gzipOutStream.flush();
		}
	}

	@Override
	public void write(int bite) throws IOException {
		checkIfClosed("Cannot write to a closed stream");
		gzipOutStream.write((byte) bite);
	}

	@Override
	public void write(byte[] bytes) throws IOException {
		write(bytes, 0, bytes.length);
	}

	@Override
	public void write(byte[] bytes, int offset, int length) throws IOException {
		checkIfClosed("Cannot write to a closed stream");
		gzipOutStream.write(bytes, offset, length);
	}

	private void checkIfClosed(String message) throws IOException {
		checkIfClosed(message, true);
	}

	/**
	 * Spring's StringHttpMessageConverter.writeInternal(String,
	 * HttpOutputMessage) uses FileCopyUtils.copy(String, Writer), which calls
	 * Writer.close(), which gets passed through to our GzipResponseStream.<br>
	 * <br>
	 * 
	 * AbstractHttpMessageConverter.write(..) calls
	 * StringHttp...writeInternal(..) and thereafter calls
	 * outputMessage.getBody().flush(),<br>
	 * <br>
	 * 
	 * which causes our Stream to be both close()d and flush()ed.<br>
	 * <br>
	 * 
	 * As a workaround, we don't always throw an exception.
	 */
	private void checkIfClosed(String message, boolean throwException)
			throws IOException {
		if (closed) {
			log.error(message);
			if (throwException) {
				throw new IOException(message);
			}
		}
	}
}