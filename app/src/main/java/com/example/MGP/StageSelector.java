package com.example.MGP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StageSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_selector);

        // 상태바 및 내비게이션 바 숨기기
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        ImageButton stage1btn = findViewById(R.id.stage1btn);
        stage1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // "Start Game" 버튼 클릭 시, 인게임 액티비티로 이동
                Intent intent = new Intent(StageSelector.this, PuzzleActivity.class);
                startActivity(intent);
            }
        });

        ImageButton stage2btn = findViewById(R.id.stage2btn);
        stage2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // "Start Game" 버튼 클릭 시, 인게임 액티비티로 이동
                Intent intent = new Intent(StageSelector.this, PuzzleActivityN1.class);
                startActivity(intent);
            }
        });

        ImageButton stage3btn = findViewById(R.id.stage3btn);
        stage3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StageSelector.this, PuzzleActivityH1.class);
                startActivity(intent);
            }
        });
    }
}
