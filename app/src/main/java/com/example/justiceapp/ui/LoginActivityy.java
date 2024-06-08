package com.example.justiceapp.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.justiceapp.MainActivity;
import com.example.justiceapp.R;
import com.example.justiceapp.databinding.ActivityLoginBinding;
import com.example.justiceapp.repository.MainRepository;
import com.permissionx.guolindev.PermissionX;

public class LoginActivityy extends AppCompatActivity {



    private ActivityLoginBinding views;

    private MainRepository mainRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        views = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(views.getRoot());
        init();

        // Find the homeButton by its id

    }


    private void init() {
        mainRepository = MainRepository.getInstance();
        views.enterBtn.setOnClickListener(v -> {
            PermissionX.init(this)
                    .permissions(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
                    .request((allGranted, grantedList, deniedList) -> {
                        if (allGranted) {
                            //login to firebase here

                            mainRepository.login(
                                    views.username.getText().toString(), getApplicationContext(), () -> {
                                        //if success then we want to move to call activity
                                        startActivity(new Intent(LoginActivityy.this, CallActivity.class));
                                    }
                            );
                        }
                    });


        });
    }


}