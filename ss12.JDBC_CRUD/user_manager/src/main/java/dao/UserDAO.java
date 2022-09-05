package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> selectAllUser();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> searchByCountry(String searchCountry) throws SQLException;
    List<User> sortByName(String desc_asc) throws SQLException;
    User getUserById(int id);
    void insertUserStore(User user) throws SQLException;
    void addUserTransaction(User user,int[] permission);
    void insertUpdateWithoutTransaction();
    void insertUpdateUseTransaction();
    List<User> spSelectUsers();
    void spUpdateUser(User user) throws SQLException;
    void spDeleteUser(int id) throws SQLException;
}
