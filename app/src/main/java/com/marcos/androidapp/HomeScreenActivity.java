package com.marcos.androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenActivity extends AppCompatActivity {
    private TextView nomeLogin;
    private EditText nomeLista;
    private Button enviaNome;
    //Lista
    private List<String> names =  new ArrayList<>();
    private RecyclerView recyclerView;
    private NameAdapter nameAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Lista
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nameAdapter = new NameAdapter(names);
        recyclerView.setAdapter(nameAdapter);


        //Lista

        nomeLogin = findViewById(R.id.nomeLogin);
        nomeLista= findViewById(R.id.nomeLista);
        enviaNome = findViewById(R.id.btnEnviar);
        Intent intent = getIntent();
        String nomeRecebido = intent.getStringExtra("KEY_NAME");
        nomeLogin.setText(nomeRecebido);

        enviaNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = nomeLista.getText().toString().trim();
                names.add(inputName);
                nameAdapter.notifyItemInserted(names.size() -1);
            }
        });
    }

}