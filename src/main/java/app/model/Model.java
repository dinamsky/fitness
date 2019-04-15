package app.model;



import app.entities.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private List<User> model;
    private Connect connect;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
        connect = new Connect();
    }

    public void add(User user) {
        model.add(user);
    }




}