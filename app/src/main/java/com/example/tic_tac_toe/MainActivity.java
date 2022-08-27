package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    //player represtenation
    //0-0
    //1-x
    int ActivePlayer = 1;
    int[] gstates = {2,2,2,2,2,2,2,2,2};
    int[][] winningPos = {{0,1,2},{3,4,5},{6,7,8},
                         {0,3,6},{1,4,7},{2,5,8},
                         {0,4,8},{2,4,6}};

    public void Ptap(View view){

        ImageView img = (ImageView) view;
        int TappedImage = Integer.parseInt(img.getTag().toString());

        if(!gameActive){
            restart(view);
        }

        if(gstates[TappedImage]==2){
            gstates[TappedImage]=ActivePlayer;
            img.setTranslationY(-1000f);
            if(ActivePlayer==0){
                img.setImageResource(R.drawable.o);
                ActivePlayer=1;
                TextView status = (TextView) findViewById(R.id.status);
                status.setText("X turn: Tap to play");
            }
            else{
                img.setImageResource(R.drawable.x);
                ActivePlayer=0;
                TextView status = (TextView) findViewById(R.id.status);
                status.setText("0 turn: Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        //checking if any one of the player has won the game or not
        for(int winningPos[]:winningPos){
            if(gstates[winningPos[0]]==gstates[winningPos[1]] && gstates[winningPos[1]]==gstates[winningPos[2]] && gstates[winningPos[0]]!=2){
                String winner ;
                gameActive=false;
                if(gstates[winningPos[0]]==0){
                    winner = "0 is winner";
                }
                else{
                    winner = "x is winner";
                }
                TextView status = (TextView) findViewById(R.id.status);
                status.setText(winner);
            }
        }


    }
    public void restart(View view){
        gameActive=true;
        ActivePlayer=1;
        for(int i =0;i<gstates.length;i++){
            gstates[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}