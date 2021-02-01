package lk.ijse.dep.web.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class Address {
    private String no;
    private String addressLine1;
    private String addressLine2;
    private String city;
}
