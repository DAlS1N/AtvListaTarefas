package net.weg.AtvListaTarefas.services;


import net.weg.AtvListaTarefas.models.TaskModel;
import net.weg.AtvListaTarefas.models.UserModel;
import net.weg.AtvListaTarefas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    /*
    @Return User
     */


    public List<UserModel> getAllUser(){
      return userRepository.findAll();

    }

    public UserModel createModel (UserModel user){
        return userRepository.save(user);
    }


}
