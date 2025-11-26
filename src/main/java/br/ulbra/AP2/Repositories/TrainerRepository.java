package br.ulbra.AP2.Repositories;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainerRepository {
    private final List<Trainer> trainers;

    public TrainerRepository() {
        this.trainers = new ArrayList<>();
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void removeTrainer(int id) {
        for (Trainer trainer : trainers) {
            if (trainer.getId() == id) {
                trainers.remove(trainer);
            }
        }
    }

    public Trainer getTrainerById(int id) {
        for (Trainer trainer : trainers) {
            if (trainer.getId() == id) {
                return trainer;
            }
        }
        return null;
    }

    public void updateTrainer(Trainer trainer) {
        trainers.remove(trainer);
        trainers.add(trainer);
    }

    public List<Pokemon> getPokemonsByTrainerId(int id) {
        for (Trainer trainer : trainers) {
            if (trainer.getId() == id) {
                return trainer.getPokemons();
            }
        }
        return null;
    }
}
