package lk.ijse.dep.web.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;


@Data @AllArgsConstructor @NoArgsConstructor
public class RegisterDTO implements Serializable {

    private String studentId;
    private String courseCode;
    private BigDecimal registerFee;
    private Date registeredDate;
}
