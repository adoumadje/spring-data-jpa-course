package com.caleb.spring.data.jpa.tutorial.repository;

import com.caleb.spring.data.jpa.tutorial.entity.Guardian;
import com.caleb.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("adoumadjecaleb@gmail.com")
                .firstName("Caleb")
                .lastName("Adoumadje")
                //.guardianName("David")
                //.guardianEmail("d.madjingaral@gmail.com")
                //.guardianMobile("+485466084498")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("d.madjingaral@gmail.com")
                .name("David")
                .mobile("+48514268145")
                .build();

        Student student = Student.builder()
                .firstName("Caleb")
                .lastName("Adoumadje")
                .emailId("adoumadje11caleb@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = "+studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Caleb");

        System.out.println("students = "+students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Ca");

        System.out.println("students = "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("David");

        System.out.println("students = "+students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress(
                "adoumadjecaleb@gmail.com"
            );

        System.out.println("student = "+student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress(
                "adoumadje11caleb@gmail.com"
            );
        System.out.println("firstName = "+firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative(
                "adoumadjecaleb@gmail.com"
            );
        System.out.println("student = "+student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam(
                "adoumadjecaleb@gmail.com"
        );
        System.out.println("student = "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "Calebinho",
                "adoumadjecaleb@gmail.com"
        );
    }
}