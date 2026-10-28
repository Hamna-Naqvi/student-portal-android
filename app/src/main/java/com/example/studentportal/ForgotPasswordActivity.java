package com.example.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EditText email = findViewById(R.id.etRecoveryEmail);
        Button recover = findViewById(R.id.btnRecover);

        recover.setOnClickListener(v -> {
            String e = email.getText().toString().trim();

            if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
                email.setError("Enter a valid email");
                return;
            }

            Toast.makeText(this,
                    "Recovery request simulated",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,
                    ResetPasswordActivity.class);
            intent.putExtra("email", e);
            startActivity(intent);
        });
    }
}
