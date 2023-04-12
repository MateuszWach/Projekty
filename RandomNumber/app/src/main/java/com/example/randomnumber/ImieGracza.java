package com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImieGracza extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imie_gracza);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        SharedPreferences sp;
        EditText etImie = findViewById(R.id.etImieGracza);

        sp = getSharedPreferences("Gracz", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("imie",etImie.getText().toString());
        editor.commit();

        Intent intent = new Intent(this, gra.class);
        startActivity(intent);

    }
}