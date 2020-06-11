package com.example.demo.webRes;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResources {

//    @GetMapping("/students")
//    public String hello (){
//        return "Hello world";
//    }

    @RequestMapping(value = {"/students"}, method = RequestMethod.GET)
    public ResponseEntity getAll(){
        Student student = new Student(1, "John DOE", 2);
        Student student1 = new Student(2, "Billie Elish", 4);
        Student student2 = new Student(3, "Jonny", 3);
        Student student3 = new Student(4, "KHABIB", 1);

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student3);
        students.add(student2);

        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable long id ){
        Student student = new Student(1, "John DOE", 2);
        Student student1 = new Student(2, "Billie Elish", 4);
        Student student2 = new Student(3, "Jonny", 3);
        Student student3 = new Student(4, "KHABIB", 1);

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student3);
        students.add(student2);
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id){
                count=i;
            }
        }

        return ResponseEntity.ok(students.get(count));
    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable long id){
        Student student = new Student(1, "John DOE", 2);

        return ResponseEntity.ok(student+"Malumot o'cirildi");
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable long id,@RequestBody Student studentnew){
        Student student = new Student(1, "John DOE", 2);
        student.setFullname(studentnew.getFullname());
        student.setCourse(studentnew.getCourse());
        return ResponseEntity.ok(student);
    }


}
