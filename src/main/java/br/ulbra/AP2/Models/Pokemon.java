package br.ulbra.AP2.Models;
import java.util.List;

import br.ulbra.AP2.Dto.Requests.PokemonResquestDTO;
import jakarta.persistence.*;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;
    private List<String> type;

    @ManyToOne
    private Trainer trainer;

    public Pokemon() {

    }

    public Pokemon(PokemonResquestDTO pokemon) {
        this.name = pokemon.getName();
        this.type = pokemon.getType();
        this.trainer = pokemon.getTrainer();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getType() {
        return type;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
