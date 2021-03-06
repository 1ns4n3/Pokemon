package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Owner;
import fr.univaix.iut.progbd.Pokemon;

public class SayPokemonOwnerOnAttackCell implements SmartCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;

	public SayPokemonOwnerOnAttackCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	@Override
	public String ask(Tweet question) {
		/**
 			F9
 					**/
		System.out.println("SayPokemonOwnerOnAttackCell");
		if (question.getText().contains("#attack") && question.getText().contains("/cc")
				&& !question.getText().contains("@viviane_PKWEM")){
		
		// ask contains pcreux: "@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb"
		// answer should contains : bulbizare1: "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux"
		
		// on récupère le tweet et les info
		String[] alias = question.getText().split(" ");
		String pokemonOwner = question.getScreenName();
     	String pokemon = alias[0].toUpperCase();
     	String attack = alias[2];
     	String pokesAttacked = alias[3];
     	String pokesAttackedOwner = alias[5];
     	pokesAttacked = pokesAttacked.substring(1, pokesAttacked.length());
     	pokesAttacked = pokesAttacked.toUpperCase();
     	pokemon = pokemon.substring(1, pokemon.length());
     	pokesAttackedOwner = pokesAttackedOwner.substring(1, pokesAttackedOwner.length());
     	
     	DAOPokemonJPA dao = new DAOPokemonJPA(em);
     	System.out.println("0" + alias[0] + "1" + alias[1] + "2" + alias[2] + "3" + alias[3] +  alias[4] + alias[5]);
     	System.out.println(pokesAttacked);
     	Pokemon poke = dao.getById(pokesAttacked);
     	System.out.println(poke + "lol");
     	Owner pokesAttackedOwner2 = poke.getOwner_poke();
     	System.out.println(pokesAttackedOwner2 + "lol2");
     	String pokesAttackedOwner3 = null;
     	System.out.println(pokesAttackedOwner2);
     	if (pokesAttackedOwner2 != null) {
     		System.out.println("4");
     	  pokesAttackedOwner3 = pokesAttackedOwner2.getNom_owner();
     	}
		
		if(question.getText().contains(pokesAttackedOwner3))
		{	
			System.out.println("3");
			return "@" + pokesAttacked + " #attack " + attack + " /cc " + "@" 
						+ pokesAttackedOwner + " @"+ pokemonOwner;
		}
		else
		{
			System.out.println("1");
			em.close();
	        emf.close();
			return null;
		}
		}
		else
		{
			System.out.println("2");
			return null;
		}
	}
}


