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
    	delstreng = delstreng.toLowerCase();
        Film[] tittelsoek = new Film[antall];
        int j = 0;
        for (int i = 0; i < antall; i++){
            if (Filmer[i] != null && Filmer[i].getTittel().toLowerCase().contains(delstreng)){
                tittelsoek[j] = Filmer[i];
                j++;
            }
        }
        Film[] resultat = new Film[j];  
                for (int i = 0; i < j; i++) {
                    resultat[i] = tittelsoek[i]; 
                }

                return resultat;
            }
    
    public Film[] hentFilmTabell() {
        Film[] filmer = new Film[antall];
        for (int i = 0; i < antall; i++) {
            filmer[i] = Filmer[i];
        }
        return filmer;
    }



    public Film[] soekProdusent(String delstreng){
    	delstreng = delstreng.toLowerCase();
        Film[] produsentsoek = new Film[antall];
        int j = 0;
        for (int i = 0; i < antall; i++){
            if (Filmer[i] != null && Filmer[i].getFilmSkaper().toLowerCase().contains(delstreng)){
                produsentsoek[j] = Filmer[i];
                j++;
            }
        }
        Film[] resultat = new Film[j];  
        for (int i = 0; i < j; i++) {
            resultat[i] = produsentsoek[i]; 
        }

        return resultat;
    }


    public int antallSjanger (Sjanger sjanger){
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (Filmer[i].getSjanger() == sjanger) {
                teller++;
            }
        }
        return teller;
    }
    public void skrivUtHeleArkivet() {
        for (int i = 0; i < antall; i++) {
            System.out.println(Filmer[i].toString());
        }
    }
    
   

    public int antall(){
        return antall;
    }

}