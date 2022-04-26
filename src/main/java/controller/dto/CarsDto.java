package controller.dto;

import java.util.List;

public class CarsDto {
    private final List<String> carNames;
    private final List<Integer> carPositions;

    public CarsDto(final List<String> carNames, final List<Integer> carPositions) {
        this.carNames = carNames;
        this.carPositions = carPositions;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
