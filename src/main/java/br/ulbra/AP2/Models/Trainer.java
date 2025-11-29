package br.ulbra.AP2.Models;


import br.ulbra.AP2.Dto.Requests.PokemonResquestDTO;
import br.ulbra.AP2.Dto.Requests.TrainerRequestDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "trainer")
    private List<Pokemon> pokemons;

    public Trainer() {

    }

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public Trainer(TrainerRequestDTO trainer) {
        this.name = trainer.getName();
        this.pokemons = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
