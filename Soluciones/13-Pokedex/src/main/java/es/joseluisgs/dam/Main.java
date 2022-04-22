package es.joseluisgs.dam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.joseluisgs.dam.controllers.PokemonController;
import es.joseluisgs.dam.models.Pokemon;

/**
 * https://freecodegenerators.com/code-converters/json-to-pojo
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Pokedex!");
        var pokeController = PokemonController.getInstance();
        var pokemon = pokeController.getPokemon(24);
        printPokemon(pokemon);
        printPokemonJson(pokemon);
    }

    private static void printPokemon(Pokemon pokemon) {
        System.out.println(pokemon);
    }

    private static void printPokemonJson(Pokemon pokemon) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(pokemon));
    }
}
