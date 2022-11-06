package kodlama.io.kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{

//	void create(ProgrammingLanguage programmingLanguage);
//	void update(ProgrammingLanguage programmingLanguage);
//	void delete(ProgrammingLanguage programmingLanguage);
//	List<ProgrammingLanguage> getAll();
//	ProgrammingLanguage getById(int id);
	
	
}
