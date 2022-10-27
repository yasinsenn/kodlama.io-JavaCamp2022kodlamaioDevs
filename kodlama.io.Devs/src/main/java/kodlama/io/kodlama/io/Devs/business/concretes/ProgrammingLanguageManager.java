package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
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
	public void create(ProgrammingLanguage programmingLanguage) throws Exception {

		for (ProgrammingLanguage pLanguage : this.programmingLanguageRepository.getAll()) {
			if (pLanguage.getName() == programmingLanguage.getName()) {
				throw new Exception("Girmiş olduğunuz programlama dili mevcut, tekrar girilemez");
			}
		}

		if (programmingLanguage.getName() == null) {
			throw new Exception("İsim boş bırakılamaz...");
		}

		programmingLanguageRepository.create(programmingLanguage);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		programmingLanguageRepository.update(programmingLanguage);

	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		programmingLanguageRepository.delete(programmingLanguage);

	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {

		return programmingLanguageRepository.getById(id);
	}

}
