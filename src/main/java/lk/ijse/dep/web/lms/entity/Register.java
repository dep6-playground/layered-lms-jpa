package lk.ijse.dep.web.lms.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "student_course")
@Entity
public class Register implements SuperEntity {

    @EmbeddedId
    private RegisterPK registerPK;

    @Column(name = "registered_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registeredDate;

    @Column(name = "register_fee")
    private BigDecimal registerFee;

    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "actor_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name = "course_code",referencedColumnName = "code",insertable = false,updatable = false)
    private Course course;


    public Register(String studentId, String courseCode, Date registeredDate, BigDecimal registerFee) {
        this.registerPK = new RegisterPK(studentId,courseCode);
        this.registeredDate = registeredDate;
        this.registerFee = registerFee;
    }

    public Register(RegisterPK registerPK, Date registeredDate, BigDecimal registerFee) {
        this.registerPK = registerPK;
        this.registeredDate = registeredDate;
        this.registerFee = registerFee;
    }
}
