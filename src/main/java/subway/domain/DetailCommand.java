package subway.domain;

import subway.message.ErrorMessage;

import java.util.Arrays;

public enum DetailCommand {

    CREATE("1"),
    DELETE("2"),
    READ("3"),
    BACK("B")
    ;

    private final String command;

    DetailCommand(String command) {
        this.command = command;
    }

    public static DetailCommand findCommand(String input) {
        return Arrays.stream(DetailCommand.values())
                .filter(command -> command.getCommand().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.getErrorMessage()));
    }

    public String getCommand() {
        return command;
    }
}
