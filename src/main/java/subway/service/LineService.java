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

    public void validateCreateLineName(String lineName) {
        if (lineName.length() < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LINE.getErrorMessage());
        }

        if (LineRepository.isExistByName(lineName)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATES_LINE.getErrorMessage());
        }
    }

    public void validateLineName(String lineName) {
        if (!LineRepository.isExistByName(lineName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_LINE.getErrorMessage());
        }
    }

    public void createLine(String lineName, String upStation, String downStation) {
        Station up = StationRepository.findByName(upStation);
        Station down = StationRepository.findByName(downStation);
        List<Station> stations = new ArrayList<>();
        stations.add(up);
        stations.add(down);
        LineRepository.addLine(new Line(lineName, stations));
    }

    public List<LineDto> getLineDtos() {
        return LineRepository.findAll().stream()
                .map(line -> new LineDto(line.getName()))
                .collect(Collectors.toList());
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
        line.deleteStation(station);
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
