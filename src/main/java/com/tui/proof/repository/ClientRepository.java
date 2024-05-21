package com.tui.proof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tui.proof.model.Client;
import java.util.List;



@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM client WHERE LOWER(first_name) like LOWER(CONCAT('%', ?1, '%')) or LOWER(last_name) like LOWER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    public List<Client> findAllByNameContaining(String name);

    public List<Client> findAll();
    
}
