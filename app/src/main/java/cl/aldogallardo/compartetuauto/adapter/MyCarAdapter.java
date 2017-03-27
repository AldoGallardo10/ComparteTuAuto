package cl.aldogallardo.compartetuauto.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import cl.aldogallardo.compartetuauto.R;
import cl.aldogallardo.compartetuauto.data.CurrentUser;
import cl.aldogallardo.compartetuauto.data.Nodes;
import cl.aldogallardo.compartetuauto.models.Car;

/**
 * Created by Aldo Gallardo on 26-03-2017.
 */

public class MyCarAdapter extends FirebaseRecyclerAdapter<Car, MyCarAdapter.MyCarHolder> {


    public MyCarAdapter(String UserUid) {
        super(Car.class, R.layout.custom_my_car, MyCarHolder.class, new Nodes().carsByid(UserUid));

    }

    @Override
    protected void populateViewHolder(final MyCarHolder viewHolder, final Car model, int position) {

        TextView start,finish;
        Button btnDelete;

        btnDelete = (Button) viewHolder.itemView.findViewById(R.id.deleteBtn);
        start = (TextView) viewHolder.itemView.findViewById(R.id.startEt);
        finish = (TextView) viewHolder.itemView.findViewById(R.id.finishEt);

        start.setText(model.getGpsStart());
        finish.setText(model.getGpsFinish());


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = new CurrentUser().userId();
                new Nodes().carsByid(uid).child(model.getId()).removeValue();
            }
        });

    }


    public static class MyCarHolder extends RecyclerView.ViewHolder {
        public MyCarHolder(View itemView) {
            super(itemView);
        }

    }
}
