package subway.domain;

import subway.message.ErrorMessage;

import java.util.Arrays;

public enum FuctionCommand {

    STATION("1"),
    LINE("2"),
    SECTION("3"),
    MAP("4"),
    QUIT("Q")
    ;

    private final String command;

    FuctionCommand(String command) {
        this.command = command;
    }

    public static FuctionCommand findCommand(String input) {
        return Arrays.stream(FuctionCommand.values())
                .filter(fuctionCommand -> fuctionCommand.getCommand().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.getErrorMessage()));
    }

    public String getCommand() {
        return command;
    }
}
