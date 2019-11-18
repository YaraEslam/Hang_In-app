package com.m7amdelbana.javahangin.view.auth.registeration;

import android.os.Handler;

import com.m7amdelbana.javahangin.network.api.APIClient;
import com.m7amdelbana.javahangin.network.models.Sign_up;
import com.m7amdelbana.javahangin.network.service.APIInterface;
import com.m7amdelbana.javahangin.view.auth.login.LoginInteractor;

import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterInteractor {

    interface OnRegisterFinishedListner {

        void onSuccess();

        void onError();
    }

    void login(String firstName, String lastName, String email, String phone,
               String password, String confirmPassword,
               RegisterInteractor.OnRegisterFinishedListner onRegisterFinishedListner) {

        Sign_up signUp = new Sign_up(firstName, lastName, email, phone, password, confirmPassword);

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        apiInterface.login(signUp).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NotNull Call<ResponseBody> call,
                                   @NotNull Response<ResponseBody> response) {

                if (response.isSuccessful()){
                    onRegisterFinishedListner.onSuccess();
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseBody> call, Throwable t) {

                onRegisterFinishedListner.onError();
            }
        });

//        String defaultFirstName = "Yara";
//        String defaultLastName = "Islam";
//        String defaultEmail = "user@gmail.com";
//        String defaultPhone = "01278664809";
//        String defaultPassword = "123456789";
//
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (firstName.equalsIgnoreCase(defaultFirstName) &&
//                        lastName.equalsIgnoreCase(defaultLastName) &&
//                        email.equalsIgnoreCase(defaultEmail) &&
//                        phone.equals(defaultPhone) &&
//                        password.equals(defaultPassword) &&
//                        confirmPassword.equals(defaultPassword)) {
//
//                    onRegisterFinishedListner.onSuccess();
//                } else {
//                    onRegisterFinishedListner.onError();
//                }
//            }
//        }, 3000);
    }

}
