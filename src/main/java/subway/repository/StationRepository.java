package subway.repository;

import subway.domain.Station;
import subway.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATES_STATION.getErrorMessage());
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> station.getName().equals(name));
    }

    public static List<Station> findAll() {
        return stations();
    }

    public static boolean isExistByName(String stationName) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(stationName));
    }

    public static Station findByName(String stationName) {
        return stations.stream()
                .filter(station -> station.getName().equals(stationName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_STATION.getErrorMessage()));
    }
}
