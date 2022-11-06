package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageTechnologyService;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageTechnologyRequest.CreateProgrammingLanguageTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageTechnologyRequest.DeleteProgrammingLanguageTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageTechnologyRequest.UpdateProgrammingLanguageTechnologyRequest;
import kodlama.io.kodlama.io.Devs.business.responses.ProgrammingLanguageTechnologyResponse.GetAllProgrammingLanguageTechnologiesResponse;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageTechnologyRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguageTechnology;

@Service
public class ProgrammingLanguageTechnologyManager implements ProgrammingLanguageTechnologyService {

	private ProgrammingLanguageTechnologyRepository pLanguageTechnologyRepository;
	private ProgrammingLanguageRepository pLanguageRepository;

	@Autowired
	public ProgrammingLanguageTechnologyManager(ProgrammingLanguageTechnologyRepository pLanguageTechnologyRepository,
			ProgrammingLanguageRepository pLanguageRepository) {
		this.pLanguageTechnologyRepository = pLanguageTechnologyRepository;
		this.pLanguageRepository = pLanguageRepository;
	}

	@Override
	public void add(CreateProgrammingLanguageTechnologyRequest createProgrammingLanguageTechnologyRequest)
			throws Exception {
		ProgrammingLanguageTechnology pLTechnology = new ProgrammingLanguageTechnology();
		ProgrammingLanguage pLanguage = pLanguageRepository
				.findById(createProgrammingLanguageTechnologyRequest.getLanguageId()).get();
		pLTechnology.setProgrammingLanguage(pLanguage);
		pLTechnology.setName(createProgrammingLanguageTechnologyRequest.getName());
		pLanguageTechnologyRepository.save(pLTechnology);

	}

	@Override
	public void update(UpdateProgrammingLanguageTechnologyRequest updateProgrammingLanguageTechnologyRequest)
			throws Exception {
		ProgrammingLanguageTechnology pLanguageTechnology = pLanguageTechnologyRepository
				.findById(updateProgrammingLanguageTechnologyRequest.getId()).get();
		if (pLanguageTechnology.getName().equals(updateProgrammingLanguageTechnologyRequest.getName())) {
			throw new Exception("Girmiş olduğunuz teknoloji zaten eklenmiş");

		} else {
			pLanguageTechnology.setName(updateProgrammingLanguageTechnologyRequest.getName());
			pLanguageTechnologyRepository.save(pLanguageTechnology);
		}

	}

	@Override
	public void delete(DeleteProgrammingLanguageTechnologyRequest deleteProgrammingLanguageTechnologyRequest)
			throws Exception {

		pLanguageTechnologyRepository.deleteById(deleteProgrammingLanguageTechnologyRequest.getId());

	}

	@Override
	public List<GetAllProgrammingLanguageTechnologiesResponse> getAll() {
		List<ProgrammingLanguageTechnology> pLanguageTechnologies = pLanguageTechnologyRepository.findAll();
		List<GetAllProgrammingLanguageTechnologiesResponse> getAllProgrammingLanguageTechnologiesResponses = new ArrayList<GetAllProgrammingLanguageTechnologiesResponse>();
		
		for (ProgrammingLanguageTechnology programmingLanguageTechnology : pLanguageTechnologies) {
			GetAllProgrammingLanguageTechnologiesResponse responseItem = new GetAllProgrammingLanguageTechnologiesResponse();
			responseItem.setId(programmingLanguageTechnology.getId());
			responseItem.setName(programmingLanguageTechnology.getName());
			
			
			getAllProgrammingLanguageTechnologiesResponses.add(responseItem);
		}
		
		return getAllProgrammingLanguageTechnologiesResponses;
				
		
	}

}
