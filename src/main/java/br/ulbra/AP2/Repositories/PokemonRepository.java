package br.ulbra.AP2.Repositories;

import br.ulbra.AP2.Models.Pokemon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PokemonRepository {
    private final List<Pokemon> pokemons;

    public PokemonRepository() {
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    private int getPositionById(int pokemonId) {
        for(int i = 0; i < pokemons.size(); i++) {
            if (pokemonId == pokemons.get(i).getPokeId()) {
                return i;
            }
        }
        return -1;
    }

    public Pokemon getPokemonById(int idPokemon) {
        int pokemonPos = getPositionById(idPokemon);
        if (pokemonPos == -1) {
            return null;
        }

        return pokemons.get(pokemonPos);
    }

    public Pokemon setPokemon(Pokemon pokemon, int idPokemon) {
        int pokemonPos = getPositionById(idPokemon);
        if (pokemonPos == -1) {
            return null;
        }
        this.pokemons.set(pokemonPos, pokemon);
        return pokemon;
    }

    public Pokemon deletePokemon(int idPokemon) {
        Pokemon pokemon = getPokemonById(idPokemon);
        if (pokemon == null) {
            return null;
        }
        this.pokemons.remove(pokemon);
        return pokemon;
    }
    
}
