package br.ulbra.AP2.Models;

import java.util.List;

public class Pokemon {
    public String name;
    public List<String> type;
    public int pokeId;

    public Pokemon(String name, List<String> type, int pokeId) {
        this.name = name;
        this.type = type;
        this.pokeId = pokeId;
    }

}
