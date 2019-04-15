package app.entities;

import java.time.LocalDate;

@FitnessPlan
public class FullDayClient extends User{
    private Access group = new Access(8, 22, FitnessServiceEnumeration.GROUP);
    private Access gym = new Access(8, 22, FitnessServiceEnumeration.GYM);
    private Access pool = new Access(8, 22, FitnessServiceEnumeration.POOL);

    public FullDayClient(String surname, String name, int bYear, String regDate) {
        super(surname, name, bYear, regDate);
    }

    public FullDayClient(String surname, String name, int bYear) {
        super(surname, name, bYear);
    }
}