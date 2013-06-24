package de.giftbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import de.giftbox.dao.BewertungenDAO;
import de.giftbox.domain.Bewertungen;
import de.giftbox.helper.JSONStringToMap;

@Controller
@RequestMapping("/bewertung/*")
public class BewertungenController {

	BewertungenDAO bewertungenDao;
	JSONStringToMap jsonStringToMap;
	
	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);
	
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public @ResponseBody
	String postBewertung(@RequestBody String json) {
		Bewertungen b= new Bewertungen();
		log.debug(json.toString());

		Gson gson = new Gson();
		b = gson.fromJson(json, Bewertungen.class);

		log.debug(b.toString());

		log.info("testing Post \"Bewertung\":" + b.toString() + " to DB");
		Boolean geklappt = false;
		try {
			bewertungenDao.saveBewertung(b);
			geklappt = true;
			log.info("neue Bewertung in die DB geschrieben!");
		} catch (Exception ex) {

			ex.printStackTrace();
			geklappt = false;
			log.error("saveBewertung hat nicht funktioniert");

		}

		return geklappt.toString();

	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String getBewertungenById(@PathVariable(value = "id") Integer id) {

		Bewertungen b = bewertungenDao.findBewertungenById(id);

		Gson gson = new Gson();
		String json = gson.toJson(b, Bewertungen.class);

		return json;
	}
	
	public void setBewertungenDAO(BewertungenDAO bewertungenDao) {
		this.bewertungenDao = bewertungenDao;
	}

	public void setJSONStringToMap(JSONStringToMap jsonStringToMap) {
		this.jsonStringToMap = jsonStringToMap;
	}
	
}
