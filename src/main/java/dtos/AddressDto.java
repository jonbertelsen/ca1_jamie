package dtos;

import java.io.Serializable;
import java.util.Objects;

public class AddressDto implements Serializable {
    private final Integer id;
    private final CityInfoDto cityInfo;
    private final String street;
    private final String streetNumber;
    private final String floor;

    public AddressDto(Integer id, CityInfoDto cityInfo, String street, String streetNumber, String floor) {
        this.id = id;
        this.cityInfo = cityInfo;
        this.street = street;
        this.streetNumber = streetNumber;
        this.floor = floor;
    }

    public Integer getId() {
        return id;
    }

    public CityInfoDto getCityInfo() {
        return cityInfo;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getFloor() {
        return floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto entity = (AddressDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cityInfo, entity.cityInfo) &&
                Objects.equals(this.street, entity.street) &&
                Objects.equals(this.streetNumber, entity.streetNumber) &&
                Objects.equals(this.floor, entity.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityInfo, street, streetNumber, floor);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cityInfo = " + cityInfo + ", " +
                "street = " + street + ", " +
                "streetNumber = " + streetNumber + ", " +
                "floor = " + floor + ")";
    }
}
