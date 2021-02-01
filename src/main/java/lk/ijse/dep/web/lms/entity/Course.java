package lk.ijse.dep.web.lms.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString(exclude = "course2Student")
@Entity
@Table(name = "course")
@AllArgsConstructor @NoArgsConstructor @Data
public class Course implements Serializable {
    @Id
    private String code;

    private String description;

    private String duration;

    @Enumerated(EnumType.ORDINAL)
    private Audience audience;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "course")
    private List<StudentCourse> course2Student;

    public Course(String code, String description, String duration, Audience audience) {
        this.code = code;
        this.description = description;
        this.duration = duration;
        this.audience = audience;
    }
}
