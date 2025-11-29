package br.ulbra.AP2.Repositories;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainerRepository2 {
    private final List<Trainer> trainers;

    public TrainerRepository2() {
        this.trainers = new ArrayList<>();
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    private int getPositionById(int trainerId) {
        for(int i = 0; i < trainers.size(); i++) {
            if (trainerId == trainers.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public Trainer removeTrainer(int id) {
        for (Trainer trainer : trainers) {
            if (trainer.getId() == id) {
                trainers.remove(trainer);
                return trainer;
            }
        }
        return null;
    }

    public Trainer getTrainerById(int id) {
        for (Trainer trainer : trainers) {
            if (trainer.getId() == id) {
                return trainer;
            }
        }
        return null;
    }

    public Trainer setTrainer(Trainer trainerNew, int id) {
        int trainerPos = getPositionById(id);
        if (trainerPos == -1) {
            return null;
        }
        this.trainers.set(trainerPos, trainerNew);
        return trainerNew;
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
