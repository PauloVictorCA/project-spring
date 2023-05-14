package com.projectSpring.projectspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectSpring.projectspring.dto.GameMinDTO;
import com.projectSpring.projectspring.entities.Game;
import com.projectSpring.projectspring.repositories.GameRepository;

@Service											//vai fazer com que a classe GameService fosse um componente do sistema
public class GameService {
	
	@Autowired										//mesma coisa do @Inject colocar uma instancia do GameRepository
	private GameRepository gameRepository;
	
	public List<GameMinDTO> buscarGames(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
}
