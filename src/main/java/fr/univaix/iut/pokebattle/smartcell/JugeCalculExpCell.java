package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOOwnerJPA;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Owner;
import fr.univaix.iut.progbd.Pokemon;

public class JugeCalculExpCell implements SmartCell{

	private EntityManagerFactory emf; 
	private EntityManager em;

	public JugeCalculExpCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	@Override
	public String ask(Tweet tweet) {
		//bulbizare1: "#KO /cc @viviane @nedseb @pcreux"
		//viviane: "@pikachuNyanNian #Win +9xp"
		
		DAOPokemonJPA daopoke = new DAOPokemonJPA(em);
		DAOOwnerJPA daoowner = new DAOOwnerJPA(em);
		
		// récupération de l'expérience du pokémon vaincu 
		//(celui qui vient de tweeter qu'il est KO)
		String poke = tweet.getScreenName();
		Pokemon pokevaincu = daopoke.getById(poke);
		int expval = pokevaincu.getXp();
		
		//récupération du dresseur du pokémon vainqueur 
		String[] alias = tweet.getText().split(" ");
		String owner1 = alias[3];
		String  owner2 = owner1.substring(1, owner1.length());
		Owner ownerwin = daoowner.getById(owner2);
		
		
		
		
		return null;
	}

}
