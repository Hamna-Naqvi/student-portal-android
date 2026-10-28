package com.example.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView name = findViewById(R.id.txtProfileName);
        TextView email = findViewById(R.id.txtProfileEmail);
        Button logout = findViewById(R.id.btnLogout);

        android.content.SharedPreferences prefs =
                getSharedPreferences("StudentPortal", MODE_PRIVATE);

        name.setText("Name: " +
                prefs.getString("name", "Demo Student"));

        email.setText("Email: " +
                prefs.getString("email", "student@example.com"));

        logout.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
