[11:25, 5.1.2024] עדי זופניק: package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    String[][] board;
    ImageView[] ImageViews;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void onNewGame() {
        board = new String[4][4];
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                board[row][col] = new String();
            }
        count = 0;
    }
    private void onNewGame1() {
        ImageView[] imageViews = new ImageView[8];

        // Array of drawable resource IDs
        int[] drawableIds = {
                R.drawable.dog1,
                R.drawable.dog2,
                R.drawable.dog3,
                R.drawable.dog4,
                R.drawable.dog5,
                R.drawable.dog6,
                R.drawable.dog7,
                R.drawable.dog8
        };

        for (int i = 0; i < 8; i++) {
            // Create a new ImageView
            Context context = null;
            ImageView imageView = new ImageView(context);
            // Set the image resource for the ImageView
            imageView.setImageResource(drawableIds[i]);
            // Add the ImageView to the array
            imageViews[i] = imageView;
        }
    }

    public void knock(View view) {
        if (view.getId() == R.id.im_11) {
            ImageView backImageView = findViewById(R.id.im_11);
            backImageView.setImageResource(R.drawable.dog1);
        }
        if (view.getId() == R.id.im_12) {
            ImageView backImageView = findViewById(R.id.im_12);
            backImageView.setImageResource(R.drawable.dog2);
        }
        if (view.getId() == R.id.im_13){
            ImageView backImageView = findViewById(R.id.im_13);
            backImageView.setImageResource(R.drawable.dog3);
        }
        if (view.getId() == R.id.im_14){
            ImageView backImageView = findViewById(R.id.im_14);
            backImageView.setImageResource(R.drawable.dog4);
        }
        if (view.getId() == R.id.im_21){
            ImageView backImageView = findViewById(R.id.im_21);
            backImageView.setImageResource(R.drawable.dog5);
        }
        if (view.getId() == R.id.im_22){
            ImageView backImageView = findViewById(R.id.im_22);
            backImageView.setImageResource(R.drawable.dog6);
        }
        if (view.getId() == R.id.im_23){
            ImageView backImageView = findViewById(R.id.im_23);
            backImageView.setImageResource(R.drawable.dog7);
        }
        if (view.getId() == R.id.im_24){
            ImageView backImageView = findViewById(R.id.im_24);
            backImageView.setImageResource(R.drawable.dog8);
        }
        if (view.getId() == R.id.im_31){
            ImageView backImageView = findViewById(R.id.im_31);
            backImageView.setImageResource(R.drawable.dog1);
        }
        if (view.getId() == R.id.im_32){
            ImageView backImageView = findViewById(R.id.im_32);
            backImageView.setImageResource(R.drawable.dog2);
        }
        if (view.getId() == R.id.im_33){
            ImageView backImageView = findViewById(R.id.im_33);
            backImageView.setImageResource(R.drawable.dog3);
        }
        if (view.getId() == R.id.im_34){
            ImageView backImageView = findViewById(R.id.im_34);
            backImageView.setImageResource(R.drawable.dog4);
        }
        if (view.getId() == R.id.im_41){
            ImageView backImageView = findViewById(R.id.im_41);
            backImageView.setImageResource(R.drawable.dog5);
        }
        if (view.getId() == R.id.im_42){
            ImageView backImageView = findViewById(R.id.im_42);
            backImageView.setImageResource(R.drawable.dog6);
        }
        if (view.getId() == R.id.im_43){
            ImageView backImageView = findViewById(R.id.im_43);
            backImageView.setImageResource(R.drawable.dog7);
        }
        if (view.getId() == R.id.im_44){
            ImageView backImageView = findViewById(R.id.im_44);
            backImageView.setImageResource(R.drawable.dog8);
        }
    }
}
[11:25, 5.1.2024] עדי זופניק: 