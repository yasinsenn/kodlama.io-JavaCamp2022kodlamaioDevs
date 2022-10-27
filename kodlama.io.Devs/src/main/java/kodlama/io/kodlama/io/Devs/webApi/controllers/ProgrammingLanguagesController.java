package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/create")
	public void create(ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.create(programmingLanguage);
	}
	

	@GetMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage) {
		programmingLanguageService.update(programmingLanguage);
	}
	
	
	@GetMapping("/delete")
	public void delete(ProgrammingLanguage programmingLanguage) {
		programmingLanguageService.delete(programmingLanguage);
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageService.getById(id);
	}
	
	
	
	
}
