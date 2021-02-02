package lk.ijse.dep.web.lms.business.util;

import lk.ijse.dep.web.lms.dto.CourseDTO;
import lk.ijse.dep.web.lms.dto.RegisterDTO;
import lk.ijse.dep.web.lms.dto.StudentDTO;
import lk.ijse.dep.web.lms.entity.Course;
import lk.ijse.dep.web.lms.entity.Register;
import lk.ijse.dep.web.lms.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    @Mapping(target = "student2Course",ignore = true)
    Student getStudent(StudentDTO dto);

    StudentDTO getStudentDTO(Student student);

    List<StudentDTO> getStudentDTOs(List<Student> students);

    @Mapping(target = "course2Student",ignore = true)
    Course getCourse(CourseDTO dto);

    CourseDTO getCourseDTO(Course course);

    List<CourseDTO> getCourseDTOs(List<Course> customers);

    @Mapping(target = "student",ignore = true)
    @Mapping(target = "course",ignore = true)
    Register getRegister(RegisterDTO dto);

    RegisterDTO getRegisterDTO(Register register);

    List<RegisterDTO> getRegisterDTOs(List<Register> registers);

}
