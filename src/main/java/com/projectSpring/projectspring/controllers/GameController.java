package com.projectSpring.projectspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectSpring.projectspring.dto.GameDTO;
import com.projectSpring.projectspring.dto.GameMinDTO;
import com.projectSpring.projectspring.service.GameService;

@RestController									//Classe vira um controlador
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping								  //Get Pois é uma consulta
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.buscarGames();
		return result;
	}
	
	@GetMapping(value = "/{id}")							  //Get Pois é uma consulta
	public GameDTO findById(@PathVariable Long id){			  //PathVariable para casar as ID's	
		GameDTO result2 = gameService.findById(id);
		return result2;
	}
	
}

