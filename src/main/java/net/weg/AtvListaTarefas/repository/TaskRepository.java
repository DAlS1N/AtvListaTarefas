package net.weg.AtvListaTarefas.repository;

import net.weg.AtvListaTarefas.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Integer> {
}
