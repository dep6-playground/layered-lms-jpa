package lk.ijse.dep.web.lms.business.custom.impl;

import lk.ijse.dep.web.lms.business.custom.RegisterBO;
import lk.ijse.dep.web.lms.business.util.EntityDTOMapper;
import lk.ijse.dep.web.lms.dao.DAOFactory;
import lk.ijse.dep.web.lms.dao.DAOTypes;
import lk.ijse.dep.web.lms.dao.custom.RegisterDAO;
import lk.ijse.dep.web.lms.dto.RegisterDTO;
import lk.ijse.dep.web.lms.entity.RegisterPK;

import javax.persistence.EntityManager;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {
    private final RegisterDAO registerDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public RegisterBOImpl() {

        registerDAO = DAOFactory.getInstance().getDAO(DAOTypes.REGISTER);
    }


    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        registerDAO.setEntityManager(em);
    }

    @Override
    public void saveRegister(RegisterDTO registerDTO) throws Exception {
        try {
            em.getTransaction().begin();
            registerDAO.save(mapper.getRegister(registerDTO));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public void updateRegister(RegisterDTO registerDTO) throws Exception {
        try {
            em.getTransaction().begin();
            registerDAO.update(mapper.getRegister(registerDTO));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public void deleteRegister(RegisterPK registerPK) throws Exception {
        try {
            em.getTransaction().begin();
            registerDAO.delete(registerPK);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public List<RegisterDTO> findAllRegisters() throws Exception {
        try {
            em.getTransaction().begin();
            List<RegisterDTO> registerDTOs = mapper.getRegisterDTOs(registerDAO.getAll());
            em.getTransaction().commit();
            return registerDTOs;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }    }
}
