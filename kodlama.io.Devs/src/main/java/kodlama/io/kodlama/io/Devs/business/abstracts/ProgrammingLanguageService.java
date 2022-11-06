package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageRequest.CreateProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageRequest.DeleteProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.requests.programmingLanguageRequest.UpdateProgrammingLanguageRequest;
import kodlama.io.kodlama.io.Devs.business.responses.ProgrammingLanguageResponse.GetAllProgrammingLanguagesResponse;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;

	void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception;

	List<GetAllProgrammingLanguagesResponse> getAll();
	// ProgrammingLanguage getById(int id);
}
