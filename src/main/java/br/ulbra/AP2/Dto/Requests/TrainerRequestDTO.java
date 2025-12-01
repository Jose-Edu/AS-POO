package br.ulbra.AP2.Dto.Requests;

import br.ulbra.AP2.Models.Trainer;

import java.util.List;

public class TrainerRequestDTO {
    private String name;

    public TrainerRequestDTO() {}

    public TrainerRequestDTO(String name) {
        this.name = name;
    }

    public TrainerRequestDTO(Trainer trainer) {
        this.name = trainer.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
