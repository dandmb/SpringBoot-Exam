package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModelProperty;

public class Film {

    @ApiModelProperty(notes = "Title of the Movie",name="title",required=true,value="test title")
    private String titre;

    @ApiModelProperty(notes = "Manager' name",name="manager",required=true,value="test manager")
    private String realisateur;

    @ApiModelProperty(notes = "Name of the Actor",name="actor",required=true,value="test actor")
    private Acteur acteur_Principal;

    @ApiModelProperty(notes = "Release date",name="release",required=true,value="test release")
    private String date_de_sortie;

    public Film(String titre, String realisateur, Acteur acteur_Principal, String date_de_sortie) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.acteur_Principal = acteur_Principal;
        this.date_de_sortie = date_de_sortie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Acteur getActeur_Principal() {
        return acteur_Principal;
    }

    public void setActeur_Principal(Acteur acteur_Principal) {
        this.acteur_Principal = acteur_Principal;
    }

    public String getDate_de_sortie() {
        return date_de_sortie;
    }

    public void setDate_de_sortie(String date_de_sortie) {
        this.date_de_sortie = date_de_sortie;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", acteur_Principal=" + acteur_Principal +
                ", date_de_sortie='" + date_de_sortie + '\'' +
                '}';
    }
}