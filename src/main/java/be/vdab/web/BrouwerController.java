package be.vdab.web;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping(path = "/brouwers", produces = MediaType.TEXT_HTML_VALUE)
class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BEGIN_NAAM_VIEW = "brouwers/beginnaam";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String ALFABET_VIEW = "brouwers/opalfabet";
	private final static String REDIRECT_NA_TOEVOEGEN = "redirect:/";

	private final char[] alfabet = new char['Z' - 'A' + 1];

	private final BrouwerService brouwerService;

	BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			alfabet[letter - 'A'] = letter;
		}
	}

	@GetMapping
	ModelAndView brouwers(Pageable pageable) {
	return new ModelAndView(BROUWERS_VIEW,
	"page", brouwerService.findAll(pageable));
	}

	@GetMapping("beginnaam")
	ModelAndView beginNaamForm() {
		return new ModelAndView(BEGIN_NAAM_VIEW).addObject(new BeginNaamForm());
	}

	@GetMapping(params = "beginnaam")
	ModelAndView beginNaam(@Valid BeginNaamForm form, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(BEGIN_NAAM_VIEW);
		if (!bindingResult.hasErrors()) {
			modelAndView.addObject("brouwers", brouwerService.findByNaam(form.getBeginnaam()));
		}
		return modelAndView;
	}

	@GetMapping("toevoegen")
	ModelAndView toevoegen() {
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Brouwer());
	}

	@PostMapping
	String toevoegen(@Valid Brouwer brouwer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return TOEVOEGEN_VIEW;
		}
		brouwerService.create(brouwer);
		return REDIRECT_NA_TOEVOEGEN;
	}

	@InitBinder("brouwer")
	void initBinderPostcodeReeks(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}

	@GetMapping("opalfabet")
	ModelAndView opAlfabetForm() {
		return new ModelAndView(ALFABET_VIEW, "alfabet", alfabet);
	}

	@GetMapping("opalfabet/{letter}")
	ModelAndView opAlfabet(@PathVariable char letter) {
		return new ModelAndView(ALFABET_VIEW).addObject("alfabet", alfabet).addObject("brouwers",
				brouwerService.findByNaam(String.valueOf(letter)));
	}
}
