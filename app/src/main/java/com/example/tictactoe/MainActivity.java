package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean flag = true;
    int CurrentPlayer = 0;
    int [] game = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] WinPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void Player(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!flag){
            gameReset(view);
        }
        if(game[tappedImage] == 2) {
            game[tappedImage] = CurrentPlayer;
            img.setTranslationY(-1000f);
            if (CurrentPlayer == 0) {
                img.setImageResource(R.drawable.x);
                CurrentPlayer = 1;
                TextView status = findViewById(R.id.statu);
                status.setText("Chance goes to player 2");

            } else {
                img.setImageResource(R.drawable.o);
                CurrentPlayer = 0;
                TextView status = findViewById(R.id.statu);
                status.setText("Chance goes to player 1");

            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPosition: WinPosition) {
            if (game[winPosition[0]] == game[winPosition[1]] &&
                    game[winPosition[1]] == game[winPosition[2]] &&
                    game[winPosition[0]] != 2) {
                String winnerStr;
                flag = false;
                if (game[winPosition[0]] == 0) {
                    winnerStr = "Player 1 won the game";

                } else {
                    winnerStr = "Player 2 won the game";

                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.statu);
                status.setText(winnerStr);
            }
        }
    }

    public void gameReset(View view) {
        flag = true;
        CurrentPlayer = 0;
        for(int i=0; i<game.length; i++){
            game[i] = 2;
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

        TextView status = findViewById(R.id.statu);
        status.setText("Player 1 can start the game");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}