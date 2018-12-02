package com.kvikesh800gmail.relativlayoutjava;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Configuracao extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences sharedPreferences = getSharedPreferences("Score", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button sound = (Button) findViewById(R.id.play_sound);
        Button reset = (Button) findViewById(R.id.reset);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (sharedPreferences.getInt("Sound", 0) == 0) {
            sound.setText("Desativar Som");
            mediaPlayer = MediaPlayer.create(this, R.raw.abc);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        } else
            sound.setText("Ativar Som");
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound.getText().equals("Ativar Som")) {
                    editor.putInt("Sound", 0).commit();
                    sound.setText("Desativar Som");
                    mediaPlayer = MediaPlayer.create(Configuracao.this, R.raw.abc);
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                } else if (sound.getText().equals("Desativar Som")) {
                    editor.putInt("Sound", 1).commit();
                    sound.setText("Ativar Som");
                    mediaPlayer.stop();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("Computador", 0);
                editor.putInt("Navegacao", 0);
                editor.putInt("Leibrasileira", 0);
                editor.putInt("Redesocial", 0);
                editor.putInt("Privacidade", 0);
                editor.putInt("Denuncia", 0);
                editor.putInt("Carolinadiekmann", 0);
                editor.putInt("Crimevirtual", 0);
                editor.putInt("Prevencao", 0);
                editor.putInt("Fraude", 0);
                editor.commit();
                Snackbar.make(v,"Pontuação resetada com Succeso",Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }

}

