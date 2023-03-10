package dtos;

import java.io.Serializable;
import java.util.Objects;

public class PhoneDto implements Serializable {
    private final Integer id;
    private final Integer number;
    private final String description;

    public PhoneDto(Integer id, Integer number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneDto entity = (PhoneDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.number, entity.number) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "number = " + number + ", " +
                "description = " + description + ")";
    }
}
