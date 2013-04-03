package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Owner;
import fr.univaix.iut.progbd.Pokemon;

public class SaysOwnerNameCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;

	public SaysOwnerNameCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	
	public String ask(Tweet question) {
		if(question.getText().contains("Owner?"))
		{	
			String ownerAsk = question.getScreenName();
			String response = null;
			
			String[] alias = question.getText().split(" ");
		 	String pokemon = alias[0].toUpperCase();
		 	pokemon = pokemon.substring(1, pokemon.length());
			
		 	DAOPokemonJPA dao = new DAOPokemonJPA(em);
		 	Pokemon poke = dao.getById(pokemon);
		 	Owner pokeOwner = poke.getOwner_poke();
	 		String ownerName = null;

		 	if (pokeOwner != null) {
		 		ownerName = pokeOwner.getNom_owner();
		 		response = "@" + ownerAsk + " @" + ownerName + " is my owner";	
		 	}
		 	else 
		 		response = "@" + ownerAsk + " No owner";
		 	
			return response;
		}
		return null;
	}
}
