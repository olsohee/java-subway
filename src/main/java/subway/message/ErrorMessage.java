package subway.message;

public enum ErrorMessage {

    INVALID_INPUT("잘못된 입력입니다."),
    INVALID_COMMAND("선택할 수 없는 기능입니다."),
    INVALID_STATION("역 이름은 두 글자 이상이어야 합니다."),
    DUPLICATES_STATION("이미 등록된 역 이름입니다."),
    NOT_FOUND_STATION("해당 역을 찾을 수 없습니다."),
    NOT_DELETE_STATION("노선에 등록된 역을 삭제할 수 없습니다."),
    INVALID_LINE("노선 이름은 두 글자 이상이어야 합니다."),
    DUPLICATES_LINE("이미 등록된 노선 이름입니다."),
    NOT_FOUND_LINE("해당 노선을 찾을 수 없습니다."),
    NOT_DELETE_SECTION("노선에 역이 두개 이하일 때는 역을 삭제할 수 없습니다.")

    ;

    private static final String ERROR_HEADER = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return String.format("%s %s", ERROR_HEADER, errorMessage);
    }
}
