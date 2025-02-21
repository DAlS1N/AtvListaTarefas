package net.weg.AtvListaTarefas.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.weg.AtvListaTarefas.models.TaskModel;
import net.weg.AtvListaTarefas.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



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
    @Tag(name = "Tarefas", description = "Operações relacionadas a Tarefas") // Agrupa endpoints relacionados
    @Operation(summary = "Cria uma nova tarefa", description = "Retorna a tarefa que foi criada") // Descreve o endpoint
    @ApiResponse(responseCode = "201", description = "Tarefa criado com sucesso",
    content = @Content(schema = @Schema(implementation = TaskModel.class),
    examples = @ExampleObject(value = "{\"titulo\": \"Limpar aquário\", \"descricao\": \"O aquário está muito sujo por favor limpar\"}"))) // Exemplo de resposta
    @ApiResponse(responseCode = "400", description = "Requisição inválida") // Resposta para erro de requisição
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor") // Resposta para erro interno
    @SecurityRequirement(name = "bearerAuth") // Requisito de segurança (autenticação)
    public ResponseEntity<TaskModel> CreateTask(@RequestBody
    @Parameter(description = "Task a ser criada", required = true,
    content = @Content(schema = @Schema(implementation = TaskModel.class)))
    TaskModel task){
            return new ResponseEntity<>(service.createTask(task), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public TaskModel FoundTaskById(Integer id){
        return service.getTaskByID(id);
    }

    @DeleteMapping
    public void DeleteById(Integer id){
         service.deleteTaskByID(id);
        System.out.println("Conta deletada");
    }


}
