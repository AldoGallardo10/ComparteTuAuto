package cl.aldogallardo.compartetuauto.view.car;

import com.google.firebase.database.DatabaseReference;

import cl.aldogallardo.compartetuauto.data.CurrentUser;
import cl.aldogallardo.compartetuauto.data.Nodes;
import cl.aldogallardo.compartetuauto.models.Car;


/**
 * Created by Aldo Gallardo on 24-03-2017.
 */

public class SendCar  {

    private Validate callback;

    public SendCar(Validate callback) {
        this.callback = callback;
    }

    public void validateCar(String gpsFinish, String gpsStart, String quantity, String hourStart, String hourArrive)
    {
        if (gpsFinish.equals("") || gpsStart.equals("") || quantity.equals("") || hourStart.equals("") || hourArrive.equals("") ){
            callback.error();
        }else{
            CurrentUser currentUser = new CurrentUser();
            String userUid = currentUser.userId();
            Car car = new Car();
            car.setGpsStart(gpsStart);
            car.setGpsFinish(gpsFinish);
            car.setQuantity(quantity);
            car.setHourStart(hourStart);
            car.setHourArrive(hourArrive);


            DatabaseReference ref = new Nodes().carsByid(userUid);
            String key = ref.push().getKey();
            car.setId(key);
            ref.child(key).setValue(car);

            new Nodes().allCars().push().setValue(car);
            callback.success();
        }
    }
}

