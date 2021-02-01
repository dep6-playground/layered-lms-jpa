package lk.ijse.dep.web.lms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class StudentCoursePK  implements Serializable {

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "course_code")
    private String courseCode;
}
