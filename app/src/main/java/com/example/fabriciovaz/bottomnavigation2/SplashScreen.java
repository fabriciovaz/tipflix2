package com.example.fabriciovaz.bottomnavigation2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    /***Tela de splash screen 15/08/2018*/

    //Declarando os elementos da tela
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        //Associando aos elementos no XML
        tv  =(TextView)findViewById(R.id.tv);
        iv = (ImageView)findViewById(R.id.iv);


        //Início da Animação (Transição de tela)
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

        //Intent para mudar de tela após o intervalo de tempo estipulado, nesse caso 2 segundos
        final Intent i = new Intent(this,MovieDetail.class);
        //Log.d(TAG, "onCreate: #2flag");

        Thread timer = new Thread(){
            public void run (){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();

    }
}
