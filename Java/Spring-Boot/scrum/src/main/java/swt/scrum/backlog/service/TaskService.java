package swt.scrum.backlog.service;

import swt.scrum.backlog.domain.Task;
import swt.scrum.user.domain.State;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<Task> getAllTaks();

    void addNewTask(Task task);

    void removeTask(Task task);



}
