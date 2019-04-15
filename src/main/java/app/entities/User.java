package app.entities;


import java.time.LocalDate;

public class User {
    private String surname;
    private String name;
    private String bYear;
    private String regDate;

    public User(String surname, String name, int bYear, String regDate) {
        this.surname = surname;
        this.name = name;
        this.bYear = bYear;
        this.regDate = regDate;
    }

    public User(String surname, String name, int bYear) {
        this.surname = surname;
        this.name = name;
        this.bYear = bYear;
        this.regDate = LocalDate.now().toString();

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getbYear() {
        return bYear;
    }

    public void setbYear(int bYear) {
        this.bYear = bYear;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
