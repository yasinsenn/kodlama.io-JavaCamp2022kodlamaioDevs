package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageRequest.CreateProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageRequest.DeleteProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageRequest.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.responses.ProgrammingLanguageResponse.GetAllProgrammingLanguagesResponse;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		ProgrammingLanguage pLanguage = new ProgrammingLanguage();

		for (ProgrammingLanguage language : programmingLanguageRepository.findAll()) {
			if (language.getName().equals(createProgrammingLanguageRequest.getName())) {
				throw new Exception("Girmiş olduğunuz dil zaten eklenmiş");
			} else if (createProgrammingLanguageRequest.getName().isEmpty()
					|| createProgrammingLanguageRequest.getName().isBlank()) {
				throw new Exception("Dil adı girilmesi zorunludur boş bırakılamaz");
			}
		}

		pLanguage.setName(createProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(pLanguage);

	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		ProgrammingLanguage pLanguage = programmingLanguageRepository.findById(updateProgrammingLanguageRequest.getId())
				.get();
		if (pLanguage.getName().equals(updateProgrammingLanguageRequest.getName())) {
			throw new Exception("Girmiş olduğunuz dil zaten eklenmiş");
		} else {
			pLanguage.setName(updateProgrammingLanguageRequest.getName());
			programmingLanguageRepository.save(pLanguage);
		}

	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {

		programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());

	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {

		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());

			getAllProgrammingLanguagesResponses.add(responseItem);
		}

		return getAllProgrammingLanguagesResponses;
	}

}
