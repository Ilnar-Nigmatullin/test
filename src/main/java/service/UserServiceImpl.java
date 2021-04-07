package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private Logger LOGGER;

    {
        try (FileInputStream inputStream = new FileInputStream("Путь до файла")) {
            LogManager.getLogManager().readConfiguration(inputStream);
            LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> allUsers() {
        LOGGER.log(Level.INFO, "Получаем список пользователей");
        return userDao.allUsers();
    }

    public void addUser(User user) {
        LOGGER.log(Level.INFO, "Добавляем нового пользователя");
        userDao.addUser(user);
        LOGGER.log(Level.INFO, "Добавили нового пользователя"); //и все в таком духе. Я пошел делать SQL задачи.
    }

    public void editUser(User user) {
        userDao.editUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
