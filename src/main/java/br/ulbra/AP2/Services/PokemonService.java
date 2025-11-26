package br.ulbra.AP2.Services;

import br.ulbra.AP2.Dto.Requests.PokemonResquestDTO;
import br.ulbra.AP2.Dto.Responses.PokemonResponseDTO;
import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Repositories.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonResponseDTO> getAllPokemons() {
        List<Pokemon> pokemons = pokemonRepository.getPokemons();
        List<PokemonResponseDTO> pokemonResponseDTOs = pokemons.stream().map(p -> new PokemonResponseDTO(p)).toList();

        return pokemonResponseDTOs;
    }

    public Pokemon getPokemonById(int idPokemon) {
            return pokemonRepository.getPokemonById(idPokemon);
    }

    public PokemonResponseDTO getPokemonByName(String namePokemon) {
        for (PokemonResponseDTO pokemon : getAllPokemons()) {
            if (pokemon.getName().equals(namePokemon)) {
                return pokemon;
            }
        }
        return null;
    }

    public Pokemon updatePokemonById(Pokemon pokemon, int idPokemon) {
        return pokemonRepository.setPokemon(pokemon, idPokemon);
    }

    public Pokemon deletePokemonById(int idPokemon) {
        return pokemonRepository.deletePokemon(idPokemon);
    }

    public void addPokemon(PokemonResquestDTO pokemon) {
        Pokemon pokeAdd = new Pokemon(pokemon);
        pokemonRepository.addPokemon(pokeAdd);
    }

    public void addPokemons(List<Pokemon> pokemons) {
        for (Pokemon pokemon : pokemons) {
            pokemonRepository.addPokemon(pokemon);
        }
    }

}
