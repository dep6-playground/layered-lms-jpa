package lk.ijse.dep.web.lms.business.custom.impl;

import lk.ijse.dep.web.lms.business.custom.StudentBO;
import lk.ijse.dep.web.lms.business.util.EntityDTOMapper;
import lk.ijse.dep.web.lms.dao.DAOFactory;
import lk.ijse.dep.web.lms.dao.DAOTypes;
import lk.ijse.dep.web.lms.dao.custom.StudentDAO;
import lk.ijse.dep.web.lms.dto.StudentDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public StudentBOImpl() {
        studentDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        studentDAO.setEntityManager(em);

    }

    @Override
    public void saveStudent(StudentDTO studentDTO) throws Exception {
        try {
            em.getTransaction().begin();
            studentDAO.save(mapper.getStudent(studentDTO));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public void updateStudent(StudentDTO studentDTO) throws Exception {
        try {
            em.getTransaction().begin();
            studentDAO.update(mapper.getStudent(studentDTO));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public void deleteStudent(String studentId) throws Exception {
        try {
            em.getTransaction().begin();
            studentDAO.delete(studentId);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public List<StudentDTO> findAllStudents() throws Exception {
        try {
            em.getTransaction().begin();
            List<StudentDTO> studentDTOs = mapper.getStudentDTOs(studentDAO.getAll());
            em.getTransaction().commit();
            return studentDTOs;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }
}
