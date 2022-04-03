package swt.scrum.backlog.domain;

import lombok.Getter;
import lombok.Setter;
import swt.scrum.project.domain.Project;
import swt.scrum.user.domain.State;

import java.util.Date;
import java.util.UUID;


public class Task {
    private UUID taskId = UUID.randomUUID();
    private Project project;
    private String title;
    private String description;
    private State state;
    private double points;
    private Date createdDate;
    private Date updateDate;
    private Date closeDate;
    private String type;
    private int priority;

    public Task(Project project, String title, String description, State state, double points, Date createdDate, String type, int priority) {
        this.project = project;
        this.title = title;
        this.description = description;
        this.state = State.created;
        this.points = points;
        this.createdDate = new Date();;
        this.type = type;
        this.priority = priority;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public Project getProject() {
        return project;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public State getState() {
        return state;
    }

    public double getPoints() {
        return points;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public String getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
