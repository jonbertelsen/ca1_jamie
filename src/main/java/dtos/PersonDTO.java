package dtos;

import entities.Person;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PersonDTO implements Serializable {
    private final Integer id;
    private final AddressDTO address;
    private final String email;
    private final String firstName;
    private final String lastName;

    public PersonDTO(Integer id, AddressDTO address, String email, String firstName, String lastName) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Integer getId() {
        return id;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO entity = (PersonDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, email, firstName, lastName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "address = " + address + ", " +
                "email = " + email + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ")";
    }
}
