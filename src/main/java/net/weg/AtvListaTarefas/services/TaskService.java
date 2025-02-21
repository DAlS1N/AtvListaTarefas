package net.weg.AtvListaTarefas.services;


import net.weg.AtvListaTarefas.models.TaskModel;
import net.weg.AtvListaTarefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    /**
     * Método que retorna todas as tasks cadastradas
     * retorna todas as task dentro de uma lista
     * @return
     */
    public List<TaskModel> getAllTasks() {
        return repository.findAll();
    }


    /**
     * Método que a partir Modelo das classe task cria o objeto da classe em um banco de dados
     * puxando a task
     * @param task
     * criação da task
     * @return
     */
    public TaskModel createTask (TaskModel task){
        return repository.save(task);
    }

    /**
     * Método que procura uma task especificas a partir do id dela
     * puxando o parâmetro id
     * @param id
     * retornando a task
     * @return
     */
    public TaskModel getTaskByID(Integer id){
        return repository.findById(id).get();
    }

    /**
     * Método que serve para deletar uma task a partir do id dela
     * chamando o id
     * @param id
     * ele não precisar retornar por ser um método void
     */
    public void deleteTaskByID (Integer id){
         repository.deleteById(id);
    }

}
