package de.giftbox.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import de.giftbox.dao.GeschenkDAO;
import de.giftbox.domain.Geschenk;
import de.giftbox.helper.JSONStringToMap;

@Controller
@RequestMapping("/geschenk/*")
public class GeschenkController {

	GeschenkDAO geschenkDao;
	JSONStringToMap jsonStringToMap;

	private static final Logger log = LoggerFactory
			.getLogger(GeschenkController.class);

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public @ResponseBody
	String geschenk() {
		log.debug("Giftbox Server Geschenk");
		return "geschenk";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST/*, consumes = "application/json"*/)
	public @ResponseBody
	Integer postGeschenk(@RequestBody String json) {
		Geschenk geschenk = new Geschenk();
		log.debug(json.toString());
		
		Gson gson = new Gson();
		geschenk = gson.fromJson(json, Geschenk.class);
		
		log.debug(geschenk.toString());
		
		log.info("testing Post \"Geschenk\":" + geschenk.toString() + " to DB");
		Integer lastAdded = 0;
		try {
			geschenkDao.saveGeschenk(geschenk);
			
			log.info("neues Geschenk in die DB geschrieben!");
			
			lastAdded = geschenkDao.getLastAddedGeschenk();
			log.info("Last added Geschenk has ID: " + lastAdded);
		} catch (Exception ex) {

			ex.printStackTrace();
			log.error("saveGeschenk hat nicht funktioniert");

		}

		return lastAdded;

	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String getGeschenkById(@PathVariable(value="id") Integer id) {
		
		
		Geschenk geschenk = geschenkDao.getGeschenkById(id);
		
		Gson gson = new Gson();
		String json = gson.toJson(geschenk, Geschenk.class);
		
		return json;
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	private @ResponseBody
	List<Geschenk> getAllGeschenk() {
		log.debug("get all geschenk!");
		List<Geschenk> listGeschenk = geschenkDao.listGeschenk();
		return listGeschenk;
	}

	public void setGeschenkDAO(GeschenkDAO geschenkDao) {
		this.geschenkDao = geschenkDao;
	}
	
	public void setJSONStringToMap(JSONStringToMap jsonStringToMap) {
		this.jsonStringToMap = jsonStringToMap;
	}
}
