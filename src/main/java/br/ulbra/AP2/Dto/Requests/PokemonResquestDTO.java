package br.ulbra.AP2.Dto.Requests;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;

import java.util.List;

public class PokemonResquestDTO {
    private String name;
    private List<String> type;
    private Trainer trainer;

    public PokemonResquestDTO() {}

    public PokemonResquestDTO(Pokemon pokemon) {
        this.name = pokemon.getName();
        this.type = pokemon.getType();
        this.trainer = pokemon.getTrainer();
    }

    public PokemonResquestDTO(String name, List<String> type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
