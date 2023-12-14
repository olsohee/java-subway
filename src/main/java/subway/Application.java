package subway;

import subway.controller.MainController;
import subway.service.StationService;
import subway.utils.InputConvertor;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(InputView.getInstance(), InputConvertor.getInstance(),
                OutputView.getInstance(), new StationService());
        mainController.run();
    }
}
