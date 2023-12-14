package subway.utils;

import subway.message.ErrorMessage;

public class InputConvertor {

    private static InputConvertor inputConvertor = new InputConvertor();

    private InputConvertor() {
    }

    public static InputConvertor getInstance() {
        return inputConvertor;
    }

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }
}
