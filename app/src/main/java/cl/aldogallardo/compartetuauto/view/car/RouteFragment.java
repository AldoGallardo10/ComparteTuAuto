package cl.aldogallardo.compartetuauto.view.car;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.aldogallardo.compartetuauto.R;
import cl.aldogallardo.compartetuauto.adapter.MyCarAdapter;
import cl.aldogallardo.compartetuauto.data.CurrentUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class RouteFragment extends Fragment  {

    private MyCarAdapter myCarAdapter;
    private RecyclerView recyclerView;


    public RouteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_route, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CurrentUser currentUser = new CurrentUser();
        String id = currentUser.userId();

        recyclerView = (RecyclerView) view.findViewById(R.id.MyCarRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        myCarAdapter = new MyCarAdapter(id);
        recyclerView.setAdapter(myCarAdapter);


    }
}
