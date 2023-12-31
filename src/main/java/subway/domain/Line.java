package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station, int order) {
        stations.add(order - 1, station);
    }

    public void deleteStation(Station station) {
        stations.remove(station);
    }

    public boolean canDeleteStation() {
        return stations.size() > 2;
    }

    public List<Station> getStations() {
        return stations;
    }
}
