package com.projectSpring.projectspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectSpring.projectspring.dto.GameListDTO;
import com.projectSpring.projectspring.entities.GameList;
import com.projectSpring.projectspring.repositories.GameListRepository;


@Service											
public class GameListService {
	
	@Autowired										
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)								
	public List<GameListDTO> buscarGames(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}

}
