package net.weg.AtvListaTarefas.controllers;

import net.weg.AtvListaTarefas.models.TaskModel;
import net.weg.AtvListaTarefas.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;


    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTask(){

        List<TaskModel> tasks = service.getAllTasks();
        return ResponseEntity.ok(tasks);

    }

    @PostMapping
    public TaskModel CreateTask(@RequestBody TaskModel task){
        return service.createTask(task);
    }

}
