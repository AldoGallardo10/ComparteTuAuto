package cl.aldogallardo.compartetuauto.view.car;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import cl.aldogallardo.compartetuauto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends Fragment implements Validate {



    public ShareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText  gpsStart, gpsFinish, quantity, hourStart, hourArrive;
        Button btnSend;

        gpsStart = (EditText) view.findViewById(R.id.gpsStartEt);
        gpsFinish = (EditText) view.findViewById(R.id.gpsFinishEt);
        quantity = (EditText) view.findViewById(R.id.quantityEt);
        hourStart = (EditText) view.findViewById(R.id.hourStartEt);
        hourArrive = (EditText) view.findViewById(R.id.hourArriveEt);

        btnSend = (Button) view.findViewById(R.id.sendCarBtn);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String start = gpsStart.getText().toString();
                String finish = gpsFinish.getText().toString();
                String quant = quantity.getText().toString();
                String starthour =  hourStart.getText().toString();
                String arrivehour = hourArrive.getText().toString();
                new SendCar(ShareFragment.this).validateCar(finish,start,quant,starthour,arrivehour);
            }
        });




    }

    @Override
    public void success() {
        TastyToast.makeText(getContext(),"Haz compartido un auto", Toast.LENGTH_SHORT,TastyToast.SUCCESS);
    }

    @Override
    public void error() {
        TastyToast.makeText(getContext(),"Completa todos los campos", Toast.LENGTH_SHORT,TastyToast.ERROR);
    }
}
