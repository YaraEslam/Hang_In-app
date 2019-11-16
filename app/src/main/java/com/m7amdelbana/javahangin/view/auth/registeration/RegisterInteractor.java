package com.m7amdelbana.javahangin.view.auth.registeration;

import android.os.Handler;

import com.m7amdelbana.javahangin.view.auth.login.LoginInteractor;

public class RegisterInteractor {

    interface OnRegisterFinishedListner {

        void onSuccess();

        void onError();
    }

    void login(String firstName, String lastName, String email, String phone,
               String password, String confirmPassword,
               RegisterInteractor.OnRegisterFinishedListner onRegisterFinishedListner) {

        String defaultFirstName = "Yara";
        String defaultLastName = "Islam";
        String defaultEmail = "user@gmail.com";
        String defaultPhone = "01278664809";
        String defaultPassword = "123456789";


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (firstName.equalsIgnoreCase(defaultFirstName) &&
                        lastName.equalsIgnoreCase(defaultLastName) &&
                        email.equalsIgnoreCase(defaultEmail) &&
                        phone.equals(defaultPhone) &&
                        password.equals(defaultPassword) &&
                        confirmPassword.equals(defaultPassword)) {

                    onRegisterFinishedListner.onSuccess();
                } else {
                    onRegisterFinishedListner.onError();
                }
            }
        }, 3000);
    }

}
