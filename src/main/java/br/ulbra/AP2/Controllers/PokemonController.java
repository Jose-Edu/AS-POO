package br.ulbra.AP2.Controllers;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Services.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getPokemon() {
        return ResponseEntity.status(HttpStatus.OK).body(this.pokemonService.getAllPokemons());
    }

    @PostMapping("/pokemon")
    public ResponseEntity<String> addPokemon(@RequestBody Pokemon pokemon) {
        boolean isInvalidId = this.pokemonService.addPokemon(pokemon) != null;
        if (isInvalidId) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O id "+pokemon.pokeId+" já existe, tente outro id");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/pokemon/list")
    public ResponseEntity<String> addPokemons(@RequestBody List<Pokemon> pokemons) {
        List<Pokemon> invalidIds = this.pokemonService.addPokemons(pokemons);

        if (invalidIds != null) {

            if (invalidIds.size() == pokemons.size()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ids já existentes, tente outros ids");
            }

            String rtn = "( ";
            for (Pokemon pokemon : invalidIds) {
                rtn += pokemon.pokeId + " ";
            }

            return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("Parte dos ids já existem, portanto, são inválidos. Os demais foram cadastrados corretamente! Ids inválidos: " + rtn + ")");
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/pokemon/name/{pokemonName}")
    public ResponseEntity<Pokemon> getPokemonByName(@PathVariable String pokemonName) {
        Pokemon pokemon = pokemonService.getPokemonByName(pokemonName);
        if (pokemon != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pokemon);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable int id) {
        Pokemon poke = this.pokemonService.getPokemonById(id);
        if (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> editPokemon(@PathVariable int id, @RequestBody Pokemon pokemon) {
        Pokemon poke = this.pokemonService.updatePokemonById(pokemon, id);
        if  (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> deletePokemon(@PathVariable int id) {
        Pokemon poke = this.pokemonService.deletePokemonById(id);
        if  (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
