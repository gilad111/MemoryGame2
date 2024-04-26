package com.example.memorygame;



import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    String[][] board;
    ImageView[] ImageViews;
    int count;
    int countPlayer1 = 0;
    int countPlayer2 = 0;
    int card1;
    int lastOpenedCard1 = -1;
    int lastOpenedCard2 = -1;
    String turn = "counterPlayer1";
    Integer[] drawableIds = {
            // Array of drawable resource IDs
            R.drawable.num1, R.drawable.num2, R.drawable.num3, R.drawable.num4, R.drawable.num5, R.drawable.num6, R.drawable.num7, R.drawable.num8,
            R.drawable.num1, R.drawable.num2, R.drawable.num3, R.drawable.num4, R.drawable.num5, R.drawable.num6, R.drawable.num7, R.drawable.num8
    };

    int[] viewId = {
            //creates arr of view Ids
            R.id.im_11, R.id.im_12, R.id.im_13, R.id.im_14,
            R.id.im_21, R.id.im_22, R.id.im_23, R.id.im_24,
            R.id.im_31, R.id.im_32, R.id.im_33, R.id.im_34,
            R.id.im_41, R.id.im_42, R.id.im_43, R.id.im_44
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username = getIntent().getStringExtra("USERNAME");
        TextView welcomeTextView = findViewById(R.id.WelcomeMsg);
        welcomeTextView.setText("Welcome: " + username);
    }


    private void onNewGame() {
        shuffleCards();
        board = new String[4][4];
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                board[row][col] = new String();
            }
        count = 0;
    }

    private void onNewGame1() {
        ImageView[] imageViews = new ImageView[16];
        for (int i = 0; i < drawableIds.length; i++) {
            // Create a new ImageView
            Context context = null;
            ImageView imageView = new ImageView(context);
            // Set the image resource for the ImageView
            imageView.setImageResource(drawableIds[i]);
            // Add the ImageView to the array
            imageViews[i] = imageView;
        }
    }

    private void shuffleCards() {
        List<Integer> drawableIdsList = Arrays.asList(drawableIds);
        Collections.shuffle(drawableIdsList);
        drawableIdsList.toArray(drawableIds);
    }

    public void knock(View view) {
        count++;
        for (int i = 0; i < viewId.length; i++) {
            if (view.getId() == viewId[i]) {
                ImageView backImageView = findViewById(viewId[i]);
                backImageView.setImageResource(drawableIds[i]);
                turnEnd(view);
            }
        }
        // Update the last opened cards
        if (lastOpenedCard1 != -1) {
            lastOpenedCard2 = lastOpenedCard1;
        }
        lastOpenedCard1 = view.getId();
    }

    public void turnEnd(View view) {
        if (count % 2 != 0) {
            card1 = view.getId();
            return;
        }
        if (count % 2 == 0) {
            ImageView imageViewCard1 = findViewById(card1);
            Drawable image1 = imageViewCard1.getDrawable();
            Drawable image2 = ((ImageView) view).getDrawable();
            if (image1.getConstantState().equals(image2.getConstantState())) {
                if (turn.equals("counterPlayer1")) {
                    countPlayer1++;
                    TextView counterTextView = findViewById(R.id.counter1);
                    counterTextView.setText("P1-" + countPlayer1);
                    turn = "counterPlayer2";
                } else {
                    countPlayer2++;
                    TextView counterTextView = findViewById(R.id.counter2);
                    counterTextView.setText("P2-" + countPlayer2);
                    turn = "counterPlayer1";
                }
            } else {
                if (turn.equals("counterPlayer1")) {
                    turn = "counterPlayer2";
                } else {
                    turn = "counterPlayer1";

                }
            }
        }
    }

    public void Reset(View view) {
        shuffleCards();
        count = 0;
        countPlayer1 = 0;
        TextView counterTextView = findViewById(R.id.counter1);
        counterTextView.setText("P1-" + countPlayer1);
        countPlayer2 = 0;
        TextView counterTextView2 = findViewById(R.id.counter2);
        counterTextView2.setText("P2-" + countPlayer2);
        for (int i = 0; i < viewId.length; i++) {
            ImageView cardClosed = findViewById(viewId[i]);
            cardClosed.setImageResource(R.drawable.card_back);
        }
        lastOpenedCard1 = -1;
        lastOpenedCard2 = -1;
    }

    public void closeCard(View view) {
        ImageView cardClosed1 = findViewById(lastOpenedCard1);
        cardClosed1.setImageResource(R.drawable.card_back);
        ImageView cardClosed2 = findViewById(lastOpenedCard2);
        cardClosed2.setImageResource(R.drawable.card_back);
    }
}