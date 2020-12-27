package services;

import dao.AccountModificationEmailsDAO;

public class AccountModificationEmailsServiceImpl implements AccountModificationEmailsService {

    private final dao.AccountModificationEmailsDAO AccountModificationEmailsDAO;

    public AccountModificationEmailsServiceImpl(dao.AccountModificationEmailsDAO accountModificationEmailsDAO) {
        AccountModificationEmailsDAO = accountModificationEmailsDAO;
    }

    @Override
    public void driverRegistrationConfirmationEmail(int DriverID) {

        AccountModificationEmailsDAO.driverRegistrationConfirmationEmail(DriverID);
    }

    @Override
    public void passengerRegistrationConfirmationEmail(int passengerID) {

        AccountModificationEmailsDAO.passengerRegistrationConfirmationEmail(passengerID);
    }

    @Override
    public void driverAccountTerminationConfirmationEmail(int DriverID) {

        AccountModificationEmailsDAO.driverAccountTerminationConfirmationEmail(DriverID);
    }

    @Override
    public void passengerAccountTerminationConfirmationEmail(int passengerID) {

        AccountModificationEmailsDAO.passengerAccountTerminationConfirmationEmail(passengerID);

    }
}
