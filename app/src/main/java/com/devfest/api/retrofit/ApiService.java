package com.devfest.api.retrofit;

import com.devfest.api.model.Doctor;
import com.devfest.api.model.DoctorRegisterRequest;
import com.devfest.api.model.HealthRecording;
import com.devfest.api.model.LoginRequest;
import com.devfest.api.model.LoginResponse;
import com.devfest.api.model.Patient;
import com.devfest.api.model.PatientRegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @POST("/users/login")
    Call<LoginResponse<Doctor>> loginDoctor(
                              @Body LoginRequest loginRequest);

    @POST("/users/login")
    Call<LoginResponse<Patient>> loginPatient(@Body LoginRequest loginRequest);

    @POST("/users/signup")
    Call<LoginResponse<Doctor>> signupDoctor(@Header("Authorization") String token,
                                           @Body DoctorRegisterRequest doctorRegisterRequest);

    @POST("/users/signup")
    Call<LoginResponse<Patient>> signupPatient(@Body PatientRegisterRequest patientRegisterRequest);

    @POST("/emergency/post")
    Call<ApiResponse<HealthStatus>> postEmergency(@Header("Authorization") String token,
                                                  @Body HealthRecording healthRecording);

    @GET("/doctor/getone/{id}")
    Call<Doctor> getDoctor(@Header("Authorization") String token,
                           @Path("id") String id);

    @GET("/patient/getone/{id}")
    Call<Patient> getPatient(@Header("Authorization") String token,
                             @Path("id") String id);

}

