package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class CaractCellTest {

	@Test
	public void test() {
		CaractCell cell = new CaractCell();
    	
    	assertEquals("@Paulmista #level=1", cell.ask(new Tweet("Paulmista", "@CHENIPAN_PKWEM #stat #level ?")));
    	assertEquals("@Paulmista #PV=0/100", cell.ask(new Tweet("Paulmista", "@CHENIPAN_PKWEM #stat #PV ?")));
    	assertEquals("@Paulmista #XP=0", cell.ask(new Tweet("Paulmista", "@CHENIPAN_PKWEM #stat #XP ?")));
    	
	}

}
