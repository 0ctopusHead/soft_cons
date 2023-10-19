package proj.rest.se331.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.entity.Course;
import proj.rest.se331.entity.Student;
import proj.rest.se331.repository.AdvisorRepository;
import proj.rest.se331.repository.CourseRepository;
import proj.rest.se331.repository.StudentRepository;
import proj.rest.se331.security.user.Role;
import proj.rest.se331.security.user.User;
import proj.rest.se331.security.user.UserRepository;

import java.util.List;

import static proj.rest.se331.security.user.Role.*;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;
    final CourseRepository courseRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Student student;
        Advisor advisor1,advisor2,advisor3;
        Course course1,course2,course3,course4;
        addUser();
        advisor1 = advisorRepository.save(Advisor.builder()
                .name("Galvin")
                .surname("Sullivan")
                .academicPosition("Professor")
                .images(List.of("https://firebasestorage.googleapis.com/v0/b/se331-final-project.appspot.com/o/image231.jpg?alt=media&token=e9289abc-e242-4919-b377-969a4964c8db&_gl=1*1fm0yqw*_ga*MTA3MDc2MTc5OC4xNjg5NTczNzcw*_ga_CW55HF8NVT*MTY5NzY0MzcyOS4zNy4xLjE2OTc2NDM5NzAuNDkuMC4w"))
                .department("SE")
                .build());
        advisor2 = advisorRepository.save(Advisor.builder()
                .name("Noble")
                .surname("Dickerson")
                .academicPosition("Assistant Professor")
                .images(List.of("https://firebasestorage.googleapis.com/v0/b/se331-final-project.appspot.com/o/image465.jpg?alt=media&token=0274145a-6c15-4233-ae9a-15e0a2912418&_gl=1*1f01nq4*_ga*MTA3MDc2MTc5OC4xNjg5NTczNzcw*_ga_CW55HF8NVT*MTY5NzY0MzcyOS4zNy4xLjE2OTc2NDM5OTMuMjYuMC4w"))
                .department("SE")
                .build());

        advisor3 = advisorRepository.save(Advisor.builder()
                .name("Lynn")
                .surname("Whitehead")
                .academicPosition("Instructor")
                .images(List.of("https://firebasestorage.googleapis.com/v0/b/se331-final-project.appspot.com/o/image123.jpg?alt=media&token=6100ae6e-66da-4a12-81f4-782b5a0a5864&_gl=1*1cjmvbx*_ga*MTA3MDc2MTc5OC4xNjg5NTczNzcw*_ga_CW55HF8NVT*MTY5NzY0MzcyOS4zNy4xLjE2OTc2NDQwMTAuOS4wLjA."))
                .department("SE")
                .build());

        course1 = courseRepository.save(Course.builder()
                .name("Basic AI")
                .courseID("953411")
                .description("AI for software development")
                .build());
        course2 = courseRepository.save(Course.builder()
                .name("Development Operation")
                .courseID("953323")
                .description("Basic deployment in software development")
                .build());
        course3 = courseRepository.save(Course.builder()
                .name("UXUI")
                .courseID("953351")
                .description("How to design UXUI")
                .build());
        course4 = courseRepository.save(Course.builder()
                .name("Database and Database System Design")
                .courseID("953212")
                .description("Introduction to the database design")
                .build());

        student = studentRepository.save(Student.builder()
                .name("Yanwarut")
                .surname("Suksawat")
                .studentID("642115011")
                .images(List.of("https://firebasestorage.googleapis.com/v0/b/se331-final-project.appspot.com/o/image01.png?alt=media&token=12ef7857-3717-4f5e-bc7c-75ce5066222f&_gl=1*u6jf87*_ga*MTA3MDc2MTc5OC4xNjg5NTczNzcw*_ga_CW55HF8NVT*MTY5NzYyMjMxNS4zNS4xLjE2OTc2MjM2MzQuNjAuMC4w"))
                .department("SE")
                .build());
        student.setAdvisor(advisor1);
        student.getCourses().add(course1);
        student.getCourses().add(course2);
        advisor1.getAdvisees().add(student);
        course1.getEnrolledStudents().add(student);
        course2.getEnrolledStudents().add(student);

        student = studentRepository.save(Student.builder()
                .name("Yada")
                .surname("La")
                .studentID("642115012")
                .images(List.of("https://firebasestorage.googleapis.com/v0/b/se331-final-project.appspot.com/o/image02.png?alt=media&token=81131862-f4cc-4b34-85eb-eef17b819b38&_gl=1*1dauoxj*_ga*MTA3MDc2MTc5OC4xNjg5NTczNzcw*_ga_CW55HF8NVT*MTY5NzYyMjMxNS4zNS4xLjE2OTc2MjM2NzAuMjQuMC4w"))
                .department("SE")
                .build());
        student.setAdvisor(advisor1);
        student.getCourses().add(course2);
        student.getCourses().add(course3);
        advisor1.getAdvisees().add(student);
        course2.getEnrolledStudents().add(student);
        course3.getEnrolledStudents().add(student);

        student = studentRepository.save(Student.builder()
                .name("Nichakamol")
                .surname("Sangsom")
                .studentID("642115015")
                .images(List.of("https://firebasestorage.googleapis.com/v0/b/se331-final-project.appspot.com/o/image03.png?alt=media&token=3b83491a-1186-4829-8ba9-8154676865b2&_gl=1*17d8kih*_ga*MTA3MDc2MTc5OC4xNjg5NTczNzcw*_ga_CW55HF8NVT*MTY5NzYyMjMxNS4zNS4xLjE2OTc2MjM2ODUuOS4wLjA."))
                .department("SE")
                .build());
        student.setAdvisor(advisor2);
        student.getCourses().add(course4);
        student.getCourses().add(course1);
        advisor2.getAdvisees().add(student);
        course4.getEnrolledStudents().add(student);
        course1.getEnrolledStudents().add(student);

        student = studentRepository.save(Student.builder()
                .name("Supanat")
                .surname("IceLing")
                .studentID("642115041")
                .images(List.of("https://firebasestorage.googleapis.com/v0/b/se331-final-project.appspot.com/o/image04.png?alt=media&token=a34c4cc7-c024-4513-9a75-f0e98fb43bcf&_gl=1*1ct5mxr*_ga*MTA3MDc2MTc5OC4xNjg5NTczNzcw*_ga_CW55HF8NVT*MTY5NzYyMjMxNS4zNS4xLjE2OTc2MjI2ODguNjAuMC4w"))
                .department("SE")
                .build());
        student.setUser(user3);
        student.setAdvisor(advisor2);
        student.getCourses().add(course3);
        student.getCourses().add(course4);
        advisor2.getAdvisees().add(student);
        course3.getEnrolledStudents().add(student);
        course4.getEnrolledStudents().add(student);

        student = studentRepository.save(Student.builder()
                .name("Kittipat")
                .surname("Sodiumhelium")
                .studentID("642115005")
                .images(List.of("https://firebasestorage.googleapis.com/v0/b/se331-final-project.appspot.com/o/image05.png?alt=media&token=b409b5bf-736e-4c1f-ac95-8e36dfafde7e&_gl=1*1tcmzm*_ga*MTA3MDc2MTc5OC4xNjg5NTczNzcw*_ga_CW55HF8NVT*MTY5NzYyMjMxNS4zNS4xLjE2OTc2MjM3MTYuNjAuMC4w"))
                .department("SE")
                .build());
        student.setAdvisor(advisor3);
        student.getCourses().add(course1);
        student.getCourses().add(course4);
        advisor3.getAdvisees().add(student);
        course1.getEnrolledStudents().add(student);
        course4.getEnrolledStudents().add(student);

        user1.setAdvisor(advisor1);
        user2.setAdvisor(advisor2);
        advisor2.setUser(user2);
        advisor1.setUser(user1);
    }
    User user1,user2,user3;
    private void addUser(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .username("admin")
                .password(encoder.encode("admin"))
                .roles(List.of(ROLE_ADMIN))
                .build();
        user2 = User.builder()
                .firstname("advisor1")
                .lastname("advisor1")
                .email("advisor1@advisor.com")
                .username("advisor1")
                .password(encoder.encode("advisor1"))
                .roles(List.of(ROLE_ADVISOR))
                .build();
        user3 = User.builder()
                .firstname("student1")
                .lastname("student1")
                .email("student1@student.com")
                .username("student1")
                .password(encoder.encode("student1"))
                .roles(List.of(ROLE_STUDENT))
                .build();
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
