package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NoOwnerCatchCellTest {
	
    @Test
    public void testOwner() {
    	NoOwnerCatchCell cell = new NoOwnerCatchCell();
    	
    	assertEquals("@nedseb @WII2ZO is my owner", cell.ask(new Tweet("nedseb", "@PIKACHU_PKWEM Pokeball!")));
    }

    @Test
    public void testNoOwner() {
    	NoOwnerCatchCell cell = new NoOwnerCatchCell();
    	
        assertEquals("@nedseb @nedseb is my owner", cell.ask(new Tweet("nedseb", "@PSYKOKWAK_PKWEM Pokeball!")));
    }
}
