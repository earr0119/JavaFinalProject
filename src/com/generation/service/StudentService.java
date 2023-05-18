package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public void showSummary() {
        System.out.println("Those are the Students");
        System.out.println("Registered Students:");

<<<<<<< HEAD
        for (String key : students.keySet()) {
            Student student = students.get(key);
            System.out.println(student);

=======
        for (Student student : students.values()) {
            for (Course course : student.getCourses()) { 
                System.out.println("Assigned Course: " + course.getName());
                System.out.println("Is Attending: " + student.isAttendingCourse(course.getCode()));
            }
            System.out.println();
>>>>>>> 0914116e57a6a2bf4dca3123c6443d7e5b6869e5
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }


}
