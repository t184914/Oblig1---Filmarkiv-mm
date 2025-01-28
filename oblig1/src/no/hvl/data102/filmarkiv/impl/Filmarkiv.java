package no.hvl.data102.filmarkiv.impl;


import no.hvl.data102.filmarkiv.adt.*;


public class Filmarkiv implements FilmarkivADT {
    private Film[] Filmer;
    private int antall;

    public Filmarkiv(int kapasitet) {
        Filmer = new Film[kapasitet];
        antall = 0;
    }

    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++){
            if (Filmer[i].getFilmNr() == nr) {
                return Filmer[i];
            }
        }
        return null;
    }

    public void leggTilFilm(Film nyFilm){
        if (antall == Filmer.length){
            System.out.print("Tabellen er full, kunne ikkje legge til film.");
        } else {
        Filmer[antall] = nyFilm;
        antall++;
        }
    }

    public boolean slettFilm(int filmnr){
        for (int i = 0; i < antall; i++){
            if (Filmer[i].getFilmNr() == filmnr){
                Filmer[i] = Filmer[antall - 1];
                Filmer[antall -1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    public Film[] soekTittel(String delstreng){
        Film[] tittelsoek = new Film[antall];
        int j = 0;
        for (int i = 0; i < antall; i++){
            if (Filmer[i].getTittel().contains(delstreng)){
                tittelsoek[j] = Filmer[i];
                j++;
            }
        }
        return tittelsoek;
    }


    public Film[] soekProdusent(String delstreng){
        Film[] produsentsoek = new Film[antall];
        int j = 0;
        for (int i = 0; i < antall; i++){
            if (Filmer[i].getFilmSkaper().contains(delstreng)){
                produsentsoek[j] = Filmer[i];
                j++;
            }
        }
        return produsentsoek;
    }

    public int antallSjanger (Sjanger sjanger){
        int teller = 0;
        for (int i = 0; i < antall; i++){
            if (Filmer[i].getSjanger() == sjanger) {
                teller++;
            }
        }
        return teller;
    }

    public int antall(){
        return antall;
    }

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}
}