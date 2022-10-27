package kodlama.io.kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;

	@Autowired
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Dart"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Go"));
	}

	@Override
	public void create(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
		

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {

		for (ProgrammingLanguage pLanguage : programmingLanguages) {
			if (pLanguage.getId() == programmingLanguage.getId()) {
				pLanguage.setName(programmingLanguage.getName());
			}
		}

	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.remove(programmingLanguage.getId() - 1);

	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		ProgrammingLanguage pL = null;
		
		for (ProgrammingLanguage pLanguage : programmingLanguages) {
			if (pLanguage.getId() == id) {
				pL = pLanguage;
			}
		}
		return pL;
	}

}
