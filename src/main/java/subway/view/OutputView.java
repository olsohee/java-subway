package subway.view;

import subway.message.OutputMessage;

public class OutputView {

    private OutputView() {
    }

    private static class OutputViewHolder {
        private static OutputView outputView = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.outputView;
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printMain() {
        System.out.println(OutputMessage.MAIN.getMessage());
        System.out.println();
    }

    public void printStationFunction() {
        System.out.println(OutputMessage.STATION_FUNCTION.getMessage());
        System.out.println();
    }
}
