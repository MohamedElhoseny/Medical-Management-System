package entity;

import java.time.LocalDate;
import java.util.UUID;

public class Person
{
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String title;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private String phone;

    public Person(){
        //Generate uuid
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();

        //set default value for Gender
        this.gender = Gender.MALE;
    }

    public String getId() {
        return id;
    }

    public void setId(String uuid) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
