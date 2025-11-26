package br.ulbra.AP2.Dto.Responses;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;

import java.util.List;

public class TrainerResponseDTO {
    private String name;
    private List<Pokemon> pokemons;

    public TrainerResponseDTO() {}

    public TrainerResponseDTO(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public TrainerResponseDTO(Trainer trainer) {
        this.name = trainer.getName();
        this.pokemons = trainer.getPokemons();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
