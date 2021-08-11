package net.matees.StudentInfo.teacher;

import net.matees.StudentInfo.classmodel.ClassModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long id;
    private String name;
    @OneToMany
    private List<ClassModel> activeTeachingClasses;

    public Teacher() {
    }

    public Teacher(String name, List<ClassModel> activeTeachingClasses) {
        this.name = name;
        this.activeTeachingClasses = activeTeachingClasses;
    }

    public Teacher(Long id, String name, List<ClassModel> activeTeachingClasses) {
        this.id = id;
        this.name = name;
        this.activeTeachingClasses = activeTeachingClasses;
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

    public List<ClassModel> getActiveTeachingClasses() {
        return activeTeachingClasses;
    }

    public void setActiveTeachingClasses(List<ClassModel> activeTeachingClasses) {
        this.activeTeachingClasses = activeTeachingClasses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activeTeachingClasses=" + activeTeachingClasses +
                '}';
    }
}
