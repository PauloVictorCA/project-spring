package com.projectSpring.projectspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectSpring.projectspring.dto.GameListDTO;
import com.projectSpring.projectspring.entities.GameList;
import com.projectSpring.projectspring.projections.GameMinProjection;
import com.projectSpring.projectspring.repositories.GameListRepository;
import com.projectSpring.projectspring.repositories.GameRepository;


@Service											
public class GameListService {
	
	@Autowired										
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)								
	public List<GameListDTO> buscarGames(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	@Transactional
	public void moverObjeto (Long listId, int indexOrigem, int indexDestino) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection objRemovido = list.remove(indexOrigem);
		list.add(indexDestino, objRemovido);
		
		int indexMin = indexOrigem < indexDestino ? indexOrigem : indexDestino;
		int indexMax = indexOrigem > indexDestino ? indexOrigem : indexDestino;
		
		for (int i=indexMin ; i< indexMax ; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}

}
