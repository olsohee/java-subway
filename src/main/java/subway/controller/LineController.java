package subway.controller;

import subway.domain.DetailCommand;
import subway.message.ErrorMessage;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final LineService lineService = new LineService();
    private final StationService stationService = new StationService();
    private DetailCommand command;

    public void run() {
        outputView.printLineFunction();
        readCommand();
        if (command == DetailCommand.CREATE) {
            createLine();
        }
        if (command == DetailCommand.DELETE) {
            deleteLine();
        }
        if (command == DetailCommand.READ) {
            readLines();
        }
        if (command == DetailCommand.BACK) {

        }
    }

    private void readCommand() {
        try {
            command = DetailCommand.findCommand(inputView.readCommand());
        } catch (IllegalArgumentException e) {
            readCommand();
        }
    }

    private void createLine() {
        try {
            String lineName = inputView.readCreateLine();
            lineService.validateLineName(lineName);
            String upStation = inputView.readUpInLine();
            String downStation = inputView.readDownInLine();
            if (!stationService.isExistStation(upStation) || !stationService.isExistStation(downStation)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_STATION.getErrorMessage());
            }
            lineService.createLine(lineName, upStation, downStation);
            outputView.printSuccessCreateLine();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            createLine();
        }
    }

    private void deleteLine() {
        try {
            stationService.deleteStation(inputView.readDeleteStation());
            outputView.printSuccessDeleteStation();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            deleteLine();
        }
    }

    private void readLines() {
        outputView.printStations(stationService.getStationDtos());
    }
}
