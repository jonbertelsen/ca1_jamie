package dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class EventDeciderDto implements Serializable {
    private final Integer id;
    private final HobbyDto hobby;
    private final String hobby1;
    private final String category;
    private final Instant date;

    public EventDeciderDto(Integer id, HobbyDto hobby, String hobby1, String category, Instant date) {
        this.id = id;
        this.hobby = hobby;
        this.hobby1 = hobby1;
        this.category = category;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public HobbyDto getHobby() {
        return hobby;
    }

    public String getHobby1() {
        return hobby1;
    }

    public String getCategory() {
        return category;
    }

    public Instant getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDeciderDto entity = (EventDeciderDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.hobby, entity.hobby) &&
                Objects.equals(this.hobby1, entity.hobby1) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.date, entity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hobby, hobby1, category, date);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "hobby = " + hobby + ", " +
                "hobby1 = " + hobby1 + ", " +
                "category = " + category + ", " +
                "date = " + date + ")";
    }
}
