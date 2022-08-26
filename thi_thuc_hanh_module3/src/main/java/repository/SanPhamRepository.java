package repository;

import model.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository implements ISanPham{

    private String jdbcURL = "jdbc:mysql://localhost:3306/thi_thuc_hanh?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123123";
    private static final String INSERT_USERS_SQL = "INSERT INTO category" + "  (ten_san_pham, gia_san_pham, so_luong_san_pham, mau_sac_san_pham, mo_ta_san_pham, danh_muc) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,ten_san_pham,gia_san_pham,so_luong_san_pham,mau_sac_san_pham, mo_ta_san_pham,danh_muc from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from category";
    private static final String DELETE_USERS_SQL = "delete from category where id = ?;";
    private static final String UPDATE_USERS_SQL = "update category set ten_san_pham = ?,gia_san_pham= ?, so_luong_san_pham =?, mau_sac_san_pham =?, mo_ta_san_pham =?, danh_muc =?  where id = ?;";

    public SanPhamRepository() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertSanPham(SanPham sanPham) throws SQLException {
        System.out.println(INSERT_USERS_SQL);

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, sanPham.getTen());
            preparedStatement.setInt(2, sanPham.getGia());
            preparedStatement.setInt(3, sanPham.getSoLuong());
            preparedStatement.setString(4, sanPham.getMauSac());
            preparedStatement.setString(5, sanPham.getMoTa());
            preparedStatement.setString(6, sanPham.getDanhMuc());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SanPham selectSanPham(int id) {
        SanPham sanPham = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String ten = rs.getString("ten_san_pham");
                int gia = rs.getInt("gia_san_pham");
                int  soLuong = rs.getInt("so_luong_san_pham");
                String mauSac = rs.getString("mau_sac_san_pham");
                String moTa = rs.getString("mo_ta_san_pham");
                String danhMuc = rs.getString("danh_muc");
                sanPham = new SanPham(id, ten, gia, soLuong,mauSac,moTa,danhMuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    @Override
    public List<SanPham> selectAllSanPham() {

        List<SanPham> sanPhams = new ArrayList<>();

        try (Connection connection = getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id_san_pham");
                String ten = rs.getString("ten_san_pham");
                int gia = rs.getInt("gia_san_pham");
                int  soLuong = rs.getInt("so_luong_san_pham");
                String mauSac = rs.getString("mau_sac_san_pham");
                String moTa = rs.getString("mo_ta_san_pham");
                String danhMuc = rs.getString("danh_muc");
                sanPhams.add(new SanPham(id,ten,gia,soLuong,mauSac,moTa,danhMuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }

    @Override
    public boolean deleteSanPham(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateSanPham(SanPham sanPham) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, sanPham.getTen());
            statement.setInt(2, sanPham.getGia());
            statement.setInt(3, sanPham.getSoLuong());
            statement.setString(4, sanPham.getMauSac());
            statement.setString(5, sanPham.getMoTa());
            statement.setString(6, sanPham.getDanhMuc());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
