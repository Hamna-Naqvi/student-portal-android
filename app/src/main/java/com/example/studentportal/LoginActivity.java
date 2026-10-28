package com.example.studentportal;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin, btnRegister, btnForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields",
                        Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter a valid email");
            } else if (email.equals("hamnanaqvi1507@gmail.com")
                    && password.equals("123456")) {

                Toast.makeText(this, "Login successful",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(
                        LoginActivity.this, DashboardActivity.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Invalid email or password",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        btnForgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }
}
