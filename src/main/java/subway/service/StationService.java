package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.dto.StationDto;
import subway.message.ErrorMessage;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StationService {

    public void init() {
        Station 교대 = new Station("교대역");
        Station 강남 = new Station("강남역");
        Station 역삼 = new Station("역삼역");
        Station 남부터미널 = new Station("남부터미널역");
        Station 양재 = new Station("양재역");
        Station 양재시민의숲 = new Station("양재시민의숲역");
        Station 매봉 = new Station("매봉역");

        StationRepository.addStation(교대);
        StationRepository.addStation(강남);
        StationRepository.addStation(역삼);
        StationRepository.addStation(남부터미널);
        StationRepository.addStation(양재);
        StationRepository.addStation(양재시민의숲);
        StationRepository.addStation(매봉);

        List<Station> stations1 = new ArrayList<>();
        stations1.add(교대);
        stations1.add(강남);
        stations1.add(역삼);

        List<Station> stations2 = new ArrayList<>();
        stations2.add(교대);
        stations2.add(남부터미널);
        stations2.add(양재);
        stations2.add(매봉);

        List<Station> stations3 = new ArrayList<>();
        stations3.add(강남);
        stations3.add(양재);
        stations3.add(양재시민의숲);

        LineRepository.addLine(new Line("2호선", stations1));
        LineRepository.addLine(new Line("3호선", stations2));
        LineRepository.addLine(new Line("신분당선", stations3));
    }

    public void createStation(String stationName) {
        StationRepository.addStation(new Station(stationName));
    }

    public List<StationDto> getStationDtos() {
        return StationRepository.findAll().stream()
                .map(station -> new StationDto(station.getName()))
                .collect(Collectors.toList());
    }

    public void deleteStation(String stationName) {
        if (!StationRepository.isExistByName(stationName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_STATION.getErrorMessage());
        }
        StationRepository.deleteStation(stationName);
    }
}
