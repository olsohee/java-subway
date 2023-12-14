package subway.repository;

import subway.domain.Line;

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
}
