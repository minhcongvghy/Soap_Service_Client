package com.vsii;

import com.vsii.wsdl.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(StudentClient studentClient) {
        return args -> {
            System.out.println("--- Get Student by Id ---");
            GetStudentByIdResponse studentByIdResponse = studentClient.getStudentById(1);
            StudentInfo studentInfo = studentByIdResponse.getStudentInfo();
            System.out.println(studentInfo.getStudentId() + ", "+ studentInfo.getName()
                    + ", " + studentInfo.getCountry());

            System.out.println("--- Get all Students ---");
            GetAllStudentsResponse allStudentsResponse = studentClient.getAllStudents();
            allStudentsResponse.getStudentInfo().stream()
                    .forEach(e -> System.out.println(e.getStudentId() + ", "+ e.getName() + ", " + e.getCountry()));

            System.out.println("--- Add Student ---");
            String name = "tuan";
            String country = "Viet Nam";
            AddStudentResponse addStudentResponse = studentClient.addStudent(name, country);
            studentInfo = addStudentResponse.getStudentInfo();
            if (studentInfo != null) {
                System.out.println(studentInfo.getStudentId() + ", "+ studentInfo.getName()
                        + ", " + studentInfo.getCountry());
            }
            ServiceStatus serviceStatus = addStudentResponse.getServiceStatus();
            System.out.println("StatusCode: " + serviceStatus.getStatusCode() +
                    ", Message: " + serviceStatus.getMessage());

            System.out.println("--- Update Student ---");
            studentInfo = new StudentInfo();
            studentInfo.setStudentId(3);
            studentInfo.setName("Minh Cong");
            studentInfo.setCountry("Java");
            UpdateStudentResponse updateStudentResponse = studentClient.updateStudent(studentInfo);
            serviceStatus = updateStudentResponse.getServiceStatus();
            System.out.println("StatusCode: " + serviceStatus.getStatusCode() +
                    ", Message: " + serviceStatus.getMessage());

            System.out.println("--- Delete Student ---");
            long studentId = 3;
            DeleteStudentResponse deleteStudentResponse = studentClient.deleteStudent(studentId);
            serviceStatus = deleteStudentResponse.getServiceStatus();
            System.out.println("StatusCode: " + serviceStatus.getStatusCode() +
                    ", Message: " + serviceStatus.getMessage());
        };
    }

}
