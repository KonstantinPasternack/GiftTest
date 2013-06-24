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

import de.giftbox.dao.BenutzerFreundeDAO;
import de.giftbox.domain.BenutzerFreunde;
import de.giftbox.helper.JSONStringToMap;

@Controller
@RequestMapping("/friend/*")
public class BenutzerFreundeController {

	BenutzerFreundeDAO benutzerFreundeDao;
	JSONStringToMap jsonStringToMap;

	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);

	@RequestMapping(value = "all", method = RequestMethod.GET)
	private @ResponseBody
	List<BenutzerFreunde> getAllBenutzerFreunde() {
		log.debug("get all benutzer!");
		List<BenutzerFreunde> listBenutzerFreunde = benutzerFreundeDao.listBenutzerFreund();
		return listBenutzerFreunde;
	}

	// @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	// public @ResponseBody
	// Benutzer findBenutzerById(@PathVariable(value = "id") Integer id) {
	// log.debug("Find Benutzer by ID " + id + "!");
	// Benutzer benutzer = new Benutzer();
	// benutzer = benutzerDao.findBenutzerById(id);
	// // log.debug("Test: " + benutzer.getIdBenutzer().toString());
	// return benutzer;
	// }

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public @ResponseBody
	String postBenutzerFreund(@RequestBody String json) {
		BenutzerFreunde bf= new BenutzerFreunde();
		log.debug(json.toString());

		Gson gson = new Gson();
		bf = gson.fromJson(json, BenutzerFreunde.class);

		log.debug(bf.toString());
		// Map<String, Object> jsonMap = jsonStringToMap.convertToMap(json);
		//
		// b.setUsername(jsonMap.get("username").toString());
		// b.setPasswort(jsonMap.get("passwort").toString());
		// b.setKommentar(jsonMap.get("kommentar").toString());
		// b.setEmail(jsonMap.get("email").toString());

		log.info("testing Post \"BenutzerFreunde\":" + bf.toString() + " to DB");
		Boolean geklappt = false;
		try {
			benutzerFreundeDao.saveBenutzerFreund(bf);
			geklappt = true;
			log.info("neuen BenutzerFreund in die DB geschrieben!");
		} catch (Exception ex) {

			ex.printStackTrace();
			geklappt = false;
			log.error("saveBenutzerFreund hat nicht funktioniert");

		}

		return geklappt.toString();

	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String getBenutzerFreundById(@PathVariable(value = "id") Integer id) {

		BenutzerFreunde bf = benutzerFreundeDao.getBenutzerFreundById(id);

		Gson gson = new Gson();
		String json = gson.toJson(bf, BenutzerFreunde.class);

		return json;
	}

	@RequestMapping(value = "username/{username}", method = RequestMethod.GET)
	public @ResponseBody
	String findBenutzerFreundByUsername(@PathVariable(value = "name") String username) {

		BenutzerFreunde bf = benutzerFreundeDao.findBenutzerFreundByUsername(username);

		Gson gson = new Gson();
		String json = gson.toJson(bf, BenutzerFreunde.class);

		return json;
	}

	public void setBenutzerFreundeDAO(BenutzerFreundeDAO benutzerFreundeDao) {
		this.benutzerFreundeDao = benutzerFreundeDao;
	}

	public void setJSONStringToMap(JSONStringToMap jsonStringToMap) {
		this.jsonStringToMap = jsonStringToMap;
	}
}
