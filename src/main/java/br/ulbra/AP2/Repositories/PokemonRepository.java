package br.ulbra.AP2.Repositories;

import br.ulbra.AP2.Models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository  extends JpaRepository<Pokemon, Long> {

}
