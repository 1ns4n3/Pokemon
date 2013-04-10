package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Pokemon;

public class WhenKOCellTest {

	@Test
    public void testOwner() {
    	WhenKOCell cell = new WhenKOCell();

    	assertEquals("#KO /cc @viviane @EILLISIS @PAULMISTA",
    			cell.ask(new Tweet("SALAMECHE_PKWEM", "@chenipan_pkwem #attack #charge /cc @eillisis @paulmista @viviane")));
    	assertEquals(null,
    			cell.ask(new Tweet("CHENIPAN_PKWEM", "@salameche_pkwem #attack #charge /cc @paulmista @eillisis @viviane")));  
	}

}

//tweet envoyé par salameche_pkem: @chenipan_pkem #attack #charge /cc @eillisis @paulmista @viviane
// chenipan_pkem doit répondre : #KO /cc @viviane @eillisis @paulmista