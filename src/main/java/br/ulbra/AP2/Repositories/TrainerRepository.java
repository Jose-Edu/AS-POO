package br.ulbra.AP2.Repositories;

import br.ulbra.AP2.Models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
