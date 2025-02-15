package net.weg.AtvListaTarefas.services;


import net.weg.AtvListaTarefas.models.TaskModel;
import net.weg.AtvListaTarefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    /**
     *
     * @return Task
     */

    public List<TaskModel> getAllTasks() {
        return repository.findAll();
    }


    public TaskModel createTask (TaskModel task){
        return repository.save(task);
    }



}
