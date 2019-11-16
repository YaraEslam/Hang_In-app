package com.m7amdelbana.javahangin.view.auth.registeration;

import android.util.Patterns;

public class RegisterPresenter implements RegisterInteractor.OnRegisterFinishedListner{

    private RegisterView registerView;
    private RegisterInteractor registerInteractor;

    public RegisterPresenter(RegisterView registerView, RegisterInteractor registerInteractor) {
        this.registerView = registerView;
        this.registerInteractor = registerInteractor;
    }

    void checkCreation(String firstName, String lastName, String email, String phone,
                       String password, String confirmPassword) {
        if (firstName.isEmpty()) {
            registerView.firstNameError();
        } else if (lastName.isEmpty()) {
            registerView.lastNameError();
        }else if (email.isEmpty()) {
            registerView.emailError("Empty Email");
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            registerView.emailError("Invalid Email");
        }else if (phone.isEmpty()) {
            registerView.phoneError();
        } else if (password.isEmpty()) {
            registerView.passwordError();
        } else if (confirmPassword.isEmpty() || !confirmPassword.equalsIgnoreCase(password)) {
            registerView.confirmPasswordError();
        }else {
            registerView.showDialog();
            registerInteractor.login(firstName, lastName, email, phone, password,
                    confirmPassword, this);
        }
    }

    @Override
    public void onSuccess() {
        registerView.hideDialog();
        registerView.validCradintial();
    }

    @Override
    public void onError() {
        registerView.hideDialog();
        registerView.inValidCradintial();
    }
}
