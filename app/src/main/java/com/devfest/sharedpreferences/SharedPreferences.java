package com.devfest.sharedpreferences;

import android.content.Context;

import com.devfest.api.model.Doctor;
import com.devfest.api.model.Patient;
import com.google.gson.Gson;

public class SharedPreferences {
    private static final String USER_SHARED_PREFERENCES = "USER_SHARED_PREFERENCES";
    private static final String ACCOUNT_TYPE_KEY = "ACCOUNT_TYPE";
    private static final String ACCOUNT_TYPE_PATIENT = "ACCOUNT_TYPE_PATIENT";
    private static final String ACCOUNT_TYPE_DOCTOR = "ACCOUNT_TYPE_DOCTOR";
    private static final String AUTH_TOKEN_KEY = "AUTH_TOKEN";
    private static final String LOGGED_DOCTOR_KEY = "STORED_DOCTOR_KEY";
    private static final String LOGGED_PATIENT_KEY = "STORED_PATIENT_KEY";


    public static void storeAuthToken(Context context, String authToken) {
        context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(AUTH_TOKEN_KEY, authToken)
                .commit();
    }

    public static  void deleteAuthToken(Context context) {
        context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .remove(AUTH_TOKEN_KEY)
                .commit();
    }

    public static void storeLoggedIsPatient(Context context) {
        context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(ACCOUNT_TYPE_KEY, ACCOUNT_TYPE_PATIENT)
                .commit();
    }

    public static void storeLoggedIsDoctor(Context context) {
        context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(ACCOUNT_TYPE_KEY, ACCOUNT_TYPE_DOCTOR)
                .commit();
    }

    public static void storeLoggedPatient(Context context, Patient patient) {
        context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(LOGGED_PATIENT_KEY,
                        new Gson().toJson(patient))
                .commit();
    }

    public static void storeLoggedDoctor(Context context, Doctor doctor) {
        context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(LOGGED_DOCTOR_KEY,
                        new Gson().toJson(doctor))
                .commit();
    }

    public  static Patient getLoggedPatient(Context context) {
        return new Gson().fromJson(
                context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)
                        .getString(LOGGED_PATIENT_KEY, null),
                Patient.class);
    }

    public static Doctor getLoggedDoctor(Context context) {
        return new Gson().fromJson(
                context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)
                        .getString(LOGGED_DOCTOR_KEY, null),
                Doctor.class);
    }
}
