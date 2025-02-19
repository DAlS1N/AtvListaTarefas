package net.weg.AtvListaTarefas.repository;

import net.weg.AtvListaTarefas.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
}
