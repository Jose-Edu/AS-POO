package br.ulbra.AP2.Dto.Responses;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;

import java.util.List;

public class TrainerResponseDTO {
    private String name;
    private List<PokemonResponseDTO> pokemons;

    public TrainerResponseDTO() {}

    public TrainerResponseDTO(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons.stream().map(p -> new PokemonResponseDTO(p)).toList();
    }

    public TrainerResponseDTO(Trainer trainer) {
        this.name = trainer.getName();
        this.pokemons = trainer.getPokemons().stream().map(p -> new PokemonResponseDTO(p)).toList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonResponseDTO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonResponseDTO> pokemons) {
        this.pokemons = pokemons;
    }
}
