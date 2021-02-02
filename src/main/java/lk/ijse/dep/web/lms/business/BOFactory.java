package lk.ijse.dep.web.lms.business;

import lk.ijse.dep.web.lms.business.custom.impl.CourseBOImpl;
import lk.ijse.dep.web.lms.business.custom.impl.RegisterBOImpl;
import lk.ijse.dep.web.lms.business.custom.impl.StudentBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return (boFactory != null) ? boFactory : (boFactory = new BOFactory());
    }

    public <T extends SuperBO> T getBO(BOTypes boType) {
        switch (boType) {
            case STUDENT:
                return (T) new StudentBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case REGISTER:
                return (T) new RegisterBOImpl();
            default:
                return null;
        }
    }
}
