package br.ulbra.AP2.Controllers;

import br.ulbra.AP2.Dto.Requests.TrainerRequestDTO;
import br.ulbra.AP2.Dto.Responses.TrainerResponseDTO;
import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;
import br.ulbra.AP2.Services.PokemonService;
import br.ulbra.AP2.Services.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainer")
    public ResponseEntity<List<TrainerResponseDTO>> getTrainers() {
        return ResponseEntity.status(HttpStatus.OK).body(this.trainerService.getAllTrainers());
    }

    @PostMapping("/trainer")
    public ResponseEntity<String> addTrainer(@RequestBody TrainerRequestDTO trainer) {
        this.trainerService.addTrainer(trainer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/trainer/{id}")
    public ResponseEntity<TrainerResponseDTO> getTrainerById(@PathVariable int id) {
        TrainerResponseDTO trainer = this.trainerService.getTrainerById(id);
        if (trainer != null) {
            return ResponseEntity.status(HttpStatus.OK).body(trainer);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/trainer/{id}")
    public ResponseEntity<TrainerResponseDTO> editTrainer(@PathVariable int id, @RequestBody TrainerRequestDTO trainerNew) {
        TrainerResponseDTO trainer = this.trainerService.updateTrainerById(trainerNew, id);
        if  (trainer != null) {
            return ResponseEntity.status(HttpStatus.OK).body(trainer);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/trainer/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable long id) {
        this.trainerService.deleteTrainerById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Treinador deletado com sucesso!");
    }
}
