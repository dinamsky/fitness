package app.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@FitnessPlan(gym = "16", group = "16", pool = "16")
public class DayClient extends User {
    private LocalDate endOfReg;
    private int monthsToEnd;
    private Access group = new Access(8, 16, FitnessServiceEnumeration.GROUP);
    private Access gym = new Access(8, 16, FitnessServiceEnumeration.GYM);


    public Access getGroup() {
        return group;
    }

    public void setGroup(Access group) {
        this.group = group;
    }


    public DayClient(String surname, String name, int bYear) {
        super(surname, name, bYear);
        LocalDate reg = LocalDate.parse(getRegDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        this.endOfReg = reg.plusYears(1);

    }

    public DayClient(String surname, String name, int bYear, String regDate, int monthsToEnd) {
        super(surname, name, bYear, regDate);
        LocalDate reg = LocalDate.parse(getRegDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        this.endOfReg = reg.plusMonths(monthsToEnd);
    }
}