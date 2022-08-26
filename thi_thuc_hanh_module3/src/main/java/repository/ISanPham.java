package repository;

import model.SanPham;

import java.sql.SQLException;
import java.util.List;

public interface ISanPham {
    void insertSanPham(SanPham sanPham) throws SQLException;
    public SanPham selectSanPham(int id);
    public List<SanPham> selectAllSanPham();
    public boolean deleteSanPham(int id)  throws SQLException;
    public boolean updateSanPham(SanPham sanPham) throws SQLException;
}
