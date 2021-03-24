package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class ReadFile {
    //reads all lines in a txt file and split each line up in strings and add the to a studentlist
    public List<Student> readAllStudents() {
        List<Student> students = new ArrayList<>();
        List<String> groups = new ArrayList<>();
        List<String> mails = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> lastnames = new ArrayList<>();
        //Could also use int = lineCounter = 0; and increment with ++, instead of lineCount.getAndIncrement()
        AtomicLong lineCount = new AtomicLong();
        try {
            //note: Lambda expressions: parameter -> expression or parameter -> { code block } for more complex code
            //note: Lambda expressions are similar to method, but do not need a name and can be used directly in method body

            /*This commented code does the same as the lambda expression below and reads from a txt file
            File file = new File("Grupper.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                groups.add(s.split(";")[0]);
                mails.add(s.split(";")[1]);
                names.add(s.split(";")[2]);
                lastnames.add(s.split(";")[3]);
                lineCount.getAndIncrement();
                }
            */
            Stream<String> stream = Files.lines(Paths.get("Grupper.txt")); //reads all lines from a file as a stream
            stream.forEach(s -> {
                //When the string is split at ; it is split into a array where [number] == string
                groups.add(s.split(";")[0]);
                mails.add(s.split(";")[1]);
                names.add(s.split(";")[2]);
                lastnames.add(s.split(";")[3]);
                lineCount.getAndIncrement();
            });
            //adds all students list
            for (int i = 0; i < lineCount.intValue(); i++) {
                Student student = new Student(groups.get(i), mails.get(i), names.get(i), lastnames.get(i));
                students.add(student);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return students;
    }

    //reads all lines in a txt file and split each line up in strings and add the to a studentlist
    //removed unnecessary code from the method above
    public List<Student> readAllStudentsRefined() {
        List<Student> students = new ArrayList<>();
        try {
            Stream<String> stream = Files.lines(Paths.get("Grupper.txt")); //reads all lines from a file as a stream
            stream.forEach(s -> {
                //When the string is split at ; it is split into a array where [number] == string
                Student student = new Student(s.split(";")[0], s.split(";")[1], s.split(";")[2], s.split(";")[3]);
                students.add(student);
            });
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return students;
    }
}
