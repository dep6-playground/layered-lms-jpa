package lk.ijse.dep.web.lms.business.custom.impl;

import lk.ijse.dep.web.lms.business.custom.CourseBO;
import lk.ijse.dep.web.lms.business.util.EntityDTOMapper;
import lk.ijse.dep.web.lms.dao.DAOFactory;
import lk.ijse.dep.web.lms.dao.DAOTypes;
import lk.ijse.dep.web.lms.dao.custom.CourseDAO;
import lk.ijse.dep.web.lms.dto.CourseDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    private final CourseDAO courseDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public CourseBOImpl() {
        courseDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    }


    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        courseDAO.setEntityManager(em);
    }

    @Override
    public void saveCourse(CourseDTO courseDTO) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.save(mapper.getCourse(courseDTO));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public void updateCourse(CourseDTO courseDTO) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.update(mapper.getCourse(courseDTO));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public void deleteCourse(String courseCode) throws Exception {
        try {
            em.getTransaction().begin();
            courseDAO.delete(courseCode);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public List<CourseDTO> findAllCourses() throws Exception {
        try {
            em.getTransaction().begin();
            List<CourseDTO> courseDTOs = mapper.getCourseDTOs(courseDAO.getAll());
            em.getTransaction().commit();
            return courseDTOs;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }    }
}
