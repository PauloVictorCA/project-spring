package com.projectSpring.projectspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectSpring.projectspring.entities.GameList;

// Faz a Consulta no banco de dados.

public interface GameListRepository extends JpaRepository <GameList, Long> {

}