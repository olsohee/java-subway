package subway.controller;

import subway.service.LineService;
import subway.service.StationService;
import subway.utils.InputConvertor;
import subway.view.InputView;
import subway.view.OutputView;

public class MapController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final StationService stationService = new StationService();
    private final LineService lineService = new LineService();
    private final InputConvertor inputConvertor = InputConvertor.getInstance();

    public void run() {
        outputView.printMap(lineService.getLineAndStationDtos());
    }
}
