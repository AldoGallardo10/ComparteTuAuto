package cl.aldogallardo.compartetuauto.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Aldo Gallardo on 24-03-2017.
 */

public class Nodes {

    private DatabaseReference root(){
        return FirebaseDatabase.getInstance().getReference();
    }
    public DatabaseReference carsByid(String userUid){ return root().child("users-cars").child(userUid);}
    public DatabaseReference users(){return root().child("users");}
    public DatabaseReference userById(String uid){
        return users().child(uid);
    }
    public DatabaseReference allCars(){ return root().child("cars");}



}
