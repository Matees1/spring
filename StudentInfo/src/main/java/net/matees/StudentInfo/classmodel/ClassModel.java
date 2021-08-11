package net.matees.StudentInfo.classmodel;

import net.matees.StudentInfo.teacher.Teacher;

import javax.persistence.*;

@Entity
@Table
public class ClassModel {

    @Id
    @SequenceGenerator(name="roomNumber_sequence",sequenceName = "roomNumber_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomNumber_sequence")
    private Long roomNumber;
    private String name;
    @OneToOne
    private Teacher teacher;

    public ClassModel() {
    }

    public ClassModel(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public ClassModel(Long roomNumber, String name, Teacher teacher) {
        this.roomNumber = roomNumber;
        this.name = name;
        this.teacher = teacher;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "ClassModel{" +
                "roomNumber=" + roomNumber +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
