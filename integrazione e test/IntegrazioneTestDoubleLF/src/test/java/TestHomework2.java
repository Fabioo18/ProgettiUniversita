import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.example.*;


public class TestHomework2
{
    Homework2.Output output;
    Homework2.Output output2;

    //Casi di test eccezionali:
    //T1
    @Test
    @DisplayName("nIsDifferentFromm")
    void nIsDifferentFromm()
    {
        output = Homework2.effettuaOperazioni(1, 2, new String[]{"Leone"},new int[]{1,2});
        assertEquals("Il numero di numeri e nomi inseriti non corrisponde",output.messaggio);
    }
    //T2
    @Test
    @DisplayName("numeriIsNull")
    void numeriIsNull()
    {
        output = Homework2.effettuaOperazioni(1, 1, new String[]{"Giuseppe"},null);
        assertEquals("Una delle due o entrambe le liste sono nulle",output.messaggio);
    }

    //T3
    @Test
    @DisplayName("nomiIsNull")
    void nomiIsNull()
    {
        output = Homework2.effettuaOperazioni(1, 1, null,new int[]{1});
        assertEquals("Una delle due o entrambe le liste sono nulle",output.messaggio);
    }

    //T4 Abbiamo deciso di non testare i casi in cui nomi o numeri sono vuoti poichè questo test include nella propria partizione anche quest'ultimi due casi,
    // permettendoci di effettuare due test in meno.
    @Test
    @DisplayName("numeriAndNomiDifferentLength")
    void numeriAndNomiDifferentLength()
    {
        output = Homework2.effettuaOperazioni(1, 1, new String[]{},new int[]{5});
        assertEquals("La lunghezza di uno dei due o entrambe le liste non corrisponde alla dimensione fornita in input",output.messaggio);
        output2 = Homework2.effettuaOperazioni(1, 1, new String[]{"Federico"},new int[]{});
        assertEquals("La lunghezza di uno dei due o entrambe le liste non corrisponde alla dimensione fornita in input", output2.messaggio);
    }

    //T5
    @Test
    @DisplayName("nomiHasElementNull")
    void nomiHasElementNull()
    {
        output = Homework2.effettuaOperazioni(2, 2, new String[]{"Gianluca",null},new int[]{5,6});
        assertEquals("Non e' possibile inserire stringhe nulle",output.messaggio);
    }

    //Caso di test per soli numeri pari il cui quadrato è minore di 100:
    //T6
    @Test
    @DisplayName("numeriHasEvenElementSquaredMinor100")
    void numeriHasEvenElementSquaredMinor100()
    {
        output = Homework2.effettuaOperazioni(2, 2, new String[]{"Giovanni","Aldo"},new int[]{6,4});
        assertArrayEquals(new String[]{"Aldo","Giovanni"},output.nomi);
        assertArrayEquals(new int[]{16,36}, output.numeri.stream().mapToInt(Integer::intValue).toArray());
    }

    //Caso di test per soli numeri dispari il cui cubo è minore di 200:
    //T7
    @Test
    @DisplayName("numeriHasOddElementCubedMinor200")
    void numeriHasOddElementCubedMinor200()
    {
        output = Homework2.effettuaOperazioni(2, 2, new String[]{"Giuseppe","Franco"},new int[]{3,5});
        assertArrayEquals(new String[]{"Franco","Giuseppe"},output.nomi);
        assertArrayEquals(new int[]{27,125}, output.numeri.stream().mapToInt(Integer::intValue).toArray());
    }

    //Boundary Test
    //T8
    @Test
    @DisplayName("nAndmAreZero")
    void nAndmAreZero()
    {
        output = Homework2.effettuaOperazioni(0, 0, new String[]{},new int[]{});
        assertEquals("Non e' possibile inserire una grandezza di dimensione 0 o minore",output.messaggio);
    }

    //T9
    @Test
    @DisplayName("NumeriHasNegative")
    void NumeriHasNegative()
    {
        output = Homework2.effettuaOperazioni(2, 2, new String[]{"Marco","Andrea"},new int[]{5,-1});
        assertEquals("Non e' possibile inserire un numero negativo",output.messaggio);
    }

    //T10
    @Test
    @DisplayName("NumeriHasNegative")
    void NumeriMajor99()
    {
        output = Homework2.effettuaOperazioni(2, 2, new String[]{"Fabio","Antonietta"},new int[]{100,5});
        assertEquals("Il numero inserito e' troppo grande",output.messaggio);
    }

    //T11
    @Test
    @DisplayName("NumeriHasNegative")
    void NumeriElementSquaredMajor100()
    {
        output = Homework2.effettuaOperazioni(2, 2, new String[]{"Beatrice","Gianmarco"},new int[]{12,4});
        assertArrayEquals(new String[]{"Beatrice","Gianmarco"},output.nomi);
        assertArrayEquals(new int[]{16}, output.numeri.stream().mapToInt(Integer::intValue).toArray());
    }

    //T12
    @Test
    @DisplayName("NumeriHasNegative")
    void NumeriElementCubedMajor200()
    {
        output = Homework2.effettuaOperazioni(2, 2, new String[]{"Francesca","Chiara"},new int[]{11,1});
        assertArrayEquals(new String[]{"Chiara","Francesca"},output.nomi);
        assertArrayEquals(new int[]{1}, output.numeri.stream().mapToInt(Integer::intValue).toArray());
    }
    //Test Black Box
    //T13
    @Test
    @DisplayName("NomiHasEmptyString")
    void NomiHasEmptyString()
    {
        output = Homework2.effettuaOperazioni(2, 2, new String[]{"Ferdinando",""},new int[]{2,6});
        assertArrayEquals(new String[]{"","Ferdinando"},output.nomi);
        assertArrayEquals(new int[]{4,36}, output.numeri.stream().mapToInt(Integer::intValue).toArray());
    }

    //T14
    @Test
    @DisplayName("numeriHasEvenElementSquaredMinor100AndOddElementCubedMinor200")
    void numeriHasEvenElementSquaredMinor100AndOddElementCubedMinor200()
    {
        output = Homework2.effettuaOperazioni(2, 2, new String[]{"Giuseppe","Franco"},new int[]{3,4});
        assertArrayEquals(new String[]{"Franco","Giuseppe"},output.nomi);
        assertArrayEquals(new int[]{16,27}, output.numeri.stream().mapToInt(Integer::intValue).toArray());
    }


}

