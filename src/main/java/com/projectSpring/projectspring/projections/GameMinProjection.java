package com.projectSpring.projectspring.projections;

public interface GameMinProjection {		//Para Cada elemento da consulta tem que ter 
	
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImrUrl();
	String getShortDescription();
	Integer getPosition();

}
