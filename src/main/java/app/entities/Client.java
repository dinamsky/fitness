package app.entities;



@FitnessPlan(group = "0")
public class Client extends User {

    private boolean isVisited = false;
    private Access gym = new Access(8, 22, FitnessServiceEnumeration.GYM);
    private Access pool = new Access(8, 22, FitnessServiceEnumeration.POOL);

    public Client(String surname, String name, int bYear, String regDate) {
        super(surname, name, bYear, regDate);
    }

    public Client(String surname, String name, int bYear) {
        super(surname, name, bYear);

    }

    public Access getGym() {
        return gym;
    }

    public void setGym(Access gym) {
        this.gym = gym;
    }

    public Access getPool() {
        return pool;
    }

    public void setPool(Access pool) {
        this.pool = pool;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }


}