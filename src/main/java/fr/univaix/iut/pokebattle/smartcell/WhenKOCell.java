package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
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
		
		/*  pcreux: "@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb @viviane"
			bulbizare1: "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux @viviane"

			nedseb: "@pikachuNyanNian #attack #foudre @bulbizare1 /cc @pcreux @viviane"
			pikachuNyanNian: "@bulbizare1 #attack #foudre /cc @nedseb @pcreux @viviane"

			viviane: "@bulbizare1 -10pv /cc @pcreux"
			viviane: "@pikachuNyanNian -10pv /cc @nedseb"
		
			bulbizare1: "#KO /cc @viviane @nedseb @pcreux" */

		//String texte = tweet.getText();
		//String[] tabMots = texte.split(" ");
		
		//if(tabMots[0] est un poké et que ses PV <= 0)
		/*{	
			//String pokeKO = tabMots[0];
			
			String answer = "#KO /cc " /* + @JUGE + + " "
					/* + "@DRESSEURVAINQUEUR" + "@PRORIOPOKEKO" ;
			return answer;
		}*/
		
		DAOPokemonJPA dao = new DAOPokemonJPA(em);
			
    	String[] alias = tweet.getText().split(" ");
     	String pokemon = alias[0].toUpperCase();
     	pokemon = pokemon.substring(1, pokemon.length());
		Pokemon poke = dao.getById(pokemon);
		
		if (poke.getPv() == 0) 
		{
			// Juge
			String answer = "#KO /cc @viviane @" + poke.getOwner_poke() + " @"; //indiquer nom du dernier éleveur qui a attaqué poke
			return answer;
		}
		else 
			return null;

	}

}
