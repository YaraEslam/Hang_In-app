package com.m7amdelbana.javahangin.view.auth.registeration;

public interface RegisterView {

    void showDialog();

    void hideDialog();

    void firstNameError();

    void lastNameError();

    void emailError(String error);

    void phoneError();

    void passwordError();

    void confirmPasswordError();

    void validCradintial();

    void inValidCradintial();
}
