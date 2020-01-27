package com.ben.Dao;

import com.ben.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    @Autowired
    private static Map<Integer, Student> students;

    private int studentCount = 0;

    static {
        students = new HashMap<Integer, Student>() {
            {
//                put(1, new Student(1, "Ben", "Computer Science"));
//                put(2, new Student(2, "Kate", "Mathematics"));
//                put(3, new Student(3, "Jon", "Chemical Engineering"));
            }
        };
    }

    public int getStudentCount()
    {
        return this.studentCount;
    }

    public void incrStudentCount()
    {
        this.studentCount ++;
    }

    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    public Student getStudentById(int id)
    {
        return this.students.get(id);
    }

    public void updateStudent(Student student)
    {
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public Student insertStudent(Student student) {
        this.incrStudentCount();
        student.setId(this.getStudentCount());
        this.students.put(student.getId(), student);
        return this.students.get(this.getStudentCount());
    }
}
