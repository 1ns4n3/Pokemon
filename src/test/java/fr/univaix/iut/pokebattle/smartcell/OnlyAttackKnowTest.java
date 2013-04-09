package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OnlyAttackKnowTest {

	@Test
    public void testAttackKnow() {
		OnlyAttackKnowCell cell = new OnlyAttackKnowCell();

    	assertEquals(null,
    			cell.ask(new Tweet("eillisis", "@salameche_pkwem #charge @CHENIPAN_PKWEM /cc @paulmista @viviane")));
    	assertEquals("@eillisis  o_O ? /cc @paulmista @viviane @CHENIPAN_PKWEM",
    			cell.ask(new Tweet("eillisis", "@SALAMECHE_PKWEM #attack #eau @CHENIPAN_PKWEM /cc @paulmista @viviane"))); 
    	assertEquals(null,
    			cell.ask(new Tweet("eillisis", "@SALAMECHE_PKWEM #attack #charge @CHENIPAN_PKWEM /cc @paulmista @viviane"))); 
	}
	
	//eillisis: "@salameche_pkwem #attack #griffe @CHENIPAN_PKWEM /cc @paulmista @viviane"
	//SALAMECHE_PKWEM: "@eillisis  o_O ? /cc @paulmista @viviane @CHENIPAN_PKWEM"

}

