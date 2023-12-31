package subway.controller;

import subway.service.LineService;
import subway.view.OutputView;

public class MapController {

    private final OutputView outputView = OutputView.getInstance();
    private final LineService lineService = LineService.getInstance();

    public void run() {
        outputView.printMap(lineService.getLineAndStationDtos());
    }
}
