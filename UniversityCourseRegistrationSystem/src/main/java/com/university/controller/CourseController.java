package com.university.controller;

import com.university.model.Student;
import com.university.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class CourseController {

    @Autowired
    CourseRepository courseRepo;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseRepo.getAllCourses());
        return "courses";
    }

    @PostMapping("/register/{id}")
    public String registerCourse(@PathVariable("id") int courseId, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        courseRepo.register(student.getStudentId(), courseId);
        return "success";
    }
}
