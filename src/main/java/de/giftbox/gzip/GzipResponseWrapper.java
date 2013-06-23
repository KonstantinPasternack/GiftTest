package de.giftbox.gzip;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GzipResponseWrapper extends HttpServletResponseWrapper {
	private static final Logger log = LoggerFactory
			.getLogger(GzipResponseWrapper.class);

	private HttpServletResponse response = null;
	private ServletOutputStream stream = null;
	private PrintWriter writer = null;

	public GzipResponseWrapper(HttpServletResponse response) {
		super(response);
		this.response = response;
	}

	public void finishResponse() {
		try {
			if (writer != null) {
				writer.close();
			}
			else if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			log.error("Could not close streams.", e);
		}
	}

	private ServletOutputStream createOutputStream() throws IOException {
		return new GzipResponseStream(response);
	}

	@Override
	public void flushBuffer() throws IOException {
		stream.flush();
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (writer != null)
			throw new IllegalStateException(
					"getWriter() has already been called!");
		if (stream == null)
			stream = createOutputStream();
		return stream;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (writer != null)
			return writer;
		if (stream != null)
			throw new IllegalStateException(
					"getOutputStream() has already been called!");
		stream = createOutputStream();
		writer = new PrintWriter(new OutputStreamWriter(stream,
				"UTF-8"));
		return writer;
	}

	@Override
	public void setContentLength(int paramInt) {
	}
}