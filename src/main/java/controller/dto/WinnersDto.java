package controller.dto;

import java.util.List;

public class WinnersDto {
    private final List<String> names;

    public WinnersDto(final List<String> winnerNames) {
        this.names = winnerNames;
    }

    public List<String> getNames() {
        return names;
    }
}
