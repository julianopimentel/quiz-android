package com.kvikesh800gmail.relativlayoutjava;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;
import java.util.Collections;

public class Questions extends AppCompatActivity {
    DonutProgress donutProgress;
    int variable =0;
    TextView ques;
    Button OptA, OptB, OptC, OptD;
    Button play_button;
    String get;
    //Objects of different classes
    Carolinadiekmann Carolinadiekmann;
    Navegacao Navegacao;
    Fraude Fraude;
    Computador Computador;
    Prevencao Prevencao;
    Denuncia Denuncia;
    Redesocial Redesocial;
    Leibrasileira Leibrasileira;
    Crimevirtual Crimevirtual;
    Privacidade Privacidade;
    public int visibility = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, c10 = 0, i, j = 0, k = 0, l = 0;
    String global = null, Ques, Opta, Optb, Optc, Optd;
    ArrayList<Integer> list = new ArrayList<Integer>();
    Toast toast;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();//recieving the intent send by the Navigation activity
        get = intent.getStringExtra(Navigation_Activity.Message);//converting that intent message to string using the getStringExtra() method
        toast = new Toast(this);
        //attribute of the circular progress bar
        donutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        donutProgress.setMax(100);
        donutProgress.setFinishedStrokeColor(Color.parseColor("#FFFB385F"));
        donutProgress.setTextColor(Color.parseColor("#FFFB385F"));
        donutProgress.setKeepScreenOn(true);
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        //To play background sound
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.abc);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

        //Now the linking of all the datbase files with the Question activity
        Carolinadiekmann = new Carolinadiekmann(this);
        Carolinadiekmann.createDatabase();
        Carolinadiekmann.openDatabase();
        Carolinadiekmann.getWritableDatabase();

        Prevencao = new Prevencao(this);
        Prevencao.createDatabase();
        Prevencao.openDatabase();
        Prevencao.getWritableDatabase();

        Computador = new Computador(this);
        Computador.createDatabase();
        Computador.openDatabase();
        Computador.getWritableDatabase();

        Fraude = new Fraude(this);
        Fraude.createDatabase();
        Fraude.openDatabase();
        Fraude.getWritableDatabase();

        Denuncia = new Denuncia(this);
        Denuncia.createDatabase();
        Denuncia.openDatabase();
        Denuncia.getWritableDatabase();

        Redesocial = new Redesocial(this);
        Redesocial.createDatabase();
        Redesocial.openDatabase();
        Redesocial.getWritableDatabase();

        Leibrasileira = new Leibrasileira(this);
        Leibrasileira.createDatabase();
        Leibrasileira.openDatabase();
        Leibrasileira.getWritableDatabase();

        Crimevirtual = new Crimevirtual(this);
        Crimevirtual.createDatabase();
        Crimevirtual.openDatabase();
        Crimevirtual.getWritableDatabase();

        Privacidade = new Privacidade(this);
        Privacidade.createDatabase();
        Privacidade.openDatabase();
        Privacidade.getWritableDatabase();

        Navegacao = new Navegacao(this);
        Navegacao.createDatabase();
        Navegacao.openDatabase();
        Navegacao.getWritableDatabase();
        //Till here we are linking the database file
        OptA = (Button) findViewById(R.id.OptionA);
        OptB = (Button) findViewById(R.id.OptionB);
        OptC = (Button) findViewById(R.id.OptionC);
        OptD = (Button) findViewById(R.id.OptionD);
        ques = (TextView) findViewById(R.id.Questions);
        play_button = (Button) findViewById(R.id.play_button);//Play button to start the game

    }


    public void onClick(View v) {//When this method is executed then there will be new question came and also same method for play button
        final SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);
        k++;
        if (visibility == 0) {
            //showing the buttons which were previously invisible
            OptA.setVisibility(View.VISIBLE);
            OptB.setVisibility(View.VISIBLE);
            OptC.setVisibility(View.VISIBLE);
            OptD.setVisibility(View.VISIBLE);
            play_button.setVisibility(View.GONE);
            donutProgress.setVisibility(View.VISIBLE);
            visibility = 1;
            new CountDownTimer(50000, 1000) {//countdowntimer
                int i = 100;

                @Override
                public void onTick(long millisUntilFinished) {
                    i = i - 2;
                    donutProgress.setProgress(i);


                }

                @Override
                public void onFinish() {
                    toast.cancel();
                    SharedPreferences.Editor editor = shared.edit();//here we are saving the data when the countdown timer will finish and it is saved in shared prefrence file that is defined in onCreate method as score
                    editor.putInt("Questions", k).commit();
                    if (get.equals("c1") && shared.getInt("Computador", 0) < l)
                        editor.putInt("Computador", l * 10).apply();
                    else if (get.equals("c2") && shared.getInt("Navegacao", 0) < l)
                        editor.putInt("Navegacao", l * 10).apply();
                    else if (get.equals("c3") && shared.getInt("Leibrasileira", 0) < l)
                        editor.putInt("Leibrasileira", l * 10).apply();
                    else if (get.equals("c4") && shared.getInt("Redesocial", 0) < l)
                        editor.putInt("Redesocial", l * 10).apply();
                    else if (get.equals("c5") && shared.getInt("Privacidade", 0) < l)
                        editor.putInt("Privacidade", l * 10).apply();
                    else if (get.equals("c6") && shared.getInt("Denuncia", 0) < l)
                        editor.putInt("Denuncia", l * 10).apply();
                    else if (get.equals("c7") && shared.getInt("Carolinadiekmann", 0) < l)
                        editor.putInt("Carolinadiekmann", l * 10).apply();
                    else if (get.equals("c8") && shared.getInt("Crimevirtual", 0) < l)
                        editor.putInt("Crimevirtual", l * 10).apply();
                    else if (get.equals("c9") && shared.getInt("Prevencao", 0) < l)
                        editor.putInt("Prevencao", l * 10).apply();
                    else if (get.equals("c10") && shared.getInt("Fraude", 0) < l)
                        editor.putInt("Fraude", l * 10).apply();
                    donutProgress.setProgress(0);
                    if(variable==0) {
                        Intent intent = new Intent(Questions.this, Resultado.class);
                        intent.putExtra("correct", l);
                        intent.putExtra("attemp", k);
                        startActivity(intent);
                        finish();
                    }
                }
            }.start();
        }

        if (global != null) {
            if (global.equals("A")) {
                if (v.getId() == R.id.OptionA) {
                    //Here we use the snackbar because if we use the toast then they will be stacked an user cannot idetify which questions answer is it showing
                    Snackbar.make(v, "         Correto ☺", Snackbar.LENGTH_SHORT).show();

                    l++;
                } else {
                    Snackbar.make(v, "Incorreto\t      Resposta :" + Opta + "", Snackbar.LENGTH_SHORT).show();
                }

            } else if (global.equals("B")) {
                if (v.getId() == R.id.OptionB) {
                    Snackbar.make(v, "          Correto ☺", Snackbar.LENGTH_SHORT).show();
                    l++;
                } else {
                    Snackbar.make(v, "Incorreto\t      Resposta :" + Optb + "", Snackbar.LENGTH_SHORT).show();
                }

            } else if (global.equals("C")) {
                if (v.getId() == R.id.OptionC) {

                    Snackbar.make(v, "         Correto ☺", Snackbar.LENGTH_SHORT).show();
                    l++;
                } else {
                    Snackbar.make(v, "Incorreto\t   Resposta :" + Optc + "", Snackbar.LENGTH_SHORT).show();
                }
            } else if (global.equals("D")) {
                if (v.getId() == R.id.OptionD) {
                    Snackbar.make(v, "        Correto ☺", Snackbar.LENGTH_SHORT).show();
                    l++;
                } else {

                    Snackbar.make(v, "Incorreto\t   Resposta :" + Optd + "", Snackbar.LENGTH_SHORT).show();
                }
            }
        }
        if (get.equals("c1")) {

            if (c1 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c1=1;
            }
            Ques = Computador.readQuestion(list.get(j));
            Opta = Computador.readOptionA(list.get(j));
            Optb = Computador.readOptionB(list.get(j));
            Optc = Computador.readOptionC(list.get(j));
            Optd = Computador.readOptionD(list.get(j));
            global = Computador.readAnswer(list.get(j++));
        } else if (get.equals("c2")) {
            if (c2 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c2=1;
            }
            Ques = Navegacao.readQuestion(list.get(j));
            Opta = Navegacao.readOptionA(list.get(j));
            Optb = Navegacao.readOptionB(list.get(j));
            Optc = Navegacao.readOptionC(list.get(j));
            Optd = Navegacao.readOptionD(list.get(j));
            global = Navegacao.readAnswer(list.get(j++));

        } else if (get.equals("c3")) {
            if (c3 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c3=1;
            }
            Ques = Leibrasileira.readQuestion(list.get(j));
            Opta = Leibrasileira.readOptionA(list.get(j));
            Optb = Leibrasileira.readOptionB(list.get(j));
            Optc = Leibrasileira.readOptionC(list.get(j));
            Optd = Leibrasileira.readOptionD(list.get(j));
            global = Leibrasileira.readAnswer(list.get(j++));
        } else if (get.equals("c4")) {
            if (c4 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c4=1;
            }
            Ques = Redesocial.readQuestion(list.get(j));
            Opta = Redesocial.readOptionA(list.get(j));
            Optb = Redesocial.readOptionB(list.get(j));
            Optc = Redesocial.readOptionC(list.get(j));
            Optd = Redesocial.readOptionD(list.get(j));
            global = Redesocial.readAnswer(list.get(j++));
        } else if (get.equals("c5")) {
            if (c5 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c5=1;
            }
            Ques = Privacidade.readQuestion(list.get(j));
            Opta = Privacidade.readOptionA(list.get(j));
            Optb = Privacidade.readOptionB(list.get(j));
            Optc = Privacidade.readOptionC(list.get(j));
            Optd = Privacidade.readOptionD(list.get(j));
            global = Privacidade.readAnswer(list.get(j++));
        } else if (get.equals("c6")) {
            if (c6 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c6=1;
            }
            Ques = Denuncia.readQuestion(list.get(j));
            Opta = Denuncia.readOptionA(list.get(j));
            Optb = Denuncia.readOptionB(list.get(j));
            Optc = Denuncia.readOptionC(list.get(j));
            Optd = Denuncia.readOptionD(list.get(j));
            global = Denuncia.readAnswer(list.get(j++));

        } else if (get.equals("c7")) {
            if (c7 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c7=1;
            }
            Ques = Carolinadiekmann.readQuestion(list.get(j));
            Opta = Carolinadiekmann.readOptionA(list.get(j));
            Optb = Carolinadiekmann.readOptionB(list.get(j));
            Optc = Carolinadiekmann.readOptionC(list.get(j));
            Optd = Carolinadiekmann.readOptionD(list.get(j));
            global = Carolinadiekmann.readAnswer(list.get(j++));
        } else if (get.equals("c8")) {
            if (c8 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c8=1;
            }
            Ques = Crimevirtual.readQuestion(list.get(j));
            Opta = Crimevirtual.readOptionA(list.get(j));
            Optb = Crimevirtual.readOptionB(list.get(j));
            Optc = Crimevirtual.readOptionC(list.get(j));
            Optd = Crimevirtual.readOptionD(list.get(j));
            global = Crimevirtual.readAnswer(list.get(j++));
        } else if (get.equals("c9")) {
            if (c9 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c9=1;
            }
            Ques = Prevencao.readQuestion(list.get(j));
            Opta = Prevencao.readOptionA(list.get(j));
            Optb = Prevencao.readOptionB(list.get(j));
            Optc = Prevencao.readOptionC(list.get(j));
            Optd = Prevencao.readOptionD(list.get(j));
            global = Prevencao.readAnswer(list.get(j++));
        } else if (get.equals("c10")) {
            if (c10 == 0) {
                for (i = 1; i < 10; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c10=1;
            }
            Ques = Fraude.readQuestion(list.get(j));
            Opta = Fraude.readOptionA(list.get(j));
            Optb = Fraude.readOptionB(list.get(j));
            Optc = Fraude.readOptionC(list.get(j));
            Optd = Fraude.readOptionD(list.get(j));
            global = Fraude.readAnswer(list.get(j++));
        }
        ques.setText("" + Ques);
        OptA.setText(Opta);
        OptB.setText(Optb);
        OptC.setText(Optc);
        OptD.setText(Optd);
    }

    @Override
    protected void onPause() {
        super.onPause();
        variable =1;
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        variable =1;
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        variable = 1;
        finish();
    }
}
