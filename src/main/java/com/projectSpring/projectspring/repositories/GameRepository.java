package com.projectSpring.projectspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectSpring.projectspring.entities.Game;

// Faz a Consulta no banco de dados.

public interface GameRepository extends JpaRepository <Game, Long> {

}
