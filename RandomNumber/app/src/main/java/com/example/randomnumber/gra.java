package com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class gra extends AppCompatActivity implements View.OnClickListener{

    Random random = new Random();
    int wynik = random.nextInt(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gra);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        SharedPreferences sp = getApplicationContext().getSharedPreferences("Gracz", Context.MODE_PRIVATE);
        String imie = sp.getString("imie","");

        TextView opis = findViewById(R.id.tvOpis);
        EditText etLiczba = findViewById(R.id.etLiczba);

        int szukana = Integer.parseInt(etLiczba.getText().toString());
        if (szukana > wynik) {
            opis.setText("Za dużo");
            etLiczba.setTextColor(Color.RED);
        } else if (szukana < wynik) {
            opis.setText("Za mało");
            etLiczba.setTextColor(Color.RED);
        } else if (szukana == wynik){
            opis.setText("Gratulacje "+imie);
            etLiczba.setTextColor(Color.GREEN);
        }
    }
}