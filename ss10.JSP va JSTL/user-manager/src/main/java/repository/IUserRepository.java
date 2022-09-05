package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    public void insertUser(User user);
    public User selectUser(int user);
    public List<User> selectAllUser();
    public boolean deleteUser(int id);
    public boolean updateUser(User user);
}
