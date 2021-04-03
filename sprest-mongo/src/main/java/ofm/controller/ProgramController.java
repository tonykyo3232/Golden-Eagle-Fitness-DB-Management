package ofm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ofm.model.IdModel;
import ofm.model.ProgramModel;
import ofm.repository.IdRepository;
import ofm.repository.ProgramRepository;

@CrossOrigin
@RestController
@RequestMapping("/workout")
public class ProgramController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProgramRepository programRepository;
	
	@Autowired
	private IdRepository idRepository;
	
	public ProgramController(ProgramRepository entry_programRepository, IdRepository entry_idRepository) {
		this.programRepository = entry_programRepository;
		this.idRepository = entry_idRepository;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<ProgramModel> getAllWorkouts() {
		logger.info("Getting all workouts.");
		return programRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProgramModel CreateWorkout(@RequestBody ProgramModel workout) {
		logger.info("Saving workout program...");
		
		// get Id class
		IdModel id = idRepository.findById(1).get();
		workout.setId(id.getValue());
		
		// update id
		Integer nextId = id.getValue();
		nextId++;
		id.setValue(nextId);
		idRepository.save(id);
		
		return programRepository.save(workout);
	}
	
	@GetMapping("/{label}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<ProgramModel> getAllWorkouts(@PathVariable String label) {
		logger.info("Getting the workout with label " + label);
		return programRepository.findByLabel(label);
	}
	
}
