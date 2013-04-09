package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Owner;
import fr.univaix.iut.progbd.Pokemon;

public class AttackCell implements SmartCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;

	public AttackCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	
	public String ask(Tweet tweet) {
		System.out.println("AttackCell");
		if(tweet.getText().contains("#attack"))
		{	
			
			// ask contains pcreux: "@pikachuNyanNian #attack #foudre @bulbizare1"
			// answer should contains : "pikachuNyanNian: "@bulbizare1 #attack #foudre! /cc @pcreux"
			
			
			String alias = tweet.getText();
			String[] alias2 = alias.split(" ");
			String pokemonAttacked = alias2[3]; // contient bulbizarre1
			String attackName = alias2[2];		// contient #foudre
			String pokemon = alias2[0].toUpperCase();	// contient PIKACHUNYANNIAN
         	pokemon = pokemon.substring(1, pokemon.length());
         	pokemon = pokemon.toUpperCase();
			String dresseur = tweet.getScreenName();	// contient pcreux
			
			
			/*check good owner*/
			DAOPokemonJPA dao = new DAOPokemonJPA(em);
         	Pokemon poke = dao.getById(pokemon);
         	Owner pokeOwnerObj = poke.getOwner_poke();
         	System.out.println(pokeOwnerObj);
         	
         	String pokeOwner;
         	if(pokeOwnerObj != null)
         	{
         		pokeOwner = pokeOwnerObj.getNom_owner();  // contient le dresseur 
         		System.out.println("Le Pokemon a un dresseur :" + pokeOwner);
         		System.out.println(dresseur);
         		dresseur.toUpperCase();
	         	if(pokeOwner.equals(dresseur))
	         	{
	         		System.out.println("Le Pokemon attaque a cause de son dresseur");
	         		return pokemonAttacked + " #attack " + attackName
					          + "! /cc " + "@" + pokeOwner;	
	         	}
	         	else
	         	{
	         		return "@" + tweet.getScreenName() + " @" + pokeOwner + " is my owner";
	         	}
         	}
         	else
         	{
         		System.out.println("Le Pokemon n'a pas de dresseur");
         		return "@" + dresseur + " @" + dresseur + " is my owner";
         	}
         		
		}
		else {

			return null;
		}
		
	}

}
