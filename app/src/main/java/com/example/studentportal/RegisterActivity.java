package com.example.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText name = findViewById(R.id.etName);
        EditText email = findViewById(R.id.etRegEmail);
        EditText password = findViewById(R.id.etRegPassword);
        EditText confirm = findViewById(R.id.etConfirmPassword);
        Button create = findViewById(R.id.btnCreateAccount);

        create.setOnClickListener(v -> {
            String n = name.getText().toString().trim();
            String e = email.getText().toString().trim();
            String p = password.getText().toString();
            String c = confirm.getText().toString();

            if (n.isEmpty() || e.isEmpty()
                    || p.isEmpty() || c.isEmpty()) {
                Toast.makeText(this, "Fill all fields",
                        Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
                email.setError("Enter a valid email");
            } else if (!p.equals(c)) {
                confirm.setError("Passwords do not match");
            } else {
                getSharedPreferences("StudentPortal",
                        MODE_PRIVATE).edit()
                        .putString("name", n)
                        .putString("email", e)
                        .apply();

                Toast.makeText(this, "Registration successful",
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(this,
                        DashboardActivity.class));
                finish();
            }
        });
    }
}
