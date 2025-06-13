package com.hojeonde.hoje.services;

import com.hojeonde.hoje.models.User;
import com.hojeonde.hoje.models.UserRequestDTO;
import com.hojeonde.hoje.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long UUID) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new IllegalArgumentException("Usuário com ID " + id + " não encontrado.");
        }
    }



    public UUID userRequest(UserRequestDTO userRequestDTO) {
        var entity =   new User (
                userRequestDTO.email(),
                userRequestDTO.senha(),
                userRequestDTO.telefone(),
                Instant.now()
                );
        var UserSaved = userRepository.save(entity);
        return UserSaved.getIdUser();}


    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException
                    ("Não é possível deletar. Usuário com ID " + id + " não encontrado.");
        }
    }
}
