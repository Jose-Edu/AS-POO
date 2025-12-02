package br.ulbra.AP2.Dto.Responses;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;

import java.util.List;

public class TrainerResponseDTOSlave {
    private String name;
    private long id;

    public TrainerResponseDTOSlave() {}

    public TrainerResponseDTOSlave(String name) {
        this.name = name;
    }

    public TrainerResponseDTOSlave(Trainer trainer) {
        this.name = trainer.getName();
        this.id = trainer.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
