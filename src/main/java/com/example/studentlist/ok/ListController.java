package com.example.studentlist.ok;

import com.example.studentlist.Repository.StudentRepository;
import com.example.studentlist.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class ListController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/")
    public String greeting(Model model) {
        List<Students> students = studentRepository.findAll();
        model.addAttribute("stu", students);
        return "list";
    }


    @GetMapping("/adduser")
    public String addPage(Model model) {
        List<Students> students = studentRepository.findAll();
        model.addAttribute("stu", students);
        return "adduser";
    }

    @PostMapping(value = "/adduser")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("surname") String surname,
                          @RequestParam("exam") int exam,
                          @RequestParam("mark") String mark) {
        Students student = new Students();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        student.setMark(mark);

        studentRepository.save(student);
        return "redirect:/";
    }

    @PostMapping(value = "/deletestudent")
    public String deleteCar(@RequestParam(name = "id") Long id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }



}