package subway.view;

import subway.Application;

import java.util.Scanner;

public class InputView {

    private static final String READ_COMMAND = "## 원하는 기능을 선택하세요.";
    private static final String READ_CREATE_STATION = "## 등록할 역 이름을 입력하세요.";
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

    public String readCreateStation() {
        System.out.println(READ_CREATE_STATION);
        return scanner.nextLine();
    }
}
