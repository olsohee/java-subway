package subway.repository;

import subway.domain.Line;
import subway.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isContainInLine(String stationName) {
        return lines.stream()
                .anyMatch(line ->
                    line.getStations().stream()
                            .anyMatch(station -> station.getName().equals(stationName))
                );
    }

    public static boolean isExistByName(String lineName) {
        return lines.stream()
                .anyMatch(line -> line.getName().equals(lineName));
    }

    public static List<Line> findAll() {
        return lines();
    }

    public static Line findByName(String lineName) {
        return lines.stream()
                .filter(line -> line.getName().equals(lineName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_LINE.getErrorMessage()));
    }
}
