package com.projectSpring.projectspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectSpring.projectspring.dto.GameListDTO;
import com.projectSpring.projectspring.dto.GameMinDTO;
import com.projectSpring.projectspring.dto.SubstituiDTO;
import com.projectSpring.projectspring.service.GameListService;
import com.projectSpring.projectspring.service.GameService;

@RestController									//Classe vira um controlador
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping								  //Get Pois é uma consulta
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.buscarGames();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")			  
	public List<GameMinDTO> findByList(@PathVariable long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/substitui")			  
	public void moverObjeto(@PathVariable long listId, @RequestBody SubstituiDTO body){
		gameListService.moverObjeto(listId, body.getIndexOrigem(), body.getIndexDestino());
		
	}
	
}

