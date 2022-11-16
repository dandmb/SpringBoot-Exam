package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Acteur {

    @ApiModelProperty(notes = "Name of the Actor",name="name",required=true,value="test name")
    private String nom;
    @ApiModelProperty(notes = "Surname of the Actor",name="surname",required=true,value="test surname")
    private String prenom;
    @ApiModelProperty(notes = "Birthday of the Actor",name="birthday",required=true,value="test birthday")
    private String date_naissance;
    @ApiModelProperty(notes = "List of films of the Actor",name="film list",required=true,value="test film list")
    private List<Film> filmographie;

    public Acteur(String nom, String prenom, String date_naissance, List<Film> filmographie) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.filmographie = filmographie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public List<Film> getFilmographie() {
        return filmographie;
    }

    public void setFilmographie(List<Film> filmographie) {
        this.filmographie = filmographie;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance='" + date_naissance + '\'' +
                ", filmographie=" + filmographie +
                '}';
    }

}