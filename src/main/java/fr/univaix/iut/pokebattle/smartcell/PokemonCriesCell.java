package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Pokemon;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;

	public PokemonCriesCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	
    public String ask(Tweet tweet) {
    	System.out.println("PokemonCriesCell");
    	/**
    	 		F1/F2
    	 					**/
<<<<<<< HEAD
    	
    	
    	System.out.println("PokemonCriesCell");
        if (tweet.getScreenName() != null && !tweet.getText().contains("Owner")){
=======
        if (tweet.getScreenName() != null && !tweet.getText().contains("Owner")
        		&& !tweet.getText().contains("Viviane_PKWEM"))
        {
>>>>>>> 30b0f4a68fed28f1063713708fb94450820ca972
            
        	DAOPokemonJPA dao = new DAOPokemonJPA(em);
        	
        	// Contains ?
        	System.out.println(tweet.getText());
        	System.out.println(tweet.getScreenName());
        	String[] alias = tweet.getText().split(" ");
         	String pokemon = alias[0].toUpperCase();
         	pokemon = pokemon.substring(1, pokemon.length());
         	System.out.println(pokemon);
         	
        	Pokemon poke = dao.getById(pokemon);
        	String cri = poke.getCri();
        	System.out.println(cri);
        	
        	
        	String r = "@" + tweet.getScreenName() +  " " + cri;

        	
        	em.close();
            emf.close();
            
            return r;
        }
        else{
            	return null;
        }
        	
    }
}