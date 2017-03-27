package cl.aldogallardo.compartetuauto.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import cl.aldogallardo.compartetuauto.R;
import cl.aldogallardo.compartetuauto.data.CurrentUser;
import cl.aldogallardo.compartetuauto.data.Nodes;
import cl.aldogallardo.compartetuauto.models.Car;

import static android.R.attr.data;
import static android.R.attr.itemBackground;

/**
 * Created by Aldo Gallardo on 27-03-2017.
 */

public class CarAdapter extends FirebaseRecyclerAdapter<Car,CarAdapter.CarHolder> {
    String  userUid = new CurrentUser().userId();

    public CarAdapter() {
        super(Car.class, R.layout.custom_car, CarHolder.class, new Nodes().allCars());

    }

    @Override
    protected void populateViewHolder(CarHolder viewHolder, Car model, int position) {


        TextView quantity, start,finish;
        quantity = (TextView) viewHolder.itemView.findViewById(R.id.quantityTv);
        start = (TextView) viewHolder.itemView.findViewById(R.id.startEt);
        finish = (TextView) viewHolder.itemView.findViewById(R.id.finishEt);

        quantity.setText(model.getQuantity());
        start.setText(model.getGpsStart());
        finish.setText(model.getGpsFinish());


    }

    public static class CarHolder extends RecyclerView.ViewHolder {
        public CarHolder(View itemView) {
            super(itemView);
        }

    }
}
