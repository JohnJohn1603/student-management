package vn.edu.hcmut.cse.adsoftweng.lab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentWebController {
    @Autowired
    private StudentService service;
    @GetMapping
    public String getAllStudents(@RequestParam(required = false) String keyword, Model model) {
        List<Student> students;
        if(keyword != null && !keyword.isEmpty()) {
            students = service.searchByName(keyword);
        }else{
            students = service.getAll();
        }
        model.addAttribute("dsSinhVien", students);
        return "students";
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable Long id, Model model){
        Student student = service.getById(id);
        model.addAttribute("sinhVien", student);
        return "student";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model){
        service.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("sinhVien", new Student());
        return "student-form";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Student student = service.getById(id);
        model.addAttribute("sinhVien", student);
        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("sinhVien") Student student){
        service.save(student);
        return "redirect:/students";
    }
}
