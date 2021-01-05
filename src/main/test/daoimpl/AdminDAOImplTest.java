package daoimpl;

import dao.AdminDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminDAOImplTest {

    @Test
    void deleteDriverAccount() {
        AdminDAO daoA = new AdminDAOImpl();
        daoA.deleteDriverAccount(4);
    }

    @Test
    void deletePassengerAccount() {
        AdminDAO daoA = new AdminDAOImpl();
        daoA.deletePassengerAccount(2);
    }

    @Test
    void deleteTripRequest() {
        AdminDAO daoA = new AdminDAOImpl();
        daoA.deleteTripRequest(3);
    }

    @Test
    void findByUsername() {
        AdminDAO daoA = new AdminDAOImpl();
        daoA.findByUsername("admin");
    }
}