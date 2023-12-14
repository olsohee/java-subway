package subway.view;

import subway.dto.StationDto;
import subway.message.InfoMessage;
import subway.message.OutputMessage;

import java.util.List;

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

    public void printLineFunction() {
        System.out.println(OutputMessage.LINE_FUNCTION.getMessage());
        System.out.println();
    }

    public void printSuccessCreateStation() {
        System.out.println(InfoMessage.CREATE_STATION.getMessage());
        System.out.println();
    }

    public void printStations(List<StationDto> stationDtos) {
        System.out.println(OutputMessage.STATIONS.getMessage());
        stationDtos.stream()
                .forEach(dto -> System.out.println(String.format(InfoMessage.STATION.getMessage(), dto.getStationName())));
        System.out.println();
    }

    public void printSuccessDeleteStation() {
        System.out.println(InfoMessage.DELETE_STATION.getMessage());
        System.out.println();
    }

    public void printSuccessCreateLine() {
        System.out.println(InfoMessage.CREATE_LINE.getMessage());
        System.out.println();
    }
}
