package br.ulbra.AP2.Dto.Requests;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Models.Trainer;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonResquestDTO {
    private String name;
    private List<String> type;
    @JsonProperty("trainer_id")
    private long trainer_id;

    public PokemonResquestDTO() {}

    public PokemonResquestDTO(String name, List<String> type, long trainer_id) {
        this.name = name;
        this.type = type;
        this.trainer_id = trainer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public long getTrainerId() {
        return trainer_id;
    }

    public void setTrainerId(long trainer_id) {
        this.trainer_id = trainer_id;
    }
}
