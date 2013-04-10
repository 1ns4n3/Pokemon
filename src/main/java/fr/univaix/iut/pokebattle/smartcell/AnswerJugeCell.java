package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Pokemon;

public class AnswerJugeCell implements SmartCell {
	
	@Override
	public String ask(Tweet tweet) {
		System.out.println("AnswerJugeCell");
		if(tweet.getText().contains("@Viviane_PKWEM"))
		{
			//pcreux: "@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb @viviane"
			//bulbizare1: "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux @viviane"
			//viviane: "@pikachuNyanNian -10pv /cc @pcreux"
			if(	tweet.getScreenName().contains("Psykokwak_PKWEM") 	||
				tweet.getScreenName().contains("Salameche_PKWEM") 	||
				tweet.getScreenName().contains("Pikachu_PKWEM") 	||
				tweet.getScreenName().contains("Chenipan_PKWEM") 	||
				tweet.getScreenName().contains("Abra_PKWEM") 
					)
			{
				String texte = tweet.getText();
				String[] tabMots = texte.split(" ");
				String pokeAttaque = tabMots[0];
				String reponseJuge = pokeAttaque + " -10pv /cc "
						                  + tabMots[4];
				
				return reponseJuge;
			}
			else
				return null;
		}
		return null;
	}
}
