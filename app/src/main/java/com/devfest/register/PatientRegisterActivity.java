package com.devfest.register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import com.devfest.R;
import com.devfest.api.model.LoginResponse;
import com.devfest.api.model.Patient;
import com.devfest.api.model.PatientRegisterRequest;
import com.devfest.api.retrofit.RetrofitClient;
import com.devfest.login.LoginActivity;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientRegisterActivity extends AppCompatActivity {
    private EditText nameEditText;
    private AppCompatSpinner genderSpinner;
    private AppCompatSpinner bloodGroupSpinner;
    private EditText emailEditText;
    private EditText addressEditText;
    private EditText passwordEditText;
    private EditText phoneEditText;
    private Button registerButton;
    private TextView signInTextView;
    private View root;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);
        assignViews();
        setListeners();
    }

    private void assignViews() {
        root = findViewById(R.id.root_view);
        nameEditText = findViewById(R.id.edit_text_name);
        genderSpinner = findViewById(R.id.spinner_gender);
        bloodGroupSpinner = findViewById(R.id.spinner_blood_group);
        emailEditText = findViewById(R.id.edit_text_email);
        passwordEditText = findViewById(R.id.edit_text_password);
        registerButton = findViewById(R.id.button_register);
        signInTextView = findViewById(R.id.text_view_sign_in);
        addressEditText = findViewById(R.id.edit_text_address);
        phoneEditText = findViewById(R.id.edit_text_phone);
    }

    private boolean validateEntries() {
        String message;
        if (nameEditText.getText().toString().trim().length() == 0) {
            message = getResources().getString(R.string.verify_name_string);
        } else if (addressEditText.getText().toString().trim().length() == 0) {
            message = getResources().getString(R.string.invalid_address_string);
        }
        else if (genderSpinner.getSelectedItemPosition() == 0) {
            message = getResources().getString(R.string.invalid_gender_string);
        } else if (bloodGroupSpinner.getSelectedItemPosition() == 0) {
            message = getResources().getString(R.string.invalid_blood_group_string);
        } else {
            return true;
        }
        alert(message);
        return false;
    }

    private void alert(String message) {
        Snackbar snackbar = Snackbar.make(root, message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    private void setListeners() {
        this.signInTextView.setOnClickListener(view -> goSignin());
        this.registerButton.setOnClickListener(view -> register());
    }
    private void goSignin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("SOURCE", "PATIENT");
        startActivity(intent);
    }

    private void register() {
        if (!validateEntries())
            return;
        RetrofitClient.service.signupPatient(generateRegistrationRequest())
                .enqueue(new Callback<LoginResponse<Patient>>() {
                    @Override
                    public void onResponse(Call<LoginResponse<Patient>> call, Response<LoginResponse<Patient>> response) {
                        Log.i("RESPONSE", response.toString());

                        if (response.isSuccessful()){
                            Log.i("SUCCESS", response.body().toString());
                            Snackbar.make(registerButton, R.string.register_success_string,
                                    Snackbar.LENGTH_SHORT).show();
                            Toast.makeText(PatientRegisterActivity.this,"success" , Toast.LENGTH_SHORT).show();
                            goSignin();
                            return;
                        } else {
                            Toast.makeText(PatientRegisterActivity.this, "not success", Toast.LENGTH_SHORT).show();
                        }

                    }


                    @Override
                    public void onFailure(Call<LoginResponse<Patient>> call, Throwable t) {
                        Snackbar.make(registerButton, R.string.register_error_string,
                                Snackbar.LENGTH_SHORT).show();
                    }
                });
    }

    private PatientRegisterRequest generateRegistrationRequest() {
        PatientRegisterRequest request = new PatientRegisterRequest();
        request.setEmail(emailEditText.getText().toString());
        request.setPassword(passwordEditText.getText().toString());
        request.setFirstname(extractFirstName());
        request.setLastname(extractLastName());
        request.setAddress(addressEditText.getText().toString());
        request.setPhone(phoneEditText.getText().toString());
        return request;
    }

    private String extractFirstName() {
        return nameEditText.getText().toString().split("/")[0]
                .trim();
    }

    private String extractLastName() {
        return nameEditText.getText().toString().split("/")[1]
                .trim();
    }


}
