package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;


public class Filmarkiv implements FilmarkivADT {
    private Film[] Filmer;
    private int antall;

    public Filmarkiv(int kapasitet) {
        filmer = new Film[kapasitet]
        antall = 0;
    }

    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++){
            if (filmer[i].getfilmnr() == nr) {
                return filmer[i];
            }
        }
        return null;
    }

    public void leggTilFilm(Film nyFilm){
        if (antall == filmer.length){
            System.out.print("Tabellen er full, kunne ikkje legge til film.")
        } else {
        filmer[antall] = nyfilm;
        antall++
        }
    }

    public boolean slettFilm(int filmnr){
        for (int i = 0; i < antall; i++){
            if (filmer[i].getfilmnr() == filmnr){
                filmer[i] = filmer[antall - 1];
                filmer[antall -1] = null;
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
            if (filmer[i].getTittel().contains(delstreng)){
                tittelsoek[j] = filmer[i];
                j++;
            }
        }
        return tittelsoek:
    }


    public Film[] soekProdusent(String delstreng){
        Film[] produsentsoek = new Film[antall]
        int j = 0;
        for (int i = 0; i z antall; i++){
            if (filmer[i].getFilmSkaper().contains(delstreng)){
                produsentsoek[j] = filmer[i];
                j++;
            }
        }
        return produsentsoek;
    }

    public int antall(Sjanger sjanger){
        int teller = 0;
        for (int i = 0; i < antall; i++){
            if (filmer[i].getSjanger() == sjanger) {
                teller++;
            }
        }
        return teller;
    }

    public int antall(){
        return antall;
    }
}