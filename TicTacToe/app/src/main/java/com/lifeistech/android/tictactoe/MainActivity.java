package com.lifeistech.android.tictactoe;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int PLAYER_COUNT = 2;
    private static final int[] PLAYER_IMAGES = {R.drawable.mark_batsu, R.drawable.mark_maru};
    private int turn;
    private int[] gameBoard;
    private ImageButton[] boardButtons;
    private TextView playerTextView;
    private TextView winnerTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerTextView = (TextView)findViewById(R.id.playerText);
        winnerTextView = (TextView)findViewById(R.id.winnerText);

        boardButtons = new ImageButton[9];
        int[] buttonIds = {
                R.id.imageButton1,
                R.id.imageButton2,
                R.id.imageButton3,
                R.id.imageButton4,
                R.id.imageButton5,
                R.id.imageButton6,
                R.id.imageButton7,
                R.id.imageButton8,
                R.id.imageButton9
        };
        for(int i = 0; i < boardButtons.length; i++) {
            boardButtons[i] = (ImageButton)findViewById(buttonIds[i]);
            boardButtons[i].setTag(new Integer(i));
        }

        init();
        setPlayer();
    }

    private void init() {
        turn = 1;
        gameBoard = new int[boardButtons.length];
        for(int i = 0; i < boardButtons.length; i++) {
            gameBoard[i] = -1;
            boardButtons[i].setImageBitmap(null);
        }
        winnerTextView.setVisibility(View.GONE);
    }

    private void setPlayer() {
        if(turn % 2 == 0) {
            playerTextView.setText("Player: x");
        }
        else {
            playerTextView.setText("Player: o");
        }
    }

    public void tapMark(View view) {
        if(winnerTextView.getVisibility() == View.VISIBLE) {
            return;
        }

        int buttonNumber = (Integer)view.getTag();
        if(gameBoard[buttonNumber] == -1) {
            boardButtons[buttonNumber].setImageResource(PLAYER_IMAGES[turn % 2]);
            gameBoard[buttonNumber] = turn % 2;

            int judge = judgeGame();
            if(judge != -1) {
                if (judge == 0) {
                    winnerTextView.setText("Game End\nPlayer: x\nWin");
                    winnerTextView.setTextColor(Color.RED);
                } else {
                    winnerTextView.setText("Game End\nPlayer: o\nWin");
                    winnerTextView.setTextColor(Color.BLUE);
                }
                winnerTextView.setVisibility(View.VISIBLE);
            }
            else {
                if(turn >= gameBoard.length) {
                    winnerTextView.setText("Game End\nDraw");
                    winnerTextView.setTextColor(Color.YELLOW);
                    winnerTextView.setVisibility(View.VISIBLE);
                }
                turn += 1;
                setPlayer();
            }

        }
    }

    private int judgeGame() {
        for(int i = 0; i < 3; i++) {
            if(gameBoard[i * 3] != -1 && gameBoard[i * 3] == gameBoard[i * 3 + 1] && gameBoard[i * 3] == gameBoard[i * 3 + 2]) {
                return gameBoard[i * 3];
            }

            if(gameBoard[i] != -1 && gameBoard[i] == gameBoard[i + 3] && gameBoard[i] == gameBoard[i + 6]) {
                return gameBoard[i];
            }
        }

        if(gameBoard[0] != -1 && gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8]) {
            return gameBoard[0];
        }
        if(gameBoard[2] != -1 && gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6]) {
            return gameBoard[2];
        }

        return -1;
    }

    public void tapReset(View view) {
        init();
        setPlayer();
    }
}
