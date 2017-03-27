package cl.aldogallardo.compartetuauto.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.aldogallardo.compartetuauto.R;
import cl.aldogallardo.compartetuauto.adapter.CarAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    private CarAdapter carAdapter;
    private RecyclerView recyclerView;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = (RecyclerView) view.findViewById(R.id.CarRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        carAdapter = new CarAdapter();
        recyclerView.setAdapter(carAdapter);

    }


}
