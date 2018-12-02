package com.kvikesh800gmail.relativlayoutjava;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class Pontuacao extends AppCompatActivity {
    TextView a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences sharedPreferences = getSharedPreferences("Score", Context.MODE_PRIVATE);
        a1 = (TextView) findViewById(R.id.computer);
        a2 = (TextView) findViewById(R.id.sports);
        a3 = (TextView) findViewById(R.id.inventions);
        a4 = (TextView) findViewById(R.id.general);
        a5 = (TextView) findViewById(R.id.science);
        a6 = (TextView) findViewById(R.id.english);
        a7 = (TextView) findViewById(R.id.books);
        a8 = (TextView) findViewById(R.id.maths);
        a9 = (TextView) findViewById(R.id.capitals);
        a10 = (TextView) findViewById(R.id.currency);
        try {
            a1.setText("" + sharedPreferences.getInt("Computador", 0));
            a2.setText("" + sharedPreferences.getInt("Navegacao", 0));
            a3.setText("" + sharedPreferences.getInt("Leibrasileira", 0));
            a4.setText("" + sharedPreferences.getInt("Redesocial", 0));
            a5.setText("" + sharedPreferences.getInt("Privacidade", 0));
            a6.setText("" + sharedPreferences.getInt("Denuncia", 0));
            a7.setText("" + sharedPreferences.getInt("Carolinadiekmann", 0));
            a8.setText("" + sharedPreferences.getInt("Crimevirtual", 0));
            a9.setText("" + sharedPreferences.getInt("Prevencao", 0));
            a10.setText("" + sharedPreferences.getInt("Fraude", 0));
        } catch (Exception e) {
            Toast.makeText(Pontuacao.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

}
