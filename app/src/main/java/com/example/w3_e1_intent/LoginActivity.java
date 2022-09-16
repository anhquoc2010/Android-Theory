package com.example.w3_e1_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private ProgressBar progressBar;
    private TextView textViewSignupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
        progressBar.setVisibility(ProgressBar.GONE);

        Bundle extras_dk = getIntent().getBundleExtra("bundle_dk");

        if (extras_dk != null) {
            String email = extras_dk.getString("email_dk");
            String password = extras_dk.getString("password_dk");
            editTextEmail.setText(email);
            editTextPassword.setText(password);
        }

        buttonLogin.setOnClickListener(v -> {
            String textEmail = editTextEmail.getText().toString();
            String textPassword = editTextPassword.getText().toString();

            //check if all the data are present
            if (TextUtils.isEmpty(textEmail)) {
                editTextEmail.setError("Please enter your email");
                editTextEmail.requestFocus();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                editTextEmail.setError("Invalid email");
                editTextEmail.requestFocus();
            } else if (TextUtils.isEmpty(textPassword)) {
                editTextPassword.setError("Please enter your password");
                editTextPassword.requestFocus();
            } else {
                progressBar.setVisibility(android.view.View.VISIBLE);
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                intent.putExtra("email_dn", textEmail);
                startActivity(intent);
            }
        });

        textViewSignupLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignupActivity.class));
        });
    }

    private void findViews() {
        buttonLogin = findViewById(R.id.button_login);
        editTextEmail = findViewById(R.id.editTextUserName_login);
        editTextPassword = findViewById(R.id.editTextPSWD_login);
        progressBar = findViewById(R.id.progressBarLogin);
        textViewSignupLink = findViewById(R.id.textView_register_link);
    }
}