package de.giftbox.controller;

import java.util.ArrayList;
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
import com.google.gson.GsonBuilder;

import de.giftbox.dao.GeschenklisteDAO;
import de.giftbox.domain.Benutzer;
import de.giftbox.domain.Geschenk;
import de.giftbox.domain.Geschenkliste;
import de.giftbox.domain.GeschenklisteHasGeschenk;
import de.giftbox.helper.GeschenkAdapter;
import de.giftbox.helper.GeschenklisteAdapter;
import de.giftbox.helper.JSONStringToMap;

@Controller
@RequestMapping("/geschenkliste/*")
public class GeschenklisteController {

	GeschenklisteDAO geschenklisteDao;
	JSONStringToMap jsonStringToMap;

	private static final Logger log = LoggerFactory
			.getLogger(GeschenklisteController.class);

	@RequestMapping(value = "all", method = RequestMethod.GET)
	private @ResponseBody
	String getAllGeschenkliste() {
		log.debug("get all geschenklisten!");
		List<Geschenkliste> listGeschenkliste = geschenklisteDao
				.listGeschenkliste();
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Geschenkliste.class,
				new GeschenklisteAdapter()).create();
		return gson.toJson(listGeschenkliste);
	}
	
	

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String getGeschenklisteById(@PathVariable(value = "id") Integer id) {

		Geschenkliste geschenkliste = geschenklisteDao.getGeschenklisteById(id);

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Geschenkliste.class,
				new GeschenklisteAdapter()).create();
		return gson.toJson(geschenkliste);

	}
	
	@RequestMapping(value = "get/{id}/geschenke", method = RequestMethod.GET)
	public @ResponseBody
	String getGeschenkeOfGeschenklisteById(@PathVariable(value = "id") Integer id) {

		Geschenkliste geschenkliste = geschenklisteDao.getGeschenklisteById(id);

		List<Geschenk> geschenke = new ArrayList<Geschenk>();
		for(GeschenklisteHasGeschenk glhg:geschenkliste.getGeschenklisteHasGeschenk()) {
			geschenke.add(glhg.getGeschenk());
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Geschenkliste.class,
				new GeschenkAdapter()).create();
		return gson.toJson(geschenke);

	}
	
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public @ResponseBody
	String postGeschenkliste(@RequestBody String json) {
		System.out.println("---------------------------------GESCHENKLISTE_CONTROLLER----------------------------");
		Geschenkliste gl = new Geschenkliste();
		log.debug(json.toString());

		Gson gson = new Gson();
		gl = gson.fromJson(json, Geschenkliste.class);

		log.debug(gl.toString());
		log.debug(new Gson().toJson(gl));
		log.info("testing Post \"Geschenliste\":" + gl.toString() + " to DB");
		Boolean geklappt = false;
		try {
			geschenklisteDao.saveGeschenkliste(gl);
			geklappt = true;
			log.info("neue Geschenkliste in die DB geschrieben!");
		} catch (Exception ex) {

			ex.printStackTrace();
			geklappt = false;
			log.error("saveGeschenkliste hat nicht funktioniert");

		}

		return geklappt.toString();

	}
	
	@RequestMapping(value = "byuser/{id}", method=RequestMethod.GET)
	public @ResponseBody
	String findFriendsByBenutzerId(@PathVariable(value="id") Integer id){
		
		List<Geschenkliste>gsl = geschenklisteDao.getGeschenklisteByUserId(id);
		
//		Gson gson = new Gson();
//		String json = gson.toJson(gsl);
//		return json;
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Geschenkliste.class,
				new GeschenklisteAdapter()).create();
		return gson.toJson(gsl);

	}

	public void setGeschenklisteDAO(GeschenklisteDAO geschenklisteDao) {
		this.geschenklisteDao = geschenklisteDao;
	}

	public void setJSONStringToMap(JSONStringToMap jsonStringToMap) {
		this.jsonStringToMap = jsonStringToMap;
	}

}
