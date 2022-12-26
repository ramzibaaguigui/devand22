package com.devfest.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.devfest.R;
import com.devfest.api.model.Doctor;
import com.devfest.api.model.LoginRequest;
import com.devfest.api.model.LoginResponse;
import com.devfest.api.model.Patient;
import com.devfest.api.retrofit.RetrofitClient;
import com.devfest.sharedpreferences.SharedPreferences;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView forgotPasswordTextView;
    private Button loginButton;
    private TextView signUpTextView;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        assignViews();
    }

    private void assignViews() {
        emailEditText = findViewById(R.id.edit_text_email);
        passwordEditText = findViewById(R.id.edit_text_password);
        forgotPasswordTextView = findViewById(R.id.text_view_forgot_password);
        loginButton = findViewById(R.id.button_login);
        signUpTextView = findViewById(R.id.text_view_sign_up);
    }

    private void initListeners() {
        loginButton.setOnClickListener(view -> tryLogin());
    }

    private void tryLogin() {
        if (!validateEntries()) {
            login();
        }
    }

    private void login() {
        if (isDoctor()) {

        } else {
            RetrofitClient.service.loginPatient(generateLoginRequest()).enqueue(
                    new Callback<LoginResponse<Patient>>() {
                        @Override
                        public void onResponse(Call<LoginResponse<Patient>> call, Response<LoginResponse<Patient>> response) {
                            if (response.isSuccessful()) {
                                handlePatientLoginSuccess(response.body());
                            } else {
                                handleLoginError();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse<Patient>> call, Throwable t) {
                            Snackbar.make(loginButton, R.string.login_error_string, Snackbar.LENGTH_SHORT).show();
                        }
                    }
            );
        }
    }

    private LoginRequest generateLoginRequest() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.withEmail(emailEditText.getText().toString());
        loginRequest.withPassword(passwordEditText.getText().toString());
        loginRequest.isDoctor(isDoctor());
        return loginRequest;

    }

    private boolean isDoctor() {
        String source = getIntent().getExtras().getString("SOURCE", null);
        return !"PATIENT".equals(source);

    }

    private boolean validateEntries() {
        if (emailEditText.getText().toString().trim().length() == 0 ||
        passwordEditText.getText().toString().length() == 0) {
            Snackbar.make(loginButton, R.string.validate_login_entries_string, Snackbar.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }

    private void handlePatientLoginSuccess(LoginResponse<Patient> loginResponse) {
        SharedPreferences.storeAuthToken(this, loginResponse.getToken());
        SharedPreferences.storeLoggedIsPatient(this);
        SharedPreferences.storeLoggedPatient(this, loginResponse.getData());
    }

    private void handleDoctorLoginSuccess(LoginResponse<Doctor> loginResponse) {
        SharedPreferences.storeAuthToken(this, loginResponse.getToken());
        SharedPreferences.storeLoggedIsDoctor(this);
        SharedPreferences.storeLoggedDoctor(this, loginResponse.getData());
    }

    private void handleLoginError() {
        Snackbar.make(loginButton, R.string.login_error_string, Snackbar.LENGTH_SHORT).show();
    }
}
