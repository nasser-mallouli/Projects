package swt.scrum.backlog.service;

import swt.scrum.backlog.domain.Task;
import swt.scrum.backlog.domain.TaskRepository;

import java.util.List;

public class TaskServiceImpl implements TaskService{

    TaskRepository taskRepository;

    @Override
    public List<Task> getAllTaks() {
        return taskRepository.findAll();
    }

    @Override
    public void addNewTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void removeTask(Task task) {
        taskRepository.delete(task);
    }


}
