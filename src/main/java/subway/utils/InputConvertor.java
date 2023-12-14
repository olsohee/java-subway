package subway.utils;

import subway.message.ErrorMessage;

public class InputConvertor {

    private InputConvertor() {
    }

    private static class InputConvertorHolder {
        private static InputConvertor inputConvertor = new InputConvertor();
    }

    public static InputConvertor getInstance() {
        return InputConvertorHolder.inputConvertor;
    }

    public int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }
}
