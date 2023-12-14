package subway.domain;

import subway.message.ErrorMessage;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STATION.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
