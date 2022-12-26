package com.devfest.chooseuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import com.devfest.R;
import com.devfest.register.DoctorRegisterActivity;
import com.devfest.register.PatientRegisterActivity;
import com.google.android.material.snackbar.Snackbar;

public class ChooseUserActivity extends AppCompatActivity {

    private View patientContainer;
    private View doctorContainer;
    private ImageFilterView doctorImageView;
    private ImageFilterView patientImageView;
    private View nextButton;

    private int userChoice = -1;
    private static final int CHOICE_PATIENT = 0;
    private static final int CHOICE_DOCTOR = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);
        assignViews();
        initListeners();
    }

    private void assignViews() {
        patientContainer = findViewById(R.id.container_patient_choice);
        doctorContainer = findViewById(R.id.container_doctor_choice);
        doctorImageView = findViewById(R.id.image_view_doctor);
        patientImageView = findViewById(R.id.image_view_patient);
        nextButton = findViewById(R.id.button_next);
    }

    private void initListeners() {
        patientContainer.setOnClickListener(view -> {
            selectPatient();
        });
        doctorContainer.setOnClickListener(view -> {
            selectDoctor();
        });

        nextButton.setOnClickListener(view -> goNext());
    }

    private void selectPatient() {
        userChoice = CHOICE_PATIENT;
        doctorImageView.setImageBitmap(null);
        patientImageView.setImageResource(R.drawable.ic_checked);
    }

    private void selectDoctor() {
        userChoice = CHOICE_DOCTOR;
        patientImageView.setImageBitmap(null);
        doctorImageView.setImageResource(R.drawable.ic_checked);
    }

    private void goNext() {
        if (userChoice == CHOICE_DOCTOR) {
            goDoctorRegistration();
            return;
        }
        if(userChoice == CHOICE_PATIENT) {
            goPatientRegistration();
            return;
        }
        Snackbar.make(nextButton, R.string.select_your_choice_string, Snackbar.LENGTH_SHORT).show();

    }

    private void goDoctorRegistration() {
        Intent intent = new Intent(this, DoctorRegisterActivity.class);
        startActivity(intent);
    }

    private void goPatientRegistration() {
        Intent intent = new Intent(this, PatientRegisterActivity.class);
        startActivity(intent);
    }
}
