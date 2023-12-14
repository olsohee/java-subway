package subway.controller;

import subway.domain.DetailCommand;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final StationService stationService = new StationService();
    private DetailCommand command;

    public void run() {
        outputView.printStationFunction();
        readCommand();
        if (command == DetailCommand.CREATE) {
            createStation();
        }
        if (command == DetailCommand.DELETE) {
            deleteStation();
        }
        if (command == DetailCommand.READ) {
            readStations();
        }
    }

    private void readCommand() {
        try {
            command = DetailCommand.findCommand(inputView.readCommand());
        } catch (IllegalArgumentException e) {
            readCommand();
        }
    }

    private void createStation() {
        try {
            stationService.createStation(inputView.readCreateStation());
            outputView.printSuccessCreateStation();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            createStation();
        }
    }

    private void deleteStation() {
        try {
            stationService.deleteStation(inputView.readDeleteStation());
            outputView.printSuccessDeleteStation();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            deleteStation();
        }
    }

    private void readStations() {
        outputView.printStations(stationService.getStationDtos());
    }
}
