package br.ulbra.AP2.Controllers;

import br.ulbra.AP2.Dto.Requests.PokemonResquestDTO;
import br.ulbra.AP2.Dto.Responses.PokemonResponseDTO;
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
    public ResponseEntity<PokemonResponseDTO> getPokemonById(@PathVariable long id) {
        PokemonResponseDTO poke = this.pokemonService.getPokemonById(id);
        if (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<PokemonResponseDTO> editPokemon(@PathVariable long id, @RequestBody PokemonResquestDTO pokemon) {
        PokemonResponseDTO poke = this.pokemonService.updatePokemonById(pokemon, id);
        if  (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable long id) {
        this.pokemonService.deletePokemonById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Treinador deletado com sucesso!");
    }
}
