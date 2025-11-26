package br.ulbra.AP2.Services;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;
import br.ulbra.AP2.Repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getTrainers() {
        return trainerRepository.getTrainers();
    }

    public void addTrainer(Trainer trainer) {
        trainerRepository.addTrainer(trainer);
    }

    public void removeTrainer(int id)
    {
        trainerRepository.removeTrainer(id);
    }

    public Trainer getTrainerById(int id){
        return trainerRepository.getTrainerById(id);
    }

    public void  updateTrainer(Trainer trainer) {
        trainerRepository.updateTrainer(trainer);
    }

    public List<Pokemon> getPokemonsByTrainerId(int id) {
        return trainerRepository.getPokemonsByTrainerId(id);
    }
}
