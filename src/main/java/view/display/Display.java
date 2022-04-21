package view.display;

import controller.dto.CarsDto;
import controller.dto.WinnersDto;

public interface Display {
    void printCarsStatus(CarsDto carsDto);
    void printWinners(WinnersDto winnersDto);
}
