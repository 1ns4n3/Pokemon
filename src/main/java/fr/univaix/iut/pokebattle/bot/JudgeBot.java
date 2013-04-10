package fr.univaix.iut.pokebattle.bot;

import com.google.common.collect.Lists;

import fr.univaix.iut.pokebattle.smartcell.AnswerJugeCell;
import fr.univaix.iut.pokebattle.smartcell.AttackCell;
import fr.univaix.iut.pokebattle.smartcell.NoOwnerCatchCell;
import fr.univaix.iut.pokebattle.smartcell.PokemonCriesCell;
import fr.univaix.iut.pokebattle.smartcell.SayPokemonOwnerOnAttackCell;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import java.util.List;


public class JudgeBot implements Bot {
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */
    //final List<SmartCell> smartCells = Lists.newArrayList();
	final SmartCell[] smartCells = new SmartCell[]{
   		 
    		new AnswerJugeCell(),
		        
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
