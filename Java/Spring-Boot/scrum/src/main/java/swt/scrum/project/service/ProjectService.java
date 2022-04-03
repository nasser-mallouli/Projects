package swt.scrum.project.service;


import swt.scrum.project.domain.Project;

import java.util.List;

public interface ProjectService {


    List<Project> getAllProjects();

    void addNewProject(Project project);

    void removeProject(Project project);


}
