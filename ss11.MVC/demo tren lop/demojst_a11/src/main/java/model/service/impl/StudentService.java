package model.service.impl;

import model.bean.Student;
import model.repository.IStudentRepository;
import model.repository.impl.StudentRepository;
import model.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    // gọi repository
    IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAllStudent() {

        return studentRepository.getAllStudent();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {
        // cần kiểm tra dự liệu
        // +nếu mà ok => gọi repository để lưu.
        studentRepository.save(student);

    }

    @Override
    public void edit(Student student) {

    }

}
