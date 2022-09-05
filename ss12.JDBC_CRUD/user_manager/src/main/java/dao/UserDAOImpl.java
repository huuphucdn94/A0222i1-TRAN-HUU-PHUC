package dao;

import model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    //connect to database
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo_jdbc?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123123";

    private static final String INSERT_USERS_SQL = "INSERT INTO users(name,email,country) VALUES(?,?,?)";
    private static final String SELECT_USER_BY_ID = "SELECT id,name,email,country FROM users WHERE id=?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id=?";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET name=?,email=?,country=? WHERE id=?";
    private static final String SELECT_BY_COUNTRY = "SELECT * FROM users where country=?";
    private static final String ORDER_BY_NAME_ASC = "SELECT * FROM users ORDER BY name ASC";
    private static final String ORDER_BY_NAME_DESC = "SELECT * FROM users ORDER BY name DESC";
    private static final String SQL_INSERT = "INSERT INTO employee(name,salary,created_date) values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE employee SET salary=? WHERE name=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE employee(id serial primary key,name varchar(100) not" +
            " null, " +
            "salary numeric(15,1) not null, created_date timestamp)";
    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS employee";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;

        try (Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                user = new User(id, name, email, country);
                connection.close();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                userList.add(new User(id, name, email, country));
            }
            connection.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(DELETE_USERS_SQL)) {
            preparedStatement.setInt(1, id);

            rowDeleted = preparedStatement.executeUpdate() > 0;
            connection.close();
            /*return either (1) the row count for SLQ Data Manipulation Language (DML) statements or (2) 0 for SQL
             statements that return nothing;*/
            // Hence here we use boolean to return a value that allow us to know if the statement is executed probably;
            return rowDeleted;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
            connection.close();

            return rowUpdated;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public List<User> searchByCountry(String searchCountry) throws SQLException {
        List<User> userList = new ArrayList<>();

        try (Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(SELECT_BY_COUNTRY)) {
            preparedStatement.setString(1, searchCountry);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                User user = new User(id, name, email, country);
                userList.add(user);
            }
            connection.close();

        } catch (SQLException e) {
            e.getStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> sortByName(String asc_desc) throws SQLException {
        List<User> userList = new ArrayList<>();

        PreparedStatement preparedStatement;

        try (Connection connection = getConnection();) {
            if (asc_desc.equals("asc")) {
                preparedStatement =
                        connection.prepareStatement(ORDER_BY_NAME_ASC);

            } else if (asc_desc.equals("desc")) {
                preparedStatement =
                        connection.prepareStatement(ORDER_BY_NAME_DESC);
            } else {
                return null;
            }

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                User user = new User(id, name, email, country);
                userList.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        try (Connection connection = getConnection(); CallableStatement callableStatement =
                connection.prepareCall(query)) {
            callableStatement.setInt(1, id);

            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                user = new User(id, name, email, country);
            }
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return user;

    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String update = "{CALL insert_user(?,?,?)}";
        try (Connection connection = getConnection(); CallableStatement callableStatement =
                connection.prepareCall(update)) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());

            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permissions) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement assignmentPrepStm = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            //insert user
            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            int rowAffected = preparedStatement.executeUpdate();

            //get user_id
            rs = preparedStatement.getGeneratedKeys();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }

            //in case the insert operation successes, assign permission to user

            if (rowAffected == 1) {
                String query = "INSERT INTO user_permission(user_id,permission_id) values(?,?)";
                assignmentPrepStm = connection.prepareStatement(query);
                for (int permissionId : permissions) {
                    assignmentPrepStm.setInt(1, userId);
                    //code đúng
//                    assignmentPrepStm.setInt(2, permissionId);

                    //bài tập_ cập nhật mã nguồn để gây ra lỗi và test transaction
                    assignmentPrepStm.setInt(1, permissionId);

                    assignmentPrepStm.executeUpdate();
                }
                connection.commit();

            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            //rollback the transaction
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e2) {
                e2.getStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (preparedStatement != null) preparedStatement.close();
                    if (assignmentPrepStm != null) assignmentPrepStm.close();
                    if (connection != null) connection.close();
                } catch (SQLException e1) {
                    e1.getStackTrace();
                }
            }
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);) {
            statement.execute(SQL_DROP_TABLE);
            statement.execute(SQL_TABLE_CREATE);

            //Run list of insert commands
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Tuan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            //run caused error command to test transaction
            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    @Override
    public void insertUpdateUseTransaction() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
        ) {
            statement.execute(SQL_DROP_TABLE);
            statement.execute(SQL_TABLE_CREATE);

            connection.setAutoCommit(false);

            psInsert.setString(1, "An");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Linh");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();


            //error command to test transaction
            psUpdate.setBigDecimal(2,new BigDecimal(999.99));
            psUpdate.setString(2,"An");
            psUpdate.execute();

            connection.commit();

            //good practice to set autoCommit back to default
            connection.setAutoCommit(true);
        }catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public List<User> spSelectUsers() {
        List<User> userList = new ArrayList<>();
        String query = "{CALL select_all_users}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String country = rs.getString(4);

                User user = new User(id,name,email,country);
                userList.add(user);
            }
            connection.close();
        }catch (SQLException e) {
            e.getStackTrace();
        }

        return userList;
    }

    @Override
    public void spUpdateUser(User user) throws SQLException {
        String query = "{CALL update_user(?,?,?,?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1,user.getId());
            callableStatement.setString(2,user.getName());
            callableStatement.setString(3,user.getEmail());
            callableStatement.setString(4,user.getCountry());

            callableStatement.executeUpdate();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void spDeleteUser(int id) throws SQLException {
        String query = "CALL delete_user(?)";

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1,id);
            callableStatement.executeQuery();

            connection.close();
        }catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
