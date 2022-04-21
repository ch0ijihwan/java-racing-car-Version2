package view.display;

import controller.dto.CarsDto;
import controller.dto.WinnersDto;

import java.util.List;

public class ConsoleDisplay implements Display {
    private static final String POSITION_BAR = "-";
    public static final String CAR_NAMES_DELIMITER = ",";

    @Override
    public void printCarsStatus(final CarsDto carsDto) {
        List<String> carNames = carsDto.getCarNames();
        List<Integer> carPositions = carsDto.getCarPositions();
        System.out.println("실행 결과");

        for (int i = 0; i < carNames.size(); i++) {
            System.out.printf("%s : %s", carNames.get(i), generatePositionBars(carPositions, i));
        }
    }

    private String generatePositionBars(final List<Integer> carPositions, final int index) {
        return POSITION_BAR.repeat(carPositions.get(index));
    }

    @Override
    public void printWinners(final WinnersDto winnersDto) {
        List<String> winners = winnersDto.getNames();
        String winnerNames = String.join(CAR_NAMES_DELIMITER, winners);
        System.out.println(winnerNames);
    }
}
