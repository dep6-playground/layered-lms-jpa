package lk.ijse.dep.web.lms.dto;

import lk.ijse.dep.web.lms.entity.Audience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class CourseDTO implements Serializable {
    private String code;
    private String description;
    private String duration;
    private Audience audience;

}
