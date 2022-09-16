package com.example.w3_e1_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private ImageButton imageButtonBack;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        transparentStatus();
        findViews();

        String email = getIntent().getStringExtra("email_dn");
        if (email != null) {
            textViewEmail.setText(email);
        }

        imageButtonBack.setOnClickListener(v -> {
            finish();
        });
    }

    private void findViews() {
        imageButtonBack = findViewById(R.id.ib_back);
        textViewEmail = findViewById(R.id.tv_email);
    }

    private void transparentStatus() {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void setWindowFlag(int i, boolean b) {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        if (b) {
            layoutParams.flags |= i;
        } else {
            layoutParams.flags &= ~i;
        }
        getWindow().setAttributes(layoutParams);
    }
}