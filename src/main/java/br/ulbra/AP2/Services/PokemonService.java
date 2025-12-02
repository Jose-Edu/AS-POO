package br.ulbra.AP2.Services;

import br.ulbra.AP2.Dto.Requests.PokemonResquestDTO;
import br.ulbra.AP2.Dto.Responses.PokemonResponseDTO;
import br.ulbra.AP2.Dto.Responses.TrainerResponseDTO;
import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;
import br.ulbra.AP2.Repositories.PokemonRepository;
import br.ulbra.AP2.Repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TrainerRepository trainerRepository;

    public PokemonService(PokemonRepository pokemonRepository, TrainerRepository trainerRepository)
    {
        this.pokemonRepository = pokemonRepository;
        this.trainerRepository = trainerRepository;
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

    public PokemonResponseDTO updatePokemonById(PokemonResquestDTO pokemonNew, long idPokemon) {
        Trainer trainer = trainerRepository.findById(pokemonNew.getTrainerId()).get();
        Pokemon newPokemon = new Pokemon(pokemonNew, trainer);

        var tempPokemon = pokemonRepository.findById(idPokemon);
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
        System.out.println("trainer id: " + pokemon.getTrainerId());
        Trainer trainer = trainerRepository.findById(pokemon.getTrainerId()).get();
        Pokemon pokeAdd = new Pokemon(pokemon, trainer);
        pokemonRepository.save(pokeAdd);
    }


}
