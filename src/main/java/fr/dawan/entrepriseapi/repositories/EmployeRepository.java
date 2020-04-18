package fr.dawan.entrepriseapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entrepriseapi.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

    @Query("SELECT e FROM Employe e where e.login = :login AND e.password = :password") 
    Employe findByLogin(@Param("login") String login, @Param("password") String password);
}
