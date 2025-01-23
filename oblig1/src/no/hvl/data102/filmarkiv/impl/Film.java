package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.test.Film;

public class Film {

	private int filmNr; 
	private String filmSkaper;
	private String tittel;
	private int lanseringsÅr;
	private String sjanger;
	private String filmSelskap;
	
	public Film() {
		this.filmNr = 0;	this.filmSkaper = "";
		this.tittel = "";	this.lanseringsÅr = 0;
		this.sjanger = "";	this.filmSelskap = "";
		
		
		
	}
	
	public Film(int filmNr, String filmSkaper, String tittel, int lanseringsÅr, String sjanger, String filmSelskap) {
		
		this.filmNr = filmNr; this.filmSkaper = filmSkaper; 
		this.tittel = tittel; this.lanseringsÅr = lanseringsÅr;
		this.sjanger = sjanger; this.filmSelskap = filmSelskap;
		
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
	
	public void setSjanger(String sjanger) {
		this.sjanger = sjanger;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Film that = (Film) obj;
		
		if (filmSkaper != that.filmSkaper) return false;
		if ()
		return filmNr.equals(that.filmNr);
	}	
	
	@Override
	public int hashCode() {
		int resultat = filmNr == null ? 0 : filmNr.hashCode();
		resultat = resultat + filmSkaper;
		
		return resultat;
	}
	
}
