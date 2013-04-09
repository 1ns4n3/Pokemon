package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AnswerJugeCellTest {

	@Test
    public void testJuge() {
    	AnswerJugeCell cell = new AnswerJugeCell();
    	
    	assertEquals("@pikachuNyanNian -10pv /cc @nedseb",
    			cell.ask(new Tweet("bulbizare1", "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux @viviane")));
    }

}
