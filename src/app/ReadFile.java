package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class ReadFile {
    public List<Student> readAllStudents() {
        List<Student> students = new ArrayList<>();
        List<String> groups = new ArrayList<>();
        List<String> mails = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> lastnames = new ArrayList<>();
        //Could also use int = lineCounter = 0; and increment with ++, instead of lineCount.getAndIncrement()
        AtomicLong lineCount = new AtomicLong();
        try {
            Stream<String> stream = Files.lines(Paths.get("Grupper.txt"));
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
                Student student = new Student(groups.get(i),mails.get(i),names.get(i),lastnames.get(i));
                students.add(student);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return students;
    }
}
