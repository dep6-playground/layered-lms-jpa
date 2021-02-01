package lk.ijse.dep.web.lms.dto;

import lk.ijse.dep.web.lms.entity.Address;
import lk.ijse.dep.web.lms.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class StudentDTO implements Serializable {
    private String id;
    private String studentName;
    private Address address;
    private String contact;
    private Date dob;
    private Gender gender;
}
