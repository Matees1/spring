package net.matees.StudentInfo.student;

import net.matees.StudentInfo.classmodel.ClassModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(name="student_sequence",sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Short grade;
    @OneToMany
    private List<ClassModel> classes;

    public Student() {
    }

    public Student(String name, Integer age, String email, Short grade, List<ClassModel> classes) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.grade = grade;
        this.classes = classes;
    }

    public Student(Long id, String name, Integer age, String email, Short grade, List<ClassModel> classes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.grade = grade;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public List<ClassModel> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassModel> classes) {
        this.classes = classes;
    }
    
    public void addClass(ClassModel classModel){
        this.classes.add(classModel);
    }
    
    public void addClasses(List<ClassModel> classes){
        this.classes.addAll(classes);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", grade=" + grade +
                ", classes=" + classes +
                '}';
    }
}
