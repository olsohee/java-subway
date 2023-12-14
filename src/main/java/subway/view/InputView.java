package subway.view;

import subway.message.InputMessage;

import java.util.Scanner;

import static subway.message.InputMessage.*;

public class InputView {

    final Scanner scanner = new Scanner(System.in);

    private static InputView inputView = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public String readCommand() {
        System.out.println(InputMessage.COMMAND.getMessage());
        return scanner.nextLine();
    }

    public String readDeleteStation() {
        System.out.println(DELETE_STATION);
        return scanner.nextLine();
    }

    public String readCreateStation() {
        System.out.println(CREATE_STATION);
        return scanner.nextLine();
    }

    public String readCreateLine() {
        System.out.println(CREATE_LINE);
        return scanner.nextLine();
    }

    public String readUpInLine() {
        System.out.println(UP_IN_LINE);
        return scanner.nextLine();
    }

    public String readDownInLine() {
        System.out.println(DOWN_IN_LINE);
        return scanner.nextLine();
    }

    public String readDeleteLine() {
        System.out.println(DELETE_LINE);
        return scanner.nextLine();
    }

    public String readLine() {
        System.out.println(LINE);
        return scanner.nextLine();
    }

    public String readStation() {
        System.out.println(STATION);
        return scanner.nextLine();
    }

    public String readOrder() {
        System.out.println(ORDER);
        return scanner.nextLine();
    }

    public String readDeleteSectionLine() {
        System.out.println(DELETE_SECTION_LINE);
        return scanner.nextLine();
    }

    public String readDeleteSectionStation() {
        System.out.println(DELETE_SECTION_STATION);
        return scanner.nextLine();
    }
}
