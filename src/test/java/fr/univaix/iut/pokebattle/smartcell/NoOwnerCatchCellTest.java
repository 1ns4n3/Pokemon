package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NoOwnerCatchCellTest {
	
    @Test
    public void testOwner() {
    	NoOwnerCatchCell cell = new NoOwnerCatchCell();
    	
    	assertEquals("@1nsan3_ @EILLISIS is my owner", cell.ask(new Tweet("1nsan3_", "@SALAMECHE_PKWEM Pokeball!")));
    }

    /*@Test
    public void testNoOwner() {
    	NoOwnerCatchCell cell = new NoOwnerCatchCell();
    	
        assertEquals("@nedseb @nedseb is my owner", cell.ask(new Tweet("nedseb", "@PSYKOKWAK_PKWEM Pokeball!")));
    }*/
}
