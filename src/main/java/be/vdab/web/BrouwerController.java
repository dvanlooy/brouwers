package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brouwers")
class WerknemerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGIN_NAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	
	@GetMapping
	String findAll() {
		return BROUWERS_VIEW;
	}
	
	@GetMapping("beginnaam")
	String beginNaam() {
		return BEGIN_NAAM_VIEW;
	}
	
	@GetMapping("toevoegen")
	String toevoegen() {
	return TOEVOEGEN_VIEW;
	}
}
