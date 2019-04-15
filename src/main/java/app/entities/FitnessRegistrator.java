package app.entities;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalTime;
import java.util.*;

public class FitnessRegistrator {
    //    ArrayList<User> inGym = new ArrayList<>();
//    ArrayList<User> inPool = new ArrayList<>();
//    ArrayList<User> inGroup = new ArrayList<>();
    //либо
    private HashMap<String, HashSet<User>> clients = new HashMap<>();

    public void add(User User, FitnessServiceEnumeration type) throws IllegalAccessException, NoAccessException, QueueException, IOException {
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (User.getClass().isAnnotationPresent(FitnessPlan.class)) {
                try {
                    Field field = User.getClass().getDeclaredField("gym");
                    field.setAccessible(true);
                    Access access = (Access) field.get(User);
                    if (LocalTime.now().getHour() > access.getFrom() && LocalTime.now().getHour() < access.getTo()) {
                        if (!clients.containsKey(type.toString())) {
                            clients.put(type.toString(), new HashSet<>());
                        }
                        if (clients.get(type.toString()).size() > 20) {
                            throw new QueueException("Занимается больше чем 20 клиентов");
                        } else {
                            if(User.getClass().getSimpleName().equals("Client")){
                                Field field1 = User.getClass().getDeclaredField("isVisited");
                                field1.setAccessible(true);
                                boolean vis = field1.getBoolean(User);
                                if(vis == false) {
                                    clients.get(type.toString()).add(User);
                                    FitnessLogger.PrintTofile(User, type);
                                    field1.setBoolean(User, true);
                                } else {
                                    throw new NoAccessException("Посетитель уже приходил");
                                }
                            } else{
                                clients.get(type.toString()).add(User);
                                FitnessLogger.PrintTofile(User, type);
                            }
                        }
                    } else {
                        throw new NoAccessException("Посетитель не может заниматься в данное время");
                    }
                } catch (NoSuchFieldException e) {
                    throw new NoAccessException("У посетителя нет доступа");
                }
            } else {
                throw new NoAccessException("У посетителя нет доступа");
            }
        } else if (FitnessServiceEnumeration.POOL.equals(type)) {
            if (User.getClass().isAnnotationPresent(FitnessPlan.class)) {
                try {
                    Field field = User.getClass().getDeclaredField("pool");
                    field.setAccessible(true);
                    Access access = (Access) field.get(User);
                    if (LocalTime.now().getHour() > access.getFrom() && LocalTime.now().getHour() < access.getTo()) {
                        if (!clients.containsKey(type.toString())) {
                            clients.put(type.toString(), new HashSet<>());
                        }
                        if (clients.get(type.toString()).size() > 20) {
                            throw new QueueException("Занимается больше чем 20 клиентов");
                        } else {
                            if(User.getClass().getSimpleName().equals("Client")){
                                Field field1 = User.getClass().getDeclaredField("isVisited");
                                field1.setAccessible(true);
                                boolean vis = field1.getBoolean(User);
                                if(vis == false) {
                                    clients.get(type.toString()).add(User);
                                    FitnessLogger.PrintTofile(User, type);
                                    field1.setBoolean(User, true);
                                } else {
                                    throw new NoAccessException("Посетитель уже приходил");
                                }
                            } else{
                                clients.get(type.toString()).add(User);
                                FitnessLogger.PrintTofile(User, type);
                            }
                        }
                    } else {
                        throw new NoAccessException("Посетитель не может заниматься в данное время");
                    }
                } catch (NoSuchFieldException e) {
                    throw new NoAccessException("У посетителя нет доступа");
                }
            } else {
                throw new NoAccessException("У посетителя нет доступа");
            }
        } else if (FitnessServiceEnumeration.GROUP.equals(type)) {
            if (User.getClass().isAnnotationPresent(FitnessPlan.class)) {
                try {
                    Field field = User.getClass().getDeclaredField("group");
                    field.setAccessible(true);
                    Access access = (Access) field.get(User);
                    if (LocalTime.now().getHour() > access.getFrom() && LocalTime.now().getHour() < access.getTo()) {
                        if (!clients.containsKey(type.toString())) {
                            clients.put(type.toString(), new HashSet<>());
                        }
                        if (clients.get(type.toString()).size() > 20) {
                            throw new QueueException("Занимается больше чем 20 клиентов");
                        } else {
                            if(User.getClass().getSimpleName().equals("Client")){
                                Field field1 = User.getClass().getDeclaredField("isVisited");
                                field1.setAccessible(true);
                                boolean vis = field1.getBoolean(User);
                                if(vis == false) {
                                    clients.get(type.toString()).add(User);
                                    FitnessLogger.PrintTofile(User, type);
                                    field1.setBoolean(User, true);
                                } else {
                                    throw new NoAccessException("Посетитель уже приходил");
                                }
                            } else{
                                clients.get(type.toString()).add(User);
                                FitnessLogger.PrintTofile(User, type);
                            }
                        }
                    } else {
                        throw new NoAccessException("Посетитель не может заниматься в данное время");
                    }
                } catch (NoSuchFieldException e) {
                    throw new NoAccessException("У посетителя нет доступа");
                }
            } else {
                throw new NoAccessException("У посетителя нет доступа");
            }
        } else {
            System.out.println("Неверно введено название занятий");
        }
    }

    public void delete(User User) {
        HashSet<User> gym = clients.get("GYM");
        HashSet<User> pool = clients.get("POOL");
        HashSet<User> group = clients.get("GROUP");
        if (gym.contains(User)) {
            gym.remove(User);
            System.out.println("Посетитель удален из записей в тренаженый зал");
        } else {
            System.out.println("Посетитель не был записан в тренажерный зал");
        }
        if (pool.contains(User)) {
            pool.remove(User);
            System.out.println("Посетитель удален из записей в бассейн");
        } else {
            System.out.println("Посетитель не был записан в бассейн");
        }
        if (group.contains(User)) {
            group.remove(User);
            System.out.println("Посетитель удален из записей на групповые занятия");
        } else {
            System.out.println("Посетитель не был записан на групповые занятия");
        }
    }

    public void ClientsOutput() throws IOException {
        ArrayList<User> gym = new ArrayList<>(clients.get("GYM"));
        ArrayList<User> pool = new ArrayList<>(clients.get("POOL"));
        ArrayList<User> group = new ArrayList<>(clients.get("GROUP"));

        Comparator<User> comparator = new SurnameComparator().thenComparing(new NameComparator());
        gym.sort(comparator);
        pool.sort(comparator);
        group.sort(comparator);

        StringBuilder strb = new StringBuilder();
        for (User User : gym) {
            strb.delete(0,strb.length());
            strb.append(User.getSurname() + " " + User.getName() + " " + User.getClass().getSimpleName()
                    + " тренажерный зал");
            System.out.println(strb);
        }
        for (User User : pool) {
            strb.delete(0,strb.length());
            strb.append(User.getSurname() + " " + User.getName() + " " + User.getClass().getSimpleName()
                    + " тренажерный зал");
            System.out.println(strb);
        }
        for (User User : group) {
            strb.delete(0,strb.length());
            strb.append(User.getSurname() + " " + User.getName() + " " + User.getClass().getSimpleName()
                    + " тренажерный зал");
            System.out.println(strb);
        }
    }
}

class SurnameComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}

class NameComparator implements  Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}