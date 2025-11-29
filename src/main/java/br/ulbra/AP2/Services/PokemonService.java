package br.ulbra.AP2.Services;

import br.ulbra.AP2.Dto.Requests.PokemonResquestDTO;
import br.ulbra.AP2.Dto.Responses.PokemonResponseDTO;
import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Repositories.PokemonRepository2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository2 pokemonRepository;

    public PokemonService(PokemonRepository2 pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonResponseDTO> getAllPokemons() {
        List<Pokemon> pokemons = pokemonRepository.getPokemons();
        List<PokemonResponseDTO> pokemonResponseDTOs = pokemons.stream().map(p -> new PokemonResponseDTO(p)).toList();

        return pokemonResponseDTOs;
    }

    public PokemonResponseDTO getPokemonById(int idPokemon) {
        PokemonResponseDTO pokemon = new PokemonResponseDTO(pokemonRepository.getPokemonById(idPokemon));
        return pokemon;
    }

    public PokemonResponseDTO updatePokemonById(PokemonResquestDTO pokemon, int idPokemon) {
        Pokemon newPokemon = new Pokemon(pokemon);
        Pokemon poke = pokemonRepository.setPokemon(newPokemon, idPokemon);
        return new PokemonResponseDTO(poke);
    }

    public PokemonResponseDTO deletePokemonById(int idPokemon) {
        Pokemon deletedPokemon = pokemonRepository.deletePokemon(idPokemon);
        return new PokemonResponseDTO(deletedPokemon);
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
