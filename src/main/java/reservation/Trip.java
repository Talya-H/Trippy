package reservation;

import org.springframework.format.annotation.DateTimeFormat;
import users.Driver;
import users.Passenger;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

//join with passengerID and driver ID
@Entity
@Table(name = "Trippy_Trip")
public class Trip {

    @Id
    @Column(name = "Trip_ID")
    @GeneratedValue
    private int tripID;

    @Column(name = "Pickup_location")
    private String pickup;

    @Column(name = "Drop_Location")
    private String drop;

    //    needs adjusting maybe time method?
    @Column(name = "Pickup_Time")
//    @Temporal(TemporalType.TIME)
    private String pickupTime;

    //    needs adjusting maybe time method?
    @Column(name = "Pickup_Date")
//    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String pickupDate;


//    @ForeignKey(name = "FK_passengerID")

    @JoinColumn(name = "Passenger_ID")
    private int passengerID;

    //many to one?


    //    @ForeignKey(name = "FK_driverID")
    @JoinColumn(name = "Driver_ID")
    private int driverID;


    public Trip() {
    }

    public Trip(String pickup, String drop, String pickupTime, String pickupDate) {
        this.pickup = pickup;
        this.drop = drop;
        this.pickupTime = pickupTime;
        this.pickupDate = pickupDate;
    }


    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String time) {
        this.pickupTime = time;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;

    }

    public int getpassengerID() {
        return passengerID;
    }

    public void setpassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripID=" + tripID +
                ", pickup='" + pickup + '\'' +
                ", drop='" + drop + '\'' +
                ", pickupTime='" + pickupTime + '\'' +
                ", pickupDate='" + pickupDate + '\'' +
                ", passengerID=" + passengerID +
                ", driverID=" + driverID +
                '}';
    }
}
