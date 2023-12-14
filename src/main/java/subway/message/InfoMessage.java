package subway.message;

public enum InfoMessage {

    CREATE_STATION("지하철 역이 등록되었습니다."),
    STATION(" %s")
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
