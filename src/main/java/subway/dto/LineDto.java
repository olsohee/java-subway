package subway.dto;

public class LineDto {

    private final String lineName;

    public LineDto(String lineName) {
        this.lineName = lineName;
    }

    public String getLineName() {
        return lineName;
    }
}
