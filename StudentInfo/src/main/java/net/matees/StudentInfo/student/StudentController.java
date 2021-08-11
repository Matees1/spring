package net.matees.StudentInfo.student;

import net.matees.StudentInfo.classmodel.ClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Get all students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Get a specific student using an id
    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long id) {
        return studentService.getStudent(id);
    }

    //Create a student
    @PostMapping(path = "create")
    public void createNewStudent(@RequestBody Student student){
        studentService.createNewStudent(student);
    }

    //Add a class to a student
//    @PostMapping(path = "{studentId}/classes")
//    public void addClassToStudent(@PathVariable("studentId") Long id, Long classId){
//
//    }

    //Delete a student
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    //Update either name, email or grade
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId")      Long             id,
                              @RequestParam(required = false) String           name,
                              @RequestParam(required = false) String           email,
                              @RequestParam(required = false) Short            grade){

        studentService.updateStudent(id, name, email, grade);
    }

}












