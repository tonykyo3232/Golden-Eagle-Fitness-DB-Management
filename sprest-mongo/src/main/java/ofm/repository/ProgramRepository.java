package ofm.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ofm.model.ProgramModel;

@Repository
public interface ProgramRepository extends MongoRepository < ProgramModel, Integer > {
    // return a program that matches this label 
	List<ProgramModel> findByLabel(String label);
}
