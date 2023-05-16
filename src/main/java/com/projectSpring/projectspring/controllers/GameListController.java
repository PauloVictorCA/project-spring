package com.projectSpring.projectspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectSpring.projectspring.dto.GameListDTO;
import com.projectSpring.projectspring.service.GameListService;

@RestController									//Classe vira um controlador
@RequestMapping(value = "/list")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@GetMapping								  //Get Pois é uma consulta
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.buscarGames();
		return result;
	}
}

