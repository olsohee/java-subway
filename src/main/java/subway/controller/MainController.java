package subway.controller;

import subway.domain.FuctionCommand;
import subway.service.LineService;
import subway.service.StationService;
import subway.utils.InputConvertor;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final InputConvertor inputConvertor;
    private final OutputView outputView;
    private final StationService stationService = new StationService();
    private final LineService lineService = new LineService();
    private FuctionCommand fuctionCommand;

    public MainController(InputView inputView, InputConvertor inputConvertor, OutputView outputView) {
        this.inputView = inputView;
        this.inputConvertor = inputConvertor;
        this.outputView = outputView;
        stationService.init();
        lineService.init();
    }

    public void run() {
        while (true) {
            outputView.printMain();
            readCommand();
            if (fuctionCommand == FuctionCommand.STATION) {
                new StationController().run();
            }
            if (fuctionCommand == FuctionCommand.LINE) {
                new LineController().run();
            }
            if (fuctionCommand == FuctionCommand.SECTION) {
                new SectionController().run();
            }
            if (fuctionCommand == FuctionCommand.MAP) {
                new MapController().run();
            }
            if (fuctionCommand == FuctionCommand.QUIT) {
                break;
            }
        }
    }

    private void readCommand() {
        try {
            fuctionCommand = FuctionCommand.findCommand(inputView.readCommand());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            readCommand();
        }
    }
}
