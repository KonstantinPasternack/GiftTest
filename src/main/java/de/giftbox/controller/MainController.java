package de.giftbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.giftbox.domain.Geschenk;

@Controller
@RequestMapping("/*")
public class MainController {
	
	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	@ResponseBody
	public Geschenk home() {
		log.debug("Giftbox Server Home");
		Geschenk geschenk = new Geschenk("TESTGESCHENK");
		
		return geschenk;
		
	}
}