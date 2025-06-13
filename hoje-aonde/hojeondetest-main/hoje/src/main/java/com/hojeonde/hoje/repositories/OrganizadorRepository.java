package com.hojeonde.hoje.repositories;

import com.hojeonde.hoje.models.Organizador;
import com.hojeonde.hoje.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, String> {
}
