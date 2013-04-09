package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Pokemon;

public class OnlyAttackKnowCell implements SmartCell {

	private EntityManagerFactory emf; 
	private EntityManager em;

	public OnlyAttackKnowCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	//eillisis: "@salameche_pkwem #attack #charge @CHENIPAN_PKWEM /cc @paulmista @viviane"
	//SALAMECHE_PKWEM: "@eillisis  o_O ? /cc @paulmista @viviane @CHENIPAN_PKWEM"
	@Override
	public String ask(Tweet tweet) {
		if (tweet.getText().contains("#attack"))
		{
			DAOPokemonJPA dao = new DAOPokemonJPA(em);
			
			// récupération du pokémon qui doit attaquer
			String[] alias = tweet.getText().split(" ");
	     	String pokemon = alias[0].toUpperCase();
	     	pokemon = pokemon.substring(1, pokemon.length());
	    	Pokemon poke = dao.getById(pokemon);
	    	
	    	String attack = alias[2]; //#charge
	    	attack = attack.substring(1, attack.length());
	    	
	    	String attackKnow = poke.getAttack(); // charge
	    	
	    	if (attack.equals(attackKnow))
	    		return null;

	    	else {
	    		String[] alias1 = tweet.getText().split("/cc"); 
	    		
		    	return "@" + tweet.getScreenName() + "  o_O ? /cc"
		    			+ alias1[1] + " " + alias[3]; 
	    	}
	    	
		}
		return null;
		
	}
	//nedseb: "@pikachuNyanNian #attack #grumpycat @bulbizare1 /cc @pcreux @viviane"
	//pikachuNyanNian: "@nedseb  o_O ? /cc @pcreux @viviane @bulbizare1"
	
}
