package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AnswerJugeCellTest {

	@Test
    public void testJuge() {
    	AnswerJugeCell cell = new AnswerJugeCell();
    	
    	assertEquals("@Salameche_PKWEM -10pv /cc @EILLISIS",
    			cell.ask(new Tweet("Psykokwak_PKWEM", "@Salameche_PKWEM #attack #charge /cc @EILLISIS @1NSAN3_ @Viviane_PKWEM")));
    }

}
