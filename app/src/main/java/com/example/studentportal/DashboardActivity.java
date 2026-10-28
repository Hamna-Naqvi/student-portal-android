package com.example.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button profile = findViewById(R.id.btnProfile);

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(this,
                    ProfileActivity.class);
            startActivity(intent);
        });
    }
}
