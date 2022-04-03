package swt.scrum.backlog.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    private String tag;
    private Task task;
    private String description;

    public String getTag() {
        return tag;
    }

    public Task getTask() {
        return task;
    }

    public String getDescription() {
        return description;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
