package app;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String group;
    private String mail;
    private String name;
    private String lastName;

    public Student(String group, String mail, String name, String lastName) {
        this.group = group;
        this.mail = mail;
        this.name = name;
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
