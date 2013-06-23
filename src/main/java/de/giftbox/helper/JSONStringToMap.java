package de.giftbox.helper;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.giftbox.controller.GeschenkController;

//TODO
public class JSONStringToMap {

	/*
	 * wird gebraucht um den Request von der App auszulesen
	 */

	private static final Logger log = LoggerFactory
			.getLogger(GeschenkController.class);

	public Map<String, Object> convertToMap(String json){
		log.debug("Converting String \"" + json + "\" to Map");
		Map<String, Object> map = new HashMap<String, Object>();
		
		log.debug(json);
		
		String jsonWithOutBrackets = json.replace("{", "").replace("}", "");
		
		log.debug(jsonWithOutBrackets);
		
		String[] pairs = jsonWithOutBrackets.split(",");
		
		for(int i=0; i<pairs.length;i++){
			log.debug(pairs[i]);
		}
		
		for(int i = 0; i < pairs.length; i++){
			String[] tmp = pairs[i].split(":");
			tmp[0] = tmp[0].replace("\"", "");
			tmp[1] = tmp[1].replace("\"", "");
			map.put(tmp[0], tmp[1]);
			
		}
		
		log.debug(map.toString());
		
		return map;
		
	}
}
