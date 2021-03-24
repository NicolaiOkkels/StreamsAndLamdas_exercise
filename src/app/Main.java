package app;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    ReadFile readFile = new ReadFile();
        List<Student> studentList = readFile.readAllStudentsRefined();
        //Title: Exercise 1
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Exercise 1: Find your group for examinationproject and print using streams and lambda");
        IntStream.range(0,studentList.size()).filter(i->studentList.get(i).getGroup().equals("E")).mapToObj(i -> studentList.get(i)).forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------------------------------------------");
        //Title: Exercise 2
        System.out.println("Exercise 2: Sort the students of Dat20V2 after their first name and list them together with their group id");
        //Collections.sort(studentList); //sort type 1
        //studentList.sort(Comparator.comparing(Student::getName)); //sort type 2

        //Sort and print studentList
        studentList.stream()
                .sorted((std1,std2)-> std1.getName().compareTo(std2.getName()))
                .forEach(student -> System.out.println("Group " + student.getGroup() + ", Name: " + student.getName()));

        //Only print, so one of the sort method is needed to be run first
        /*
        IntStream.range(0, studentList.size())
                .mapToObj(i -> "Group "+studentList.get(i).getGroup() + ", Name: " + studentList.get(i).getName())
                .forEach(System.out::println);
         */
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }
}
