package cl.aldogallardo.compartetuauto.view.main;

import com.google.firebase.database.DatabaseReference;

import cl.aldogallardo.compartetuauto.data.CurrentUser;
import cl.aldogallardo.compartetuauto.data.Nodes;
import cl.aldogallardo.compartetuauto.models.User;

/**
 * Created by Aldo Gallardo on 26-03-2017.
 */

public class UploadUser {

    public  void toFirebase(){

        final CurrentUser currentUser = new CurrentUser();
        User user = new User();
        user.setName(currentUser.name());
        user.setEmail(currentUser.email());
        user.setUid(currentUser.userId());

        DatabaseReference userReference = new Nodes().userById(currentUser.userId());
        userReference.setValue(user);
    }
}
