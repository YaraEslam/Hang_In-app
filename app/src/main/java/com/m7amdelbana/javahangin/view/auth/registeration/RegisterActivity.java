package com.m7amdelbana.javahangin.view.auth.registeration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.m7amdelbana.javahangin.R;
import com.m7amdelbana.javahangin.util.LoadingDialog;


public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private Toolbar toolbar;
    private TextView tvToolbar;
    private ImageView imgToolbar;

    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtEmail;
    private EditText edtPhone;
    private EditText edtPassword;
    private EditText edtConfirmPassword;

    private Button creat;

    private LoadingDialog loadingDialog;

    RegisterPresenter registerPresenter = new RegisterPresenter(
            this, new RegisterInteractor());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initToolbar();

        edtFirstName = findViewById(R.id.registration_firstName_editText);
        edtLastName = findViewById(R.id.registration_lastName_editText);
        edtEmail = findViewById(R.id.registration_email_editText);
        edtPhone = findViewById(R.id.registration_phone_editText);
        edtPassword = findViewById(R.id.registration_password_editText);
        edtConfirmPassword = findViewById(R.id.registration_confirm_password_editText);
        creat = findViewById(R.id.registration_submit_button);

        loadingDialog = new LoadingDialog(this);

        creat.setOnClickListener(view -> {
            String firstName = edtFirstName.getText().toString().trim();
            String lastName = edtLastName.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String phone = edtPhone.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String confirmPassword = edtConfirmPassword.getText().toString().trim();

            registerPresenter.checkCreation(firstName, lastName, email,
                    phone, password, confirmPassword);
        });

        tvToolbar.setText(R.string.create_account);
        imgToolbar.setOnClickListener(view -> finish());
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.main_toolbar);
        tvToolbar = findViewById(R.id.toolbar_title_textView);
        imgToolbar = findViewById(R.id.toolbar_back_imageView);
        setSupportActionBar(toolbar);
    }

    @Override
    public void showDialog() { loadingDialog.show(); }

    @Override
    public void hideDialog() { loadingDialog.hide(); }

    @Override
    public void firstNameError() { edtFirstName.setError("Empty Name"); }

    @Override
    public void lastNameError() { edtLastName.setError("Empty"); }

    @Override
    public void emailError(String error) { edtEmail.setError(error); }

    @Override
    public void phoneError() { edtPhone.setError("Invalid phone"); }

    @Override
    public void passwordError() { edtPassword.setError("Invalid password"); }

    @Override
    public void confirmPasswordError() { edtConfirmPassword.setError("Invalid password"); }

    @Override
    public void validCradintial() { Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show(); }

    @Override
    public void inValidCradintial() { Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show(); }
}
