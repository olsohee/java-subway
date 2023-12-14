package subway.message;

public enum InfoMessage {

    CREATE_STATION("지하철 역이 등록되었습니다."),
    DELETE_STATION("지하철 역이 삭제되었습니다."),
    CREATE_LINE("지하철 노선이 등록되었습니다."),
    DELETE_LINE("지하철 노선이 삭제되었습니다."),
    CREATE_SECTION("구간이 등록되었습니다."),
    STATION_AND_LINE(" %s")
    ;

    private static final String INFO_HEADER = "[INFO]";
    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s", INFO_HEADER, message);
    }
}
