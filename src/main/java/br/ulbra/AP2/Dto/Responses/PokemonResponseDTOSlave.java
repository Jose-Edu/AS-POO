package br.ulbra.AP2.Dto.Responses;

import br.ulbra.AP2.Models.Pokemon;

import java.util.List;

public class PokemonResponseDTOSlave {
    private Long id;
    private String name;
    private List<String> type;

    public PokemonResponseDTOSlave() {}

    public PokemonResponseDTOSlave(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.type = pokemon.getType();
    }

    public PokemonResponseDTOSlave(String name, List<String> type) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
