package br.ulbra.AP2.Controllers;

import br.ulbra.AP2.Dto.Requests.PokemonResquestDTO;
import br.ulbra.AP2.Dto.Responses.PokemonResponseDTO;
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
    public ResponseEntity<List<PokemonResponseDTO>> getPokemon() {
        return ResponseEntity.status(HttpStatus.OK).body(this.pokemonService.getAllPokemons());
    }

    @PostMapping("/pokemon")
    public ResponseEntity<String> addPokemon(@RequestBody PokemonResquestDTO pokemon) {
        this.pokemonService.addPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<PokemonResponseDTO> getPokemonById(@PathVariable int id) {
        PokemonResponseDTO poke = this.pokemonService.getPokemonById(id);
        if (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<PokemonResponseDTO> editPokemon(@PathVariable int id, @RequestBody PokemonResquestDTO pokemon) {
        PokemonResponseDTO poke = this.pokemonService.updatePokemonById(pokemon, id);
        if  (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<PokemonResponseDTO> deletePokemon(@PathVariable int id) {
        PokemonResponseDTO poke = this.pokemonService.deletePokemonById(id);
        if  (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
