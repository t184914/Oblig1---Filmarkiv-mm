package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {
    private FilmarkivADT filmarkiv1;
    private FilmarkivADT filmarkiv2;

    @BeforeEach
    void setUp() {
        filmarkiv1 = new Filmarkiv(10); // Bruker tabell
        filmarkiv2 = new Filmarkiv2();   // Bruker kjedet liste

        // Legger til testdata
        filmarkiv1.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros"));
        filmarkiv1.leggTilFilm(new Film(2, "Peter Jackson", "The Lord of the Rings", 2001, Sjanger.DOCUMENTARY, "New Line Cinema"));

        filmarkiv2.leggTilFilm(new Film(1, "Christopher Nolan", "Inception", 2010, Sjanger.ACTION, "Warner Bros"));
        filmarkiv2.leggTilFilm(new Film(2, "Peter Jackson", "The Lord of the Rings", 2001, Sjanger.DOCUMENTARY, "New Line Cinema"));
    }

    @Test
    void testLeggTilFilm() {
        filmarkiv1.leggTilFilm(new Film(3, "James Cameron", "Avatar", 2009, Sjanger.SCI_FI, "20th Century Fox"));
        filmarkiv2.leggTilFilm(new Film(3, "James Cameron", "Avatar", 2009, Sjanger.SCI_FI, "20th Century Fox"));

        assertEquals(3, filmarkiv1.antall());
        assertEquals(3, filmarkiv2.antall());
    }

    @Test
    void testFinnFilm() {
        assertNotNull(filmarkiv1.finnFilm(1));
        assertNotNull(filmarkiv2.finnFilm(1));

        assertNull(filmarkiv1.finnFilm(99));
        assertNull(filmarkiv2.finnFilm(99));
    }

    @Test
    void testSlettFilm() {
        assertTrue(filmarkiv1.slettFilm(1));
        assertTrue(filmarkiv2.slettFilm(1));

        assertEquals(1, filmarkiv1.antall());
        assertEquals(1, filmarkiv2.antall());

        assertFalse(filmarkiv1.slettFilm(99));
        assertFalse(filmarkiv2.slettFilm(99));
    }

    @Test
    void testSoekTittel() {
        Film[] result1 = filmarkiv1.soekTittel("Lord");
        Film[] result2 = filmarkiv2.soekTittel("Lord");

        assertEquals(1, result1.length);
        assertEquals(1, result2.length);
        assertEquals("The Lord of the Rings", result1[0].getTittel());
        assertEquals("The Lord of the Rings", result2[0].getTittel());
    }

    @Test
    void testSoekProdusent() {
        Film[] result1 = filmarkiv1.soekProdusent("Jackson");
        Film[] result2 = filmarkiv2.soekProdusent("Jackson");

        assertEquals(1, result1.length);
        assertEquals(1, result2.length);
        assertEquals("Peter Jackson", result1[0].getProdusent());
        assertEquals("Peter Jackson", result2[0].getProdusent());
    }

    @Test
    void testAntall() {
        assertEquals(2, filmarkiv1.antall());
        assertEquals(2, filmarkiv2.antall());
    }

    @Test
    void testAntallSjanger() {
        assertEquals(1, filmarkiv1.antallSjanger(Sjanger.ACTION));
        assertEquals(1, filmarkiv2.antallSjanger(Sjanger.ACTION));

        assertEquals(0, filmarkiv1.antallSjanger(Sjanger.ROMANTIKK));
        assertEquals(0, filmarkiv2.antallSjanger(Sjanger.ROMANTIKK));
    }
}

