package subway.message;

public enum InputMessage {

    COMMAND("## 원하는 기능을 선택하세요."),
    DELETE_STATION("## 삭제할 역 이름을 입력하세요."),
    CREATE_STATION("## 등록할 역 이름을 입력하세요."),
    CREATE_LINE("## 등록할 노선 이름을 입력하세요."),
    UP_IN_LINE("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    DOWN_IN_LINE("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    DELETE_LINE("## 삭제할 노선 이름을 입력하세요."),
    LINE("## 노선을 입력하세요."),
    STATION("## 역이름을 입력하세요."),
    ORDER("## 순서를 입력하세요."),
    DELETE_SECTION_LINE("## 삭제할 구간의 노선을 입력하세요."),
    DELETE_SECTION_STATION("## 삭제할 구간의 역을 입력하세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
