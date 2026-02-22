package vn.edu.hcmut.cse.adsoftweng.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAll(){
        return repository.findAll();
    }

    public List<Student> searchByName(String name){
        return repository.findAllByName(name);
    }

    public Student getById(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void save(Student student){
        repository.save(student);
    }
}
