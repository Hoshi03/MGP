package com.example.MGP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // 상태바 및 내비게이션 바 숨기기
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        ImageButton startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // "Start Game" 버튼 클릭 시, 인게임 액티비티로 이동
                Intent intent = new Intent(StartActivity.this, PuzzleActivityTutorial.class);
                startActivity(intent);
            }
        });

        ImageButton stageButton = findViewById(R.id.stageButton);
        stageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // "Start Game" 버튼 클릭 시, 인게임 액티비티로 이동
                Intent intent = new Intent(StartActivity.this, StageSelector.class);
                startActivity(intent);
            }
        });
    }
}