package model.service.impl;

import model.bean.ClassCG;
import model.repository.IClassCGRepository;
import model.repository.impl.ClassCGRepository;
import model.service.IClassCGService;

import java.util.List;

public class ClassCGService implements IClassCGService {
    private IClassCGRepository classCGRepository = new ClassCGRepository();
    @Override
    public List<ClassCG> findAll() {
        return classCGRepository.findAll();
    }
}
