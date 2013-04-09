package fr.univaix.iut.pokebattle.smartcell;


import fr.univaix.iut.pokebattle.twitter.Tweet;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttackCellTest {
	
	
    @Test
    public void testAttack() {
    	AttackCell cell = new AttackCell();
    	
    	assertEquals("@PIKACHU_PKWEM #attack #foudre! /cc @EILLISIS", cell.ask(new Tweet("EILLISIS", "@SALAMECHE_PKWEM #attack #foudre @PIKACHU_PKWEM")));
    }

    /*@Test
    public void testNoAttack() {
    	AttackCell cell = new AttackCell();
    	
        assertEquals("@nedseb @nedseb is my owner", cell.ask(new Tweet("nedseb", "@PSYKOKWAK_PKWEM #attack #foudre @SALAMECHE_PKWEM")));
    }*/
    

}
