package com.example.springbootswagger2.controller;


import com.example.springbootswagger2.model.Acteur;
import com.example.springbootswagger2.model.Film;
import com.example.springbootswagger2.model.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "SwaggerMovieRestController", description = "REST Apis related to films and actors Entity")
@RestController
public class MovieServiceController {


  List<Film> films=new ArrayList<Film>();
  List<Acteur> acteurs = new ArrayList<Acteur>();
  {

    acteurs.add(new Acteur("Jason","Stattam","25/01/1980",null));
    acteurs.add(new Acteur("Matt","Daemon","25/01/1980",null));
    acteurs.add(new Acteur("Samuel","Jackson","25/01/1980",null));

    films.add(new Film("Halloween","Paul",acteurs.get(0),"31/12/2022"));
    films.add(new Film("ZOO","Pierr",acteurs.get(1),"12/08/2022"));
    films.add(new Film("Peace","Paul",acteurs.get(2),"01/06/2021"));

    //for(int i=0;i<acteurs.size();i++){
    //acteurs.get(0).setFilmographie(films);
    //}



  }
  @ApiOperation(value = "Get list of Actors in the System ", response = Iterable.class, tags = "getActors")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Suceess|OK"),
          @ApiResponse(code = 401, message = "not authorized!"),
          @ApiResponse(code = 403, message = "forbidden!!!"),
          @ApiResponse(code = 404, message = "not found!!!") })
  @RequestMapping(value = "/getActors")
  public List<Acteur> getActors() {
    return acteurs;
  }

  @ApiOperation(value = "Get specific Actor in the System ", response = Student.class, tags = "getActor")
  @RequestMapping(value = "/getActors/{name}")
  public Acteur getActorsByName(@PathVariable(value = "name") String name) {
    return acteurs.stream().filter(x -> x.getNom().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
  }


  @ApiOperation(value = "Get list of Films in the System ", response = Iterable.class, tags = "getFilms")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Suceess|OK"),
          @ApiResponse(code = 401, message = "not authorized!"),
          @ApiResponse(code = 403, message = "forbidden!!!"),
          @ApiResponse(code = 404, message = "not found!!!") })
  @RequestMapping(value = "/getFilms")
  public List<Film> getFilms() {
    return films;
  }

  @ApiOperation(value = "Get specific Film in the System ", response = Student.class, tags = "getFilm")
  @RequestMapping(value = "/getFilms/{name}")
  public Film getFilmsByTitle(@PathVariable(value = "name") String name) {
    return films.stream().filter(x ->x.getTitre().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);

  }

  /*
  @RequestMapping(value = "/getFilms/{name}")
  public Film getFilmsByYear(@PathVariable(value = "name") String name) {
    return films.stream().filter(x ->x.getTitre().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);

  }*/

}