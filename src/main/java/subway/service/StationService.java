package subway.service;

import subway.domain.Station;
import subway.dto.StationDto;
import subway.message.ErrorMessage;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {

    public void init() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    public void validateIsExistByLineName(String stationName) {
        if (!StationRepository.isExistByName(stationName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_STATION.getErrorMessage());
        }
    }

    public void createStation(String stationName) {
        validateDuplicated(stationName);
        StationRepository.addStation(new Station(stationName));
    }

    private void validateDuplicated(String stationName) {
        if (StationRepository.isExistByName(stationName)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATES_STATION.getErrorMessage());
        }
    }

    public void deleteStation(String stationName) {
        if (!StationRepository.isExistByName(stationName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_STATION.getErrorMessage());
        }
        if (LineRepository.isContainInLine(stationName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DELETE_STATION.getErrorMessage());
        }
        StationRepository.deleteStation(stationName);
    }

    public boolean isExistStation(String stationName) {
        return StationRepository.isExistByName(stationName);
    }

    public List<StationDto> getStationDtos() {
        return StationRepository.findAll().stream()
                .map(station -> new StationDto(station.getName()))
                .collect(Collectors.toList());
    }
}
