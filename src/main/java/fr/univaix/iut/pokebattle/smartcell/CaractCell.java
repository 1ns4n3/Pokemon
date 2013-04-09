package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Pokemon;

public class CaractCell implements SmartCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;
	
	public CaractCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}

	@Override
	public String ask(Tweet tweet) {
		System.out.println("CaractCell");
		// 	ex :
		// 	pcreux: "@bulbizare1 #stat #level ?"
		// 	bulbizare1: "@pcreux #level=1"
		//
		//	pcreux: "@bulbizare1 #stat #XP ?"
		// 	bulbizare1: "@pcreux #XP=0"
		//
		//	pcreux: "@bulbizare1 #stat #PV ?"
		// bulbizare1: "@pcreux #PV=10/100"

		
		if(tweet.getText().contains("#stat"))
		{	
			DAOPokemonJPA dao = new DAOPokemonJPA(em);
			
        	String[] alias = tweet.getText().split(" ");
         	String pokemon = alias[0].toUpperCase();
         	pokemon = pokemon.substring(1, pokemon.length());
			Pokemon poke = dao.getById(pokemon);
			
			if (tweet.getText().contains("#level")){
				String answer = "@" + tweet.getScreenName() + " #level="+ poke.getLevel();
				return answer;
			}
			if (tweet.getText().contains("#XP")){
				String answer = "@" + tweet.getScreenName() + " #XP=" + poke.getXp();
				return answer;
			}
			if (tweet.getText().contains("#PV")){
				String answer = "@" + tweet.getScreenName() + " #PV=" + poke.getPv() + "/" + poke.getBaseHP();
				return answer;
			}
		}
		return null;
	}

}
