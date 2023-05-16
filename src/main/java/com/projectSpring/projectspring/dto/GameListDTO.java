package com.projectSpring.projectspring.dto;

import com.projectSpring.projectspring.entities.GameList;

public class GameListDTO {

	private Long id;
	private String name;
	
	GameListDTO(){
	}

	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
