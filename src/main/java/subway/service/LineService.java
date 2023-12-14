package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.dto.LineAndStationDto;
import subway.dto.LineDto;
import subway.message.ErrorMessage;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LineService {

    private final StationService stationService = new StationService();

    public void init() {
        List<Station> stations1 = new ArrayList<>();
        stations1.add(new Station("교대역"));
        stations1.add(new Station("강남역"));
        stations1.add(new Station("역삼역"));

        List<Station> stations2 = new ArrayList<>();
        stations2.add(new Station("교대역"));
        stations2.add(new Station("남부터미널"));
        stations2.add(new Station("양재역"));
        stations2.add(new Station("매봉역"));

        List<Station> stations3 = new ArrayList<>();
        stations3.add(new Station("강남역"));
        stations3.add(new Station("양재역"));
        stations3.add(new Station("양재시민의숲역"));

        LineRepository.addLine(new Line("2호선", stations1));
        LineRepository.addLine(new Line("3호선", stations2));
        LineRepository.addLine(new Line("신분당선", stations3));
    }

    public void validateIsExistByLineName(String lineName) {
        if (!LineRepository.isExistByName(lineName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_LINE.getErrorMessage());
        }
    }

    public void createLine(String lineName, String upStation, String downStation) {
        validateCreateLineName(lineName);

        List<Station> stations = new ArrayList<>();
        stations.add(StationRepository.findByName(upStation));
        stations.add(StationRepository.findByName(downStation));
        LineRepository.addLine(new Line(lineName, stations));
    }

    public void validateCreateLineName(String lineName) {
        if (lineName.length() < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LINE.getErrorMessage());
        }
        if (LineRepository.isExistByName(lineName)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATES_LINE.getErrorMessage());
        }
    }

    public void deleteLine(String lineName) {
        if (!LineRepository.isExistByName(lineName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_LINE.getErrorMessage());
        }
        LineRepository.deleteLineByName(lineName);
    }

    public void addStationInLine(String stationName, String lineName, int order) {
        Line line = LineRepository.findByName(lineName);
        Station station = StationRepository.findByName(stationName);
        line.addStation(station, order);
    }

    public void deleteStationInLine(String lineName, String stationName) {
        Line line = LineRepository.findByName(lineName);
        Station station = StationRepository.findByName(stationName);
        if (!line.canDeleteStation()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DELETE_SECTION.getErrorMessage());
        }
        line.deleteStation(station);
    }

    public List<LineDto> getLineDtos() {
        return LineRepository.findAll().stream()
                .map(line -> new LineDto(line.getName()))
                .collect(Collectors.toList());
    }

    public List<LineAndStationDto> getLineAndStationDtos() {
        List<LineAndStationDto> lineAndStationDto = new ArrayList<>();

        LineRepository.findAll();
        for (Line line : LineRepository.findAll()) {
            List<String> stationNames = line.getStations().stream()
                    .map(station -> station.getName())
                    .collect(Collectors.toList());
            lineAndStationDto.add(new LineAndStationDto(line.getName(), stationNames));
        }
        return lineAndStationDto;
    }
}
