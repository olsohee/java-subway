package subway.controller;

import subway.domain.DetailCommand;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final LineService lineService = LineService.getInstance();
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
            String upStation = inputView.readUpInLine();
            String downStation = inputView.readDownInLine();
            lineService.createLine(lineName, upStation, downStation);
            outputView.printSuccessCreateLine();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            createLine();
        }
    }

    private void deleteLine() {
        try {
            lineService.deleteLine(inputView.readDeleteLine());
            outputView.printSuccessDeleteLine();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            deleteLine();
        }
    }

    private void readLines() {
        outputView.printLines(lineService.getLineDtos());
    }
}
