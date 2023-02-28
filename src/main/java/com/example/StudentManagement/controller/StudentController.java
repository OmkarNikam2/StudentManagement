package com.example.StudentManagement.controller;

import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

  // handler method to handle list students and return model and view

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "studentsHT";

    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model){

        //create student obj to hold student form data
        Student student=new Student();
        model.addAttribute("stud",student);
        return "create_student";


    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("students") Student student){

        studentService.saveStudent(student);
        return "redirect:/studentHT";
    }


}
