package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;


import java.util.Scanner;

public class Tekstgrensesnitt{

    private Scanner scanner = new Scanner(System.in);

    public Film lesFilm(){
        System.out.print("Filmnmmer: ");
        int filmnr = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Produsent: ");
        String produsent = scanner.nextLine();

        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();

        System.out.print("Utgivelsesår: ");
        int utgivelsesår = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Velg sjanger (1: ACTION, 2: DRAMA, 3: KOMEDIE, 4: ANIMASJON, 5: ROMANTIKK, 6: FANTASY): ");
        int sjangerValg = scanner.nextInt();
        scanner.nextLine(); 
        Sjanger sjanger = Sjanger.values()[sjangerValg - 1];

        System.out.print("Filmselskap: ");
        String filmselskap = scanner.nextLine();
        
        return new Film(filmnr,  produsent, tittel, utgivelsesår, sjanger, filmselskap);

}

public void skrivutFilm(Film film){
    System.out.println(film);
}


public void skrivUTFilmDelstrengTittel(FilmarkivADT arkiv, String delstreng){
    Film[] filmer = arkiv.soekTittel(delstreng);
    for (Film film : filmer){ 
    	System.out.println(film.toString());
    	}
}



public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
    Film[] filmer = arkiv.soekProdusent(delstreng);
    for (Film film : filmer) {
    	if(filmer != null) {
    	System.out.println(film.toString());
    	}
    }
}
public void skrivUtStatistikk(FilmarkivADT arkiv) {
    System.out.println("Antall filmer i arkivet: " + arkiv.antall());
    for (Sjanger sjanger : Sjanger.values()) {
        System.out.println(sjanger + ": " + arkiv.antallSjanger(sjanger));
    }
}

}

