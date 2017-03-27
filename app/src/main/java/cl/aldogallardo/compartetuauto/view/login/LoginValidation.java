package cl.aldogallardo.compartetuauto.view.login;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Aldo Gallardo on 15-03-2017.
 */

public class LoginValidation {

    //instanciamos la interface para buscar sus metodos

    private LoginCallback callback;

    //generamos constructor para inicializar la interface
    public LoginValidation(LoginCallback callback) {
        this.callback = callback;
    }

    //validamos el usuario
    public void init(){
        if (FirebaseAuth.getInstance().getCurrentUser() !=null){
            callback.logged();
        }else{
            callback.sign();
        }
    }
}
