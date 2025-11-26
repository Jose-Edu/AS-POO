package br.ulbra.AP2.Models;
import java.util.List;

import br.ulbra.AP2.Dto.Requests.PokemonResquestDTO;
import jakarta.persistence.*;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;
    private List<String> type;

    public Pokemon() {

    }

    public Pokemon(String name, List<String> type, int pokeId) {
        this.name = name;
        this.type = type;
    }

    public Pokemon(PokemonResquestDTO pokemon) {
        this.name = pokemon.getName();
        this.type = pokemon.getType();
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getType() {
        return type;
    }
}
