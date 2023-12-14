package subway.controller;

import subway.domain.Command;
import subway.service.StationService;
import subway.utils.InputConvertor;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final InputConvertor inputConvertor;
    private final OutputView outputView;
    private final StationService stationService;
    private Command command;

    public MainController(InputView inputView, InputConvertor inputConvertor, OutputView outputView, StationService stationService) {
        this.inputView = inputView;
        this.inputConvertor = inputConvertor;
        this.outputView = outputView;
        this.stationService = stationService;
        stationService.init();
    }

    public void run() {
        while (true) {
            outputView.printMain();
            readCommand();
            if (command == Command.STATION) {
                new StationController().run();
            }
            if (command == Command.LINE) {
                new LineController().run();
            }
            if (command == Command.SECTION) {

            }
            if (command == Command.MAP) {

            }
            if (command == Command.QUIT) {

            }
        }
    }

    private void readCommand() {
        try {
            command = Command.findCommand(inputView.readCommand());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            readCommand();
        }
    }
}
