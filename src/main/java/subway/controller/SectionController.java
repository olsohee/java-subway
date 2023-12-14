package subway.controller;

import subway.domain.DetailCommand;
import subway.message.ErrorMessage;
import subway.service.LineService;
import subway.service.StationService;
import subway.utils.InputConvertor;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final StationService stationService = new StationService();
    private final LineService lineService = new LineService();
    private final InputConvertor inputConvertor = InputConvertor.getInstance();
    private DetailCommand command;

    public void run() {
        outputView.printSectionFunction();
        readCommand();
        if (command == DetailCommand.CREATE) {
            createSection();
        }
        if (command == DetailCommand.DELETE) {
            deleteSection();
        }
        if (command == DetailCommand.READ) {
            try {
                throw new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.getErrorMessage());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                run();
            }
        }
    }

    private void readCommand() {
        try {
            command = DetailCommand.findCommand(inputView.readCommand());
        } catch (IllegalArgumentException e) {
            readCommand();
        }
    }

    private void createSection() {
        try {
            String lineName = inputView.readLine();
            String stationName = inputView.readStation();
            int order = inputConvertor.convertToInt(inputView.readOrder());

            lineService.addStationInLine(stationName, lineName, order);
            outputView.printSuccessCreateSection();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            createSection();
        }
    }

    private void deleteSection() {
        try {
            String line = inputView.readDeleteSectionLine();
            String station = inputView.readDeleteSectionStation();
            lineService.deleteStationInLine(line, station);
            outputView.printSuccessDeleteSection();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            deleteSection();
        }
    }
}
