package proj.rest.se331.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import proj.rest.se331.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    StudentDTO getStudentDTO(Student student);
    List<StudentDTO> getStudentDTO(List<Student> students);
    AdvisorDTO getAdvisorDTO(Advisor advisor);
    List<AdvisorDTO> getAdvisorDTO(List<Advisor> advisors);
    CourseDTO getCourseDTO(Course course);
    List<CourseDTO> getCourseDTO(List<Course> courses);
    AnswerDTO getAnswerDTO(Answer answer);
    List<AnswerDTO> getAnswerDTO(List<Answer> answers);
    CommentDTO getCommentDTO(Comment comment);
    List<CommentDTO> getCommentDTO(List<Comment> comments);
    @Mapping(target = "roles", source = "user.roles")
    AdvisorAuthDto getAdvisorAuthDto(Advisor advisor);
    @Mapping(target = "roles", source = "user.roles")
    StudentAuthDto getStudentAuthDto(Student student);
}
