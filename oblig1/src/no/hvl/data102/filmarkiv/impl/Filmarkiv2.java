package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        this.antall = 0;
        this.start = null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.neste = start;
        start = nyNode;
        antall++;
    }
    public Film[] hentFilmTabell() {
        Film[] filmer = new Film[antall];
        LinearNode<Film> current = start;
        int i = 0;

        while (current != null) {
            filmer[i++] = current.data;
            current = current.neste;
        }

        return filmer;
    }

    @Override
    public boolean slettFilm(int filmNr) {
        if (start == null) return false;

        if (start.data.getFilmNr() == filmNr) {
            start = start.neste;
            antall--;
            return true;
        }

        LinearNode<Film> forrige = start;
        LinearNode<Film> current = start.neste;

        while (current != null) {
            if (current.data.getFilmNr() == filmNr) {
                forrige.neste = current.neste;
                antall--;
                return true;
            }
            forrige = current;
            current = current.neste;
        }
        return false;
    }

    @Override
    public Film finnFilm(int filmNr) {
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getFilmNr() == filmNr) {
                return current.data;
            }
            current = current.neste;
        }
        return null;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        LinearNode<Film> current = start;
        int teller = 0;

        while (current != null) {
            if (current.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                teller++;
            }
            current = current.neste;
        }

        Film[] resultat = new Film[teller];
        current = start;
        teller = 0;

        while (current != null) {
            if (current.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                resultat[teller++] = current.data;
            }
            current = current.neste;
        }
        return resultat;
    }

    @Override
    public int antall() {
        return antall;
    }

	@Override
	public Film[] soekProdusent(String delstreng) {
	    LinearNode<Film> current = start;
	    int teller = 0;

	    
	    while (current != null) {
	        if (current.data.getFilmSkaper().toLowerCase().contains(delstreng.toLowerCase())) {
	            teller++;
	        }
	        current = current.neste;
	    }

	   
	    Film[] resultat = new Film[teller];
	    current = start;
	    teller = 0;

	    
	    while (current != null) {
	        if (current.data.getFilmSkaper().toLowerCase().contains(delstreng.toLowerCase())) {
	            resultat[teller++] = current.data;
	        }
	        current = current.neste;
	    }

	    return resultat;
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
	    int teller = 0;
	    LinearNode<Film> current = start;

	    while (current != null) {
	        if (current.data.getSjanger() == sjanger) {
	            teller++;
	        }
	        current = current.neste;
	    }

	    return teller;
	}
}