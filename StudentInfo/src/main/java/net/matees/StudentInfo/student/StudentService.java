package net.matees.StudentInfo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudent(Long id) {
        return studentRepository.getById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void createNewStudent(Student student) {
        //Check if email exists
        if(studentRepository.getStudentByEmail(student.getEmail()).isPresent()){
            //Email exists
            throw new IllegalArgumentException("The email provided is taken!");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {

            studentRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Id " + id + " does not exist!");
        }
    }

    @Transactional
    public void updateStudent(Long id,
                              String name,
                              String email,
                              Short grade ){
                             

        boolean studentExists = studentRepository.existsById(id);

        if (studentExists) {
            Student student = studentRepository.getById(id);

            if (name != null &&
                name.length() > 0 &&
                name != student.getName()) {

                student.setName(name);
            }

            if (email != null &&
                    email.length() > 0 &&
                    email != student.getEmail()) {
                if (!studentRepository.getStudentByEmail(email).isPresent()) {
                    student.setEmail(email);
                } else {
                    throw new IllegalStateException("Email provided already exists!");
                }
            }

            if (grade != null &&
                    grade >= 13) {
               student.setGrade(grade);
            }

        }else{
            throw new IllegalArgumentException("A student with the id: " + id + " does not exist!");
        }
    }


}


















