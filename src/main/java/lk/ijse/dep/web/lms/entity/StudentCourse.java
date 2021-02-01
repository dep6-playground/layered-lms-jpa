package lk.ijse.dep.web.lms.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "student_course")
@Entity
public class StudentCourse implements Serializable {

    @EmbeddedId
    private StudentCoursePK studentCoursePK;

    @Column(name = "registered_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registeredDate;

    @Column(name = "register_fee")
    private double registerFee;

    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "actor_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "course_code",referencedColumnName = "code",insertable = false,updatable = false)
    private Course course;


    public StudentCourse(String studentId, String courseCode, Date registeredDate, double registerFee) {
        this.studentCoursePK = new StudentCoursePK(studentId,courseCode);
        this.registeredDate = registeredDate;
        this.registerFee = registerFee;
    }

    public StudentCourse(StudentCoursePK studentCoursePK, Date registeredDate, double registerFee) {
        this.studentCoursePK = studentCoursePK;
        this.registeredDate = registeredDate;
        this.registerFee = registerFee;
    }
}
