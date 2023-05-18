package com.generation.utils;

import com.generation.model.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PrinterHelper
{

    public static void showMainMenu(){
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Welcome to StudentGen         |" );
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Select 1 option:              |" );
        System.out.println( "| . 1 Register Student          |" );
        System.out.println( "| . 2 Find Student              |" );
        System.out.println( "| . 3 Enroll Student to Course  |" );
        System.out.println( "| . 4 Show Students Summary     |" );
        System.out.println( "| . 5 Show Courses Summary      |" );
        System.out.println( "| . 6 Exit                      |" );
        System.out.println( "|-------------------------------|" );
    }

    public static Student createStudentMenu( Scanner scanner )
        throws ParseException
    {
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 1 Register Student                |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter student name:                 |" );
        String name = scanner.next();
        System.out.println( "| Enter student ID:                   |" );
        String id = scanner.next();
        System.out.println( "| Enter student email:                |" );
        String email = scanner.next();
        System.out.println("| Enter student birth date(mm/dd/yyyy)|");
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        String input = scanner.next();

        Date birthDate = null;

        try {
            birthDate = formatter.parse(input);

            // Validar la fecha lógicamente
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(birthDate);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1; // El mes comienza desde 0
            int year = calendar.get(Calendar.YEAR);

            if (!isValidDate(day, month, year)) {
                System.out.println("Invalid date. Non-existent day, month or year.");
                System.exit(0); // Exit the program without registering
            }
        } catch (ParseException e) {
            System.out.println("Invalid date. Non-existent day, month or year.");
            System.exit(0); // Exit the program without registering
        }

        System.out.println("|-------------------------------------|");
        Student student = new Student(id, name, email, birthDate);
        System.out.println("Student Successfully Registered!");
        System.out.println(student);
        return student;

    }
    private static boolean isValidDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, month - 1); // El mes comienza desde 0
        calendar.set(Calendar.YEAR, year);

        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return (day >= 1 && day <= maxDay);
    }
}

