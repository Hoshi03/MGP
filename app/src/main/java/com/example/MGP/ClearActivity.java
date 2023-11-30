package com.example.MGP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ClearActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clear);

        // 상태바 및 내비게이션 바 숨기기
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        ImageButton titlebtn = findViewById(R.id.titlebtn);

        titlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClearActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        ImageButton continuebtn = findViewById(R.id.continuebtn);

        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DataManager.getInstance().getBossCount() > 2){
                    Intent intent = new Intent(ClearActivity.this, StartActivity.class);
                    startActivity(intent);
                }

                else if (DataManager.getInstance().getBossCount() == 1){
                    Intent intent = new Intent(ClearActivity.this, PuzzleActivityN1.class);
                    startActivity(intent);
                }

                else if (DataManager.getInstance().getBossCount() == 2){
                    Intent intent = new Intent(ClearActivity.this, PuzzleActivityH1.class);
                    startActivity(intent);
                }
            }
        });


    }
}
