package com.projectSpring.projectspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectSpring.projectspring.dto.GameDTO;
import com.projectSpring.projectspring.dto.GameMinDTO;
import com.projectSpring.projectspring.entities.Game;
import com.projectSpring.projectspring.projections.GameMinProjection;
import com.projectSpring.projectspring.repositories.GameRepository;


@Service											//vai fazer com que a classe GameService fosse um componente do sistema
public class GameService {
	
	@Autowired										//mesma coisa do @Inject colocar uma instancia do GameRepository
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)								
	public List<GameMinDTO> buscarGames(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)								
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
}
