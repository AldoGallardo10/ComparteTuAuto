package cl.aldogallardo.compartetuauto.models;

/**
 * Created by Aldo Gallardo on 24-03-2017.
 */

public class Car {

    private  String id, name, gpsStart, gpsFinish, quantity, hourStart, hourArrive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGpsStart() {
        return gpsStart;
    }

    public void setGpsStart(String gpsStart) {
        this.gpsStart = gpsStart;
    }

    public String getGpsFinish() {
        return gpsFinish;
    }

    public void setGpsFinish(String gpsFinish) {
        this.gpsFinish = gpsFinish;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourArrive() {
        return hourArrive;
    }

    public void setHourArrive(String hourArrive) {
        this.hourArrive = hourArrive;
    }
}
