package lk.ijse.dep.web.lms.business.custom;

import lk.ijse.dep.web.lms.business.SuperBO;
import lk.ijse.dep.web.lms.dto.CourseDTO;

import java.util.List;

public interface CourseBO extends SuperBO {

    public void saveCourse(CourseDTO courseDTO) throws Exception;

    public void updateCourse(CourseDTO courseDTO) throws Exception;

    public void deleteCourse(String courseCode) throws Exception;

    public List<CourseDTO> findAllCourses() throws Exception;
}
