package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOOwnerJPA;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Owner;
import fr.univaix.iut.progbd.Pokemon;

public class NoOwnerCatchCell implements SmartCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;

	public NoOwnerCatchCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	
	@Override
	public String ask(Tweet question) {
		/**
 				F3/F4/F5/F6/F8
 									**/
		if(question.getText().contains("Pokeball"))
		{	
			
			// ask contains pcreux: "pcreux: "@pikachuNyanNyan Pokeball!"
			// answer should contains : pikachuNyanNian: "@pcreux @pcreux is my owner"
			
			// Qui veux m'attraper ?
			String ownerAsk = question.getScreenName();
			
			// Quel Pokemon ?
			String[] alias = question.getText().split(" ");
         	String pokemon = alias[0].toUpperCase();
         	pokemon = pokemon.substring(1, pokemon.length());
         	
         	// Check owner exist
         	DAOPokemonJPA dao = new DAOPokemonJPA(em);
         	Pokemon poke = dao.getById(pokemon);
         	Owner pokeOwner = poke.getOwner_poke();

         	
			// Check good owner
			if (pokeOwner != null)
			{
				String pokeOwnerName = pokeOwner.getNom_owner();
				String answer ="@" + ownerAsk + " @" + pokeOwnerName + " is my owner";
				em.close();
	            emf.close();
				return  answer;
			}
			else 
			{
	            DAOOwnerJPA daoOwner = new DAOOwnerJPA(em);
				Owner ownerExist = em.find(Owner.class, ownerAsk);
				if (ownerExist == null)
				{
					Owner own = new Owner(ownerAsk);
					daoOwner.insert(own);
					poke.setOwner_poke(own);
				}
				else
					poke.setOwner_poke(ownerExist);

				// Réponse
				String pokeOwn = poke.getOwner_poke().getNom_owner();
				String answer = "@" + ownerAsk + " @" + pokeOwn + " is my owner";
				
				// Edition de la description sur Twitter
				// Ne peut être testée que manuellement
	            Twitter twitter = question.getTwitter();
	            if (twitter != null) 
	            {
		            try 
		            {
						twitter.updateProfile(null, null, null, "#pokebattle - #pokemon - Owner: @" + pokeOwn);
					} 
		            catch (TwitterException e) 
		            { 
		            	e.printStackTrace(); 
		            }
	            
	            }
				
				em.close();
	            emf.close();
				return answer;
			}
		}
		return null;
	}
}
