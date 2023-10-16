package proj.rest.se331.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.entity.Course;
import proj.rest.se331.entity.Student;
import proj.rest.se331.repository.AdvisorRepository;
import proj.rest.se331.repository.CourseRepository;
import proj.rest.se331.repository.StudentRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;
    final CourseRepository courseRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Student student;
        Advisor advisor1,advisor2,advisor3;
        Course course1,course2,course3,course4;
        advisor1 = advisorRepository.save(Advisor.builder()
                .name("Galvin")
                .surname("Sullivan")
                .academicPosition("Professor")
                .department("SE")
                .build());
        advisor2 = advisorRepository.save(Advisor.builder()
                .name("Noble")
                .surname("Dickerson")
                .academicPosition("Assistant Professor")
                .department("SE")
                .build());
        advisor3 = advisorRepository.save(Advisor.builder()
                .name("Lynn")
                .surname("Whitehead")
                .academicPosition("Instructor")
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
                .department("SE")
                .build());
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
                .department("SE")
                .build());
        student.setAdvisor(advisor3);
        student.getCourses().add(course1);
        student.getCourses().add(course4);
        advisor3.getAdvisees().add(student);
        course1.getEnrolledStudents().add(student);
        course4.getEnrolledStudents().add(student);
    }
}
