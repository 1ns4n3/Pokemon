package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class SaysOwnerNameCellTest {
	
    @Test
    public void testSaysOwnerName() {
    	SaysOwnerNameCell cell = new SaysOwnerNameCell();
    	
    	assertEquals("@PaulMista @WII2ZO is my owner", cell.ask(new Tweet("PaulMista", "@PIKACHU_PKWEM Owner?")));
    }

    @Test
    public void testSaysNoOwnerName() {
    	SaysOwnerNameCell cell = new SaysOwnerNameCell();
    	
        assertEquals("@PaulMista No owner", cell.ask(new Tweet("PaulMista", "@PSYKOKWAK_PKWEM Owner?")));
    }
}
