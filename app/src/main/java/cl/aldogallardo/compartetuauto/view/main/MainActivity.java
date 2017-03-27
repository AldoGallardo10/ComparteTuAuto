package cl.aldogallardo.compartetuauto.view.main;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import cl.aldogallardo.compartetuauto.R;
import cl.aldogallardo.compartetuauto.view.fragment.RouteFragment;
import cl.aldogallardo.compartetuauto.view.fragment.SearchFragment;
import cl.aldogallardo.compartetuauto.view.fragment.ShareFragment;
import cl.aldogallardo.compartetuauto.view.fragment.TravelFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new UploadUser().toFirebase();
        //subimos el usuario logeado a firebase

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SearchFragment search = new SearchFragment();
        fragmentManager.beginTransaction().replace(R.id.content, search).commit();
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);


        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .setBarBackgroundColor("#FFFFFF")
                .setActiveColor(R.color.colorPrimary)
                .addItem(new BottomNavigationItem(R.mipmap.ic_search_white_24dp,"Buscar"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_add_circle_outline_white_24dp, "Compartir"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_my_location_white_24dp, "MisRutas"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_card_travel_white_24dp, "Viajes"))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (position==0){
                    SearchFragment search = new SearchFragment();
                    fragmentManager.beginTransaction().replace(R.id.content, search).commit();
                }else if (position==1){
                    ShareFragment search = new ShareFragment();
                    fragmentManager.beginTransaction().replace(R.id.content, search).commit();
                }else if (position==2){
                    RouteFragment search = new RouteFragment();
                    fragmentManager.beginTransaction().replace(R.id.content, search).commit();
                }else if (position==3){
                    TravelFragment search = new TravelFragment();
                    fragmentManager.beginTransaction().replace(R.id.content, search).commit();
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
