package br.ulbra.AP2.Services;

import br.ulbra.AP2.Dto.Requests.PokemonResquestDTO;
import br.ulbra.AP2.Dto.Responses.PokemonResponseDTO;
import br.ulbra.AP2.Dto.Responses.TrainerResponseDTO;
import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;
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

        List<PokemonResponseDTO>  pokemonsResponse = new ArrayList<>();
        List<Pokemon> pokemons = pokemonRepository.findAll();

        pokemons.forEach(pokemon -> {
            pokemonsResponse.add(new PokemonResponseDTO(pokemon));
        });

        return pokemonsResponse;
    }

    public PokemonResponseDTO getPokemonById(long id) {
        Pokemon pokemon = pokemonRepository.findById(id).get();

        if (pokemon != null) {
            return new PokemonResponseDTO(pokemon);
        }

        return null;
    }

    public PokemonResponseDTO updatePokemonById(PokemonResquestDTO pokemonNew, long id) {
        Pokemon newPokemon = new Pokemon(pokemonNew);

        var tempPokemon = pokemonRepository.findById(id);
        if (tempPokemon.isEmpty()) {
            return null;
        }
        Pokemon pokemon = tempPokemon.get();
        pokemon.setName(newPokemon.getName());
        pokemonRepository.save(pokemon);
        return new PokemonResponseDTO(pokemon);
    }

    public void deletePokemonById(long idPokemon) {
        pokemonRepository.deleteById(idPokemon);
    }

    public void addPokemon(PokemonResquestDTO pokemon) {
        Pokemon pokeAdd = new Pokemon(pokemon);
        pokemonRepository.save(pokeAdd);
    }


}
