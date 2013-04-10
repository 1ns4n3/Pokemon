package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AnswerJugeCell implements SmartCell {
	
	@Override
	public String ask(Tweet tweet) {
		
		if (tweet.getText().contains("#attack") && tweet.getText().contains("@viviane")) {
			System.out.println("AnswerJugeCell");
			String texte = tweet.getText();
			String[] tabMots = texte.split(" ");
			String pokeAttaque = tabMots[0];
			String reponseJuge = pokeAttaque + " -10pv /cc "
					                  + tabMots[4];		
			return reponseJuge;
		}
		return null;
	}
	//pcreux: "@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb @viviane"
	//bulbizare1: "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux @viviane"
	//viviane: "@pikachuNyanNian -10pv /cc @pcreux"
}
