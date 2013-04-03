package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonMain {
    public static void main(String[] args) {
        BotRunner.runBot(new PokeBot(), "psykokwak.properties");
       // BotRunner.runBot(new PokeBot(), "pikachu.properties");

    }
}
