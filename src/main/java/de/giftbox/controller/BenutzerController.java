package de.giftbox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import de.giftbox.dao.BenutzerDAO;
import de.giftbox.domain.Benutzer;
import de.giftbox.domain.Geschenk;
import de.giftbox.helper.JSONStringToMap;

@Controller
@RequestMapping("/benutzer/*")
public class BenutzerController {

	BenutzerDAO benutzerDao;
	JSONStringToMap jsonStringToMap;

	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);

	@RequestMapping(value = "all", method = RequestMethod.GET)
	private @ResponseBody
	List<Benutzer> getAllBenutzer() {
		log.debug("get all benutzer!");
		List<Benutzer> listBenutzer = benutzerDao.listBenutzer();
		return listBenutzer;
	}

//	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
//	public @ResponseBody
//	Benutzer findBenutzerById(@PathVariable(value = "id") Integer id) {
//		log.debug("Find Benutzer by ID " + id + "!");
//		Benutzer benutzer = new Benutzer();
//		benutzer = benutzerDao.findBenutzerById(id);
//		// log.debug("Test: " + benutzer.getIdBenutzer().toString());
//		return benutzer;
//	}

	@RequestMapping(value = "username/{username}", method = RequestMethod.GET)
	public @ResponseBody
	Benutzer findBenutzerByUsername(
			@PathVariable(value = "name") String username) {
		log.debug("Find Benutzer by Name " + username + "!");
		Benutzer benutzer = new Benutzer();
		benutzer = benutzerDao.findBenutzerByUsername(username);
		return benutzer;
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public @ResponseBody
	String postBenutzer(@RequestBody String json) {
		Benutzer b = new Benutzer();
		log.debug(json.toString());

		Gson gson = new Gson();
		b = gson.fromJson(json, Benutzer.class);

		log.debug(b.toString());
		// Map<String, Object> jsonMap = jsonStringToMap.convertToMap(json);
		//
		// b.setUsername(jsonMap.get("username").toString());
		// b.setPasswort(jsonMap.get("passwort").toString());
		// b.setKommentar(jsonMap.get("kommentar").toString());
		// b.setEmail(jsonMap.get("email").toString());

		log.info("testing Post \"Benutzer\":" + b.toString() + " to DB");
		Boolean geklappt = false;
		try {
			benutzerDao.saveBenutzer(b);
			geklappt = true;
			log.info("neuen Benutzer in die DB geschrieben!");
		} catch (Exception ex) {

			ex.printStackTrace();
			geklappt = false;
			log.error("saveBenutzer hat nicht funktioniert");

		}

		return geklappt.toString();

	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String getBenutzerById(@PathVariable(value = "id") Integer id) {

		Benutzer b = benutzerDao.getBenutzerById(id);

		Gson gson = new Gson();
		String json = gson.toJson(b, Benutzer.class);

		return json;
	}

	public void setBenutzerDAO(BenutzerDAO benutzerDao) {
		this.benutzerDao = benutzerDao;
	}
}
