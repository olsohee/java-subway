package subway.domain;

import subway.message.ErrorMessage;

import java.util.Arrays;

public enum Command {

    STATION("1"),
    LINE("2"),
    SECTION("3"),
    MAP("4"),
    QUIT("Q")
    ;

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command findCommand(String input) {
        return Arrays.stream(Command.values())
                .filter(command -> command.getCommand().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.getErrorMessage()));
    }

    public String getCommand() {
        return command;
    }
}
