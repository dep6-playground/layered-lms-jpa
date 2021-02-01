package lk.ijse.dep.web.lms.util;

import lk.ijse.dep.web.lms.dto.CourseDTO;
import lk.ijse.dep.web.lms.dto.StudentDTO;
import lk.ijse.dep.web.lms.entity.Course;
import lk.ijse.dep.web.lms.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    @Mapping(target = "student2Course",ignore = true)
    Student getStudent(StudentDTO dto);

    StudentDTO getStudentDTO(Student student);

    @Mapping(target = "course2Student",ignore = true)
    Course getCourse(CourseDTO dto);

    CourseDTO getCourseDTO(Course course);
}
