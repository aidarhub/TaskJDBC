package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl user1 = new UserDaoJDBCImpl();
        user1.createUsersTable();

        List<User> list = new ArrayList<>();
        list.add(new User("Igor", "Cherenov", (byte) 2));
        list.add(new User("Alex", "White", (byte) 3));
        list.add(new User("Jhon", "Lenom", (byte) 8));
        list.add(new User("Max", "Nova", (byte) 2));

        for (User user : list) {
            String name = user.getName();
            String lastName = user.getLastName();
            user1.saveUser(name, lastName, user.getAge());
            System.out.printf("User с именем – %s, добавлен в базу данных\n", name);
        }

        List<User> users = user1.getAllUsers();
        users.forEach(System.out::println);

        user1.cleanUsersTable();
        user1.dropUsersTable();
    }
}
