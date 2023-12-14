package subway.view;

import subway.Application;

import java.util.Scanner;

public class InputView {

    private static final String READ_COMMAND = "## 원하는 기능을 선택하세요.";
    private static final String READ_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
    private static final String READ_CREATE_STATION = "## 등록할 역 이름을 입력하세요.";
    private static final String READ_CREATE_LINE = "## 등록할 노선 이름을 입력하세요.";
    private static final String READ_UP_IN_LINE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String READ_DOWN_IN_LINE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    private static class InputViewHolder {
        private static InputView inputView = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHolder.inputView;
    }

    public String readCommand() {
        System.out.println(READ_COMMAND);
        return scanner.nextLine();
    }

    public String readDeleteStation() {
        System.out.println(READ_DELETE_STATION);
        return scanner.nextLine();
    }

    public String readCreateStation() {
        System.out.println(READ_CREATE_STATION);
        return scanner.nextLine();
    }

    public String readCreateLine() {
        System.out.println(READ_CREATE_LINE);
        return scanner.nextLine();
    }

    public String readUpInLine() {
        System.out.println(READ_UP_IN_LINE);
        return scanner.nextLine();
    }

    public String readDownInLine() {
        System.out.println(READ_DOWN_IN_LINE);
        return scanner.nextLine();
    }
}
