package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //создание таблицы User
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();

        //Добавление 4 User(ов) в таблицу с данными на свой выбор.
        // После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )

        User user1 = new User("Ivan", "Ivanov", (byte) 20);
        User user2 = new User("Petr", "Petrov", (byte) 30);
        User user3 = new User("Olga", "Ivanova", (byte) 25);
        User user4 = new User("Sveta", "Petrova", (byte) 35);

        userServiceImpl.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userServiceImpl.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userServiceImpl.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userServiceImpl.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        //Получение всех User из базы и вывод в консоль
        System.out.println(userServiceImpl.getAllUsers().toString());

        //Очистка таблицы User(ов)
        userServiceImpl.cleanUsersTable();

        //Удаление таблицы
        userServiceImpl.dropUsersTable();
    }
}






