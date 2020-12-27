package services;

public interface AccountModificationEmailsService {

    void driverRegistrationConfirmationEmail(int DriverID);

    void passengerRegistrationConfirmationEmail(int passengerID);

    void driverAccountTerminationConfirmationEmail(int DriverID);

    void passengerAccountTerminationConfirmationEmail(int passengerID);
}
