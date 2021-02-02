package lk.ijse.dep.web.lms.business.custom;

import lk.ijse.dep.web.lms.business.SuperBO;
import lk.ijse.dep.web.lms.dto.CourseDTO;
import lk.ijse.dep.web.lms.dto.RegisterDTO;
import lk.ijse.dep.web.lms.entity.RegisterPK;

import java.util.List;

public interface RegisterBO extends SuperBO {
    public void saveRegister(RegisterDTO registerDTO) throws Exception;

    public void updateRegister(RegisterDTO registerDTO) throws Exception;

    public void deleteRegister(RegisterPK registerPK) throws Exception;

    public List<RegisterDTO> findAllRegisters() throws Exception;

}
