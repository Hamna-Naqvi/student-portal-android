package com.example.studentportal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        EditText password = findViewById(R.id.etNewPassword);
        EditText confirm = findViewById(R.id.etNewConfirm);
        Button reset = findViewById(R.id.btnReset);

        reset.setOnClickListener(v -> {
            String p = password.getText().toString();
            String c = confirm.getText().toString();

            if (p.isEmpty() || c.isEmpty()) {
                Toast.makeText(this, "Fill both fields",
                        Toast.LENGTH_SHORT).show();
            } else if (!p.equals(c)) {
                confirm.setError("Passwords do not match");
            } else {
                getSharedPreferences("StudentPortal",
                        MODE_PRIVATE).edit()
                        .putString("password", p)
                        .apply();

                Toast.makeText(this, "Password reset simulated",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
