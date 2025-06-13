package com.hojeonde.hoje.repositories;

import com.hojeonde.hoje.models.User;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

     void deleteById(Long id);

     Optional<User> findById(Long id);

     Optional<User> findById(SingularAttribute<AbstractPersistable, Serializable> id);
}
