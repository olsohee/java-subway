package subway.dto;

public class StationDto {

    private final String stationName;

    public StationDto(String stationName) {
        this.stationName = stationName;
    }

    public String getStationName() {
        return stationName;
    }
}
