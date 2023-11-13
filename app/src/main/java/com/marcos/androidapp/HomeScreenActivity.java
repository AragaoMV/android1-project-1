package com.marcos.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {
    private TextView nomeLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        nomeLogin = findViewById(R.id.nomeLogin);
        Intent intent = getIntent();
        String nomeRecebido = intent.getStringExtra("KEY_NAME");
        nomeLogin.setText(nomeRecebido);





    }
}