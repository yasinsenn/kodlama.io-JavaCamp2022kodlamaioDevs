package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageRequest.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageTechnologyRequest.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageTechnologyRequest.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageTechnologyRequest.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.ProgrammingLanguageTechnologyResponse.GetAllProgrammingLanguageTechnologiesResponse;

@RestController
@RequestMapping("/api/programminglanguagetechnologies")
public class ProgrammingLanguageTechnologiesController {

	private ProgrammingLanguageTechnologyService pLanguageTechnologyService;

	@Autowired
	public ProgrammingLanguageTechnologiesController(ProgrammingLanguageTechnologyService pLanguageTechnologyService) {
		this.pLanguageTechnologyService = pLanguageTechnologyService;
	}

	@GetMapping("/getAll")
	public List<GetAllProgrammingLanguageTechnologiesResponse> getAll() {
		return pLanguageTechnologyService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest)
			throws Exception {
		pLanguageTechnologyService.add(createProgrammingLanguageTechnologyRequest);

	}
	
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest) throws Exception {
		pLanguageTechnologyService.update(updateProgrammingLanguageTechnologyRequest);
		
	}

	@DeleteMapping("/delete")
	public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest) throws Exception {
		pLanguageTechnologyService.delete(deleteProgrammingLanguageTechnologyRequest);
	}
}
