package swt.scrum.project.service;

import swt.scrum.project.domain.Project;
import swt.scrum.project.domain.ProjectRepository;

import java.util.List;

public class ProjectServiceImpl  implements ProjectService {

    ProjectRepository projectRepository;


    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void addNewProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void removeProject(Project project) {
        projectRepository.delete(project);
    }
}
