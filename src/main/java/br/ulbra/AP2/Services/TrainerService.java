package br.ulbra.AP2.Services;

import br.ulbra.AP2.Dto.Requests.TrainerRequestDTO;
import br.ulbra.AP2.Dto.Responses.TrainerResponseDTO;
import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;
import br.ulbra.AP2.Repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<TrainerResponseDTO> getTrainers() {
        List<TrainerResponseDTO>  trainersResponse = new ArrayList<>();
        List<Trainer> trainers = trainerRepository.getTrainers();

        trainers.forEach(trainer -> {
            trainersResponse.add(new TrainerResponseDTO(trainer));
        });

        return trainersResponse;
    }

    public void addTrainer(TrainerRequestDTO trainer) {
        Trainer newTrainer = new Trainer(trainer);
        trainerRepository.addTrainer(newTrainer);
    }

    public TrainerResponseDTO deleteTrainerById(int id)
    {
        Trainer deletedTrainer = trainerRepository.removeTrainer(id);

        if (deletedTrainer != null) {
            return new TrainerResponseDTO(deletedTrainer);
        }

        return null;
    }

    public TrainerResponseDTO getTrainerById(int id){
        Trainer trainer = trainerRepository.getTrainerById(id);

        if (trainer != null) {
            return new TrainerResponseDTO(trainer);
        }

        return null;
    }

    public void updateTrainerById(Trainer trainer) {
        trainerRepository.updateTrainer(trainer);
    }

    public List<Pokemon> getPokemonsByTrainerId(int id) {
        return trainerRepository.getPokemonsByTrainerId(id);
    }
}
