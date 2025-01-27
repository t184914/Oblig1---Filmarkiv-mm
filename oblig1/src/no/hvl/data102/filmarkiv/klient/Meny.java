package no.hvl.data102.filmakriv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;


public class Meny {

    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmakriv;
    }

    public void start() {
        leggTilEksempelFilmer();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nKva ønsker du å gjøre?");
            System.out.println("1: Legg til ny film");
            System.out.println("2: Slett en film");
            System.out.println("3: Søk etter filmer basert på tittel");
            System.out.println("4: Søk etter filmer basert på produsent");
            System.out.println("5: Vis statistikk");
            System.out.println("6: Avslutt");

            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1{
                    Film nyFilm = tekstgr.lesFilm();
                    filmarkiv.leggTilFilm(nyFilm);
                }
                case 2{
                    System.out.print("Skriv inn filmnummeret til filmen som skal slettes: ");
                    int filmnr = scanner.nextInt();
                    boolean slettet = filmarkiv.slettFilm(filmnr);
                    if (slettet) {
                        System.out.println("Filmen blei sletta.");
                    } else {
                        System.out.println("Fant ikkje filmen med dette nummeret.");3
                    }

                }
                case 3{
                    System.out.print("Skriv inn en del av tittelem: ");
                    String delstreng = scanner.nextLine();
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, delstreng);
                }
                case 4{
                    System.out.println("Skriv inn en del av produsentens navn:");
                    string delstreng = scanner.nextLine();
                    tekstgr.skrivUtFilmProdusent(filmarkiv, delstreng);

                }
                case 5{
                    tekstgr.skrivUtStatistikk(filmakriv);
                }
                case 6{
                    System.out.println("Programmet avsluttes.");
                    scanner.close();
                    return;
                }
                default{
                    System.out.printlm("Ugyldig valg. Prøv igjen.");
                }

                }
            }
        }
        
        private void leggTilEksempelFilmer() {
            filmarkiv.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros"));
            filmarkiv.leggTilFilm(new Film(2, "Peter Jackson", "The Lord of the Rings", 2001, Sjanger.FANTASY, "New Line Cinema"));
            filmarkiv.leggTilFilm(new Film(3, "Hayao Miyazaki", "Spirited Away", 2001, Sjanger.ANIMASJON, "Studio Ghibli"));
            filmarkiv.leggTilFilm(new Film(4, "Steven Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal Pictures"));
            filmarkiv.leggTilFilm(new Film(5, "James Cameron", "Titanic", 1997, Sjanger.ROMANTIKK, "20th Century Fox"));
        }
    }