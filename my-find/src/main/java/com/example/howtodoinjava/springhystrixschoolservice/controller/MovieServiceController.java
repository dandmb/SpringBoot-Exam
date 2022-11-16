package com.example.howtodoinjava.springhystrixschoolservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.howtodoinjava.springhystrixschoolservice.delegate.MovieServiceDelegate;

@RestController
public class MovieServiceController {
	
	@Autowired
	MovieServiceDelegate movieServiceDelegate;

	@RequestMapping(value = "/getActors/{name}", method = RequestMethod.GET)
	public String getActorsByName(@PathVariable String name) {
		//System.out.println("Going to call movie service to get data!");
		return movieServiceDelegate.getActorData(name);
	}

	/*
	@RequestMapping(value = "/getActors/{name}", method = RequestMethod.GET)
	public String getActor(@PathVariable String name) {
		//System.out.println("Going to call movie service to get data!");
		return movieServiceDelegate.getActorData(name);
	}*/


	@RequestMapping(value = "/getActors", method = RequestMethod.GET)
	public String getActors() {

		return movieServiceDelegate.getAllActorData();
	}


	@RequestMapping(value = "/getFilms", method = RequestMethod.GET)
	public String getFilms() {

		return movieServiceDelegate.getFilmData();
	}

	@RequestMapping(value = "/getFilms/{name}", method = RequestMethod.GET)
	public String getFilms(@PathVariable(value = "name") String name) {

		return movieServiceDelegate.getFilm(name);
	}
	
}
