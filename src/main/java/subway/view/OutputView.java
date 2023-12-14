package subway.view;

import subway.dto.LineAndStationDto;
import subway.dto.LineDto;
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

    public void printSectionFunction() {
        System.out.println(OutputMessage.SECTION_FUNCTION.getMessage());
        System.out.println();
    }

    public void printSuccessCreateStation() {
        System.out.println(InfoMessage.CREATE_STATION.getMessage());
        System.out.println();
    }

    public void printStations(List<StationDto> stationDtos) {
        System.out.println(OutputMessage.STATIONS.getMessage());
        stationDtos.stream()
                .forEach(dto -> System.out.println(String.format(InfoMessage.STATION_AND_LINE.getMessage(), dto.getStationName())));
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

    public void printLines(List<LineDto> lineDtos) {
        System.out.println(OutputMessage.LINES.getMessage());
        lineDtos.stream()
                .forEach(dto -> System.out.println(String.format(InfoMessage.STATION_AND_LINE.getMessage(), dto.getLineName())));
        System.out.println();
    }

    public void printSuccessDeleteLine() {
        System.out.println(InfoMessage.DELETE_LINE.getMessage());
        System.out.println();
    }

    public void printSuccessCreateSection() {
        System.out.println(InfoMessage.CREATE_SECTION.getMessage());
        System.out.println();
    }

    public void printSuccessDeleteSection() {
        System.out.println(InfoMessage.DELETE_SECTION.getMessage());
        System.out.println();
    }

    public void printMap(List<LineAndStationDto> lineAndStationDtos) {
        System.out.println(OutputMessage.MAP.getMessage());

        lineAndStationDtos.stream()
                .forEach(dto -> printDetailMap(dto));
    }

    private void printDetailMap(LineAndStationDto dto) {
        System.out.println(String.format(InfoMessage.STATION_AND_LINE.getMessage(), dto.getLineName()));
        System.out.println(String.format(InfoMessage.STATION_AND_LINE.getMessage(), "---"));
        dto.getStationNames().stream()
                .forEach(stationName -> System.out.println(String.format(InfoMessage.STATION_AND_LINE.getMessage(), stationName)));
        System.out.println();
    }
}
