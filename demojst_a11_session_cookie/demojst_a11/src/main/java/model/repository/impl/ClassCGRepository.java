package model.repository.impl;

import model.bean.ClassCG;
import model.bean.Student;
import model.repository.BaseRepository;
import model.repository.IClassCGRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassCGRepository implements IClassCGRepository {

    @Override
    public List<ClassCG> findAll() {
        List<ClassCG> classCGList = new ArrayList<>();

        // kết nội dB=> lấy list
        Connection connection = BaseRepository.getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from class;");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id"); // colummLable : tên  thuocj tính của bảng
                String name  = resultSet.getString("name");
                int classTypeId = resultSet.getInt("class_type_id");
                ClassCG classCG = new ClassCG(id,name,classTypeId);
                classCGList.add(classCG);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classCGList;
    }
}
