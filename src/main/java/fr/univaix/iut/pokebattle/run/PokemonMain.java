package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonMain {
    public static void main(String[] args) {
        BotRunner.runBot(new PokeBot(), "chenipan.properties");
        BotRunner.runBot(new PokeBot(), "pikachu.properties");
        BotRunner.runBot(new PokeBot(), "abra.properties");
        BotRunner.runBot(new PokeBot(), "psykokwak.properties");
        BotRunner.runBot(new PokeBot(), "salameche.properties");
        BotRunner.runBot(new JudgeBot(), "viviane.properties");

    }
}
