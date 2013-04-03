package fr.univaix.iut.pokebattle.smartcell;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SayPokemonOwnerOnAttackCellTest {
	
	
    @Test
    public void testSayPokemonOwnerOnAttack() {
    	SayPokemonOwnerOnAttackCell cell = new SayPokemonOwnerOnAttackCell();
    			
    	assertEquals("@SALAMECHE_PKWEM #attack #charge /cc @EILLISIS @WII2ZO", cell.ask(new Tweet("WII2ZO", "@PIKACHU_PKWEM #attack #charge @SALAMECHE_PKWEM /cc @EILLISIS")));
    }


    

}
