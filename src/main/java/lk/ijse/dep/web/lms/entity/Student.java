package lk.ijse.dep.web.lms.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@ToString(exclude = "student2Course")
@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "student")
public class Student implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String studentName;

    @Embedded
    private Address address;

    private String contact;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "student")
    private List<StudentCourse> student2Course;

    public Student(String id, String studentName, Address address, String contact, Date dob, Gender gender) {
        this.id = id;
        this.studentName = studentName;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
    }
}
