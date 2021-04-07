package service;

import user.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User getUserById(int id);
}
