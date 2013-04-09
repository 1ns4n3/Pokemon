package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Owner;
import fr.univaix.iut.progbd.Pokemon;

public class WhenKOCell implements SmartCell {

	private EntityManagerFactory emf; 
	private EntityManager em;
	
	public WhenKOCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	
	@Override
	public String ask(Tweet tweet) {
		
		System.out.println("WhenKoCell");
		DAOPokemonJPA dao = new DAOPokemonJPA(em);
	
			
		
		// récupération du pokémon qui est éventuellement KO
    	String[] alias1 = tweet.getText().split(" ");
     	String pokemon = alias1[0].substring(1, alias1[0].length()); // on récupère chenipan
     	pokemon = pokemon.toUpperCase() + "_PKWEM"; // on récupère CHENIPAN_PKWEM
     	Pokemon poke = dao.getById(pokemon); // NOM DU POKEMON (BD)
     	Owner own = poke.getOwner_poke();
     	
     	
     	//récupération de l'owner qui a éventuellement mis KO dans notre pokémon : l'owner du screename
     	String tweeteur = tweet.getScreenName().toUpperCase();
     	Pokemon attaquant = dao.getById(tweeteur); // on récupère le tweeteur dans la BD : le pokémon qui attaque
     	Owner owner = attaquant.getOwner_poke(); // owner du pokémon attaquant
     	
		
		if (poke.getPv() == 0) 
		{
			// tweet envoyé par pikachu: @bulbizare1 #attack #foudre /cc @nedseb @pcreux @viviane
			// bulbizare1 doit répondre : #KO /cc @viviane @nedseb @pcreux
			String answer = "#KO /cc @viviane @"+ owner.getNom_owner() + " @" + own.getNom_owner() ;
			return answer;
		}
		else 
			return null;

	}

}
