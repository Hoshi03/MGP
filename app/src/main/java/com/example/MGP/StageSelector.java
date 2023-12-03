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

        // 액티비티가 시작될 때 기본 음악 파일로 BackgroundMusicService 시작
        startBackgroundMusicService(R.raw.caravan);

        // 상태바 및 내비게이션 바 숨기기
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        ImageButton backbtn = findViewById(R.id.backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StageSelector.this, StartActivity.class);
                startActivity(intent);
            }
        });


        ImageButton stage1btn = findViewById(R.id.stage1btn);
        stage1btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (DataManager.getInstance().isButtonClickable() == true){
                    Intent intent = new Intent(StageSelector.this, PuzzleActivity.class);
                    startActivity(intent);
                }
            }
        });

        ImageButton stage2btn = findViewById(R.id.stage2btn);
        stage2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DataManager.getInstance().isButtonClickable() == true){
                    Intent intent = new Intent(StageSelector.this, PuzzleActivityN1.class);
                    startActivity(intent);
                }
            }
        });

        ImageButton stage3btn = findViewById(R.id.stage3btn);
        stage3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (DataManager.getInstance().isButtonClickable() == true){
                    Intent intent = new Intent(StageSelector.this, PuzzleActivityH1.class);
                    startActivity(intent);
                }

            }
        });
    }


    // 특정 이벤트나 조건 발생 시 호출되는 메서드
    private void changeMusic(int musicResourceId) {
        // 다른 음악 파일로 BackgroundMusicService 호출
        startBackgroundMusicService(R.raw.caravan);
    }

    private void startBackgroundMusicService(int musicResourceId) {
        Intent serviceIntent = new Intent(this, BackgroundMusicService.class);
        serviceIntent.putExtra("caravan", musicResourceId);
        startService(serviceIntent);
    }
}
