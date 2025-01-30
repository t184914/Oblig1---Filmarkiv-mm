package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	
	

	private int filmNr; 
	private String filmSkaper;
	private String tittel;
	private int lanseringsÅr;
	private Sjanger sjanger;
	private String filmSelskap;
	
	public Film() {
		this.filmNr = 0;	 this.filmSkaper = "";
		this.tittel = "";	 this.lanseringsÅr = 0;
		this.sjanger = null; this.filmSelskap = "";
		
		
		
	}
	
	public Film(int filmNr, String filmSkaper, String tittel, int lanseringsÅr, Sjanger sjanger, String filmSelskap) {
		
		this.filmNr = filmNr; this.filmSkaper = filmSkaper; 
		this.tittel = tittel; this.lanseringsÅr = lanseringsÅr;
		this.sjanger = sjanger; 
		this.filmSelskap = filmSelskap;
		
	}
	
	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}
	
	public int getFilmNr() {
		return filmNr;	
	}
	
	public void setFilmSkaper(String filmSkaper) {
		this.filmSkaper = filmSkaper;
	}
	
	public String getFilmSkaper() {
		return filmSkaper;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public String getTittel() {
		return tittel;
	}

	public void setLanseringsÅr(int lanseringsÅr) {
		this.lanseringsÅr = lanseringsÅr;
	}
	
	public int getLanseringsÅr() {
		return lanseringsÅr;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public Sjanger getSjanger(){
		return sjanger;
	}
	
	

	
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmNr == film.filmNr;
    }	
	
	@Override
	public int hashCode() {
		return Objects.hash(filmNr);
	}
	
	public String toString() {
        return "Film{" +
                "filmNr=" + filmNr +
                ", produsent='" + filmSkaper + '\'' +
                ", tittel='" + tittel + '\'' +
                ", lanseringsår=" + lanseringsÅr +
                ", sjanger=" + sjanger +
                ", filmselskap='" + filmSelskap + '\'' +
                '}';
    }
}
	
