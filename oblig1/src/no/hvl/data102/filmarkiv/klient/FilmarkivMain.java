package no.hvl.data102.filmakriv.klient;


public class FilmarkivMain{
    
    public static void main(String[] args){

        FilmarkivADT filma = new Filmarkiv(10);
        Meny meny = new Meny(filma);
        meny.start();

    }



}