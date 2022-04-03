package swt.scrum.user.domain;

import jakarta.persistence.Id;
import swt.scrum.project.domain.Project;

import java.util.Date;

public class Member extends  User {
    @Id
    private Project project;
    private Date createdDate;
    private Date finishedDate;

    public Project getProject() {
        return project;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }
}
