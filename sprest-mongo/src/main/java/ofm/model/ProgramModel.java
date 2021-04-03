package ofm.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EntityScan
@Document(collection = "Workouts")
public class ProgramModel {
    @Id
    private Integer id;
    private String name;
    private String link;
    private String label;
    private String[][] steps;
    
    
    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String[][] getSteps() {
		return steps;
	}

	public void setSteps(String[][] steps) {
		this.steps = steps;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
