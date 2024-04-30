package com.example.demo.model;

import org.springframework.data.annotation.Id;


public class Booking
{
    private @Id Integer id;
    private String film;
    private Integer antall;
    private String fornavn;
    private String etternavn;
    private Integer telefonnr;
    private String epost;

    public Booking(Integer id, String film, Integer antall, String fornavn, String etternavn, Integer telefonnr, String epost) {
        this.id = id;
        this.film = film;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonnr = telefonnr;
        this.epost = epost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Booking() {
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public Integer getAntall() {
        return antall;
    }

    public void setAntall(Integer antall) {
        this.antall = antall;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public Integer getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(Integer telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
}
