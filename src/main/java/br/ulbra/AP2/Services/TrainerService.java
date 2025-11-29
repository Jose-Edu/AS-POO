package br.ulbra.AP2.Services;

import br.ulbra.AP2.Dto.Requests.TrainerRequestDTO;
import br.ulbra.AP2.Dto.Responses.TrainerResponseDTO;
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

    public List<TrainerResponseDTO> getAllTrainers() {
        List<TrainerResponseDTO>  trainersResponse = new ArrayList<>();
        List<Trainer> trainers = trainerRepository.findAll();

        trainers.forEach(trainer -> {
            trainersResponse.add(new TrainerResponseDTO(trainer));
        });

        return trainersResponse;
    }

    public void addTrainer(TrainerRequestDTO trainer) {
        Trainer newTrainer = new Trainer(trainer);
        trainerRepository.save(newTrainer);
    }

    public void deleteTrainerById(long id)
    {
        trainerRepository.deleteById(id);
    }

    public TrainerResponseDTO getTrainerById(long id){
        Trainer trainer = trainerRepository.findById(id).get();

        if (trainer != null) {
            return new TrainerResponseDTO(trainer);
        }

        return null;
    }

    public TrainerResponseDTO updateTrainerById(TrainerRequestDTO trainerNew, long id) {
        Trainer newTrainer = new Trainer(trainerNew);
        var tempTrainer = trainerRepository.findById(id);
        if (tempTrainer.isEmpty()) {
            return null;
        }
        Trainer trainer = tempTrainer.get();
        trainer.setName(newTrainer.getName());
        trainerRepository.save(trainer);
        return new TrainerResponseDTO(trainer);
    }

}
