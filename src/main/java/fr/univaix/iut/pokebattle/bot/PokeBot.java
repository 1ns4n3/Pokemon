package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.smartcell.*;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeBot implements Bot {
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */
    final SmartCell[] smartCells = new SmartCell[]{
    		 
    		//new SaysOwnerNameCell(),
    		new AttackCell(),  // F7
    		new NoOwnerCatchCell(), // F3/F4/F5/F6/F8
    		new SayPokemonOwnerOnAttackCell(), // F9 !
    		new PokemonCriesCell(), // F1/F2
		        
    };

    /**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     */
    @Override
    public String ask(Tweet question) {
        for (SmartCell cell : smartCells) {
            String answer = cell.ask(question);
            if (answer != null)
                return answer;
        }
        return null;
    }

}
