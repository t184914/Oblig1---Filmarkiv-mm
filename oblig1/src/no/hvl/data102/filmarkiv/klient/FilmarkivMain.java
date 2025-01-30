package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

public class FilmarkivMain{
    
    public static void main(String[] args){
    	
        Filmarkiv filma = new Filmarkiv(10);
        Meny meny = new Meny(filma);
        filma.skrivUtHeleArkivet();
        meny.start();
       filma.skrivUtHeleArkivet();

    }



}