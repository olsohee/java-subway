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
            lineService.validateLineName(lineName);
            String stationName = inputView.readStation();
            if (!stationService.isExistStation(stationName)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_STATION.getErrorMessage());
            }
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
            lineService.deleteLine(inputView.readDeleteLine());
            outputView.printSuccessDeleteLine();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            deleteSection();
        }
    }
}
