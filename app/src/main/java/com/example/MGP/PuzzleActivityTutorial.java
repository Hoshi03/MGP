package com.example.MGP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class PuzzleActivityTutorial extends AppCompatActivity {


    //1-1 스테이지(튜토리얼)
    ImageButton[] blanks = new ImageButton[2];
    ImageButton[] quizzes = new ImageButton[5];
    int temp = 0;   //버튼이 눌려 입력된 문자의 수를 감지하기 위한 변수

    String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 액티비티가 시작될 때 기본 음악 파일로 BackgroundMusicService 시작
        startBackgroundMusicService(R.raw.metalslug_dessert);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_tutorial);
        // 상태바 및 내비게이션 바 숨기기
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        blanks[0] = findViewById(R.id.blank1);
        blanks[1] = findViewById(R.id.blank2);

        quizzes[0] = findViewById(R.id.stage1_quiz1);
        quizzes[1] = findViewById(R.id.stage1_quiz2);
        quizzes[2] = findViewById(R.id.stage1_quiz3);
        quizzes[3] = findViewById(R.id.stage1_quiz4);
        quizzes[4] = findViewById(R.id.stage1_quiz5);


        for (int i = 0; i < quizzes.length; i++) { //낱말 수만큼 반복
            final int index = i;
            quizzes[i].setOnClickListener(new View.OnClickListener() {  //각 낱말들 마다 이벤트 리스너 등록
                @Override
                public void onClick(View v) {
                    int blankIndex = temp % blanks.length;
                    blanks[blankIndex].setImageResource(getResourceIdFromButton(quizzes[index])); //눌리면 getResourceIdFromButton() 시행
                    temp++; //입력된 문자가 1 증가

                    //일단 토스트 메세지를 보내지만 나중에는 클리어시 조건으로 바꿀 예정입니다
                    //버튼이 눌리고 변경된 정답 문자열을 진짜 정답과 비교, 맞으면 토스트 메세지 전달
                    if(answer.equals("겨울")) {
                        DataManager.getInstance().setButtonClickable(true);
                        Intent intent = new Intent(PuzzleActivityTutorial.this, StageSelector.class);
                        startActivity(intent);
                    }


                        //정답을 맞추지 못했으면 문자열 길이가 3 넘는지 확인, 넘는다면 빈칸 비우기
                    else {
                        if (answer.length() >= 2){
                            answer = "";
                            blanks[0].setImageResource(R.drawable.tutorial_answer1);
                            blanks[1].setImageResource(R.drawable.tutorial_answer1);
                            temp = 0;   //입력된 문자의 수 초기화
                        }
                    }
//                    Toast.makeText(PuzzleActivity.this, answer, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private int getResourceIdFromButton(ImageButton button) { //눌린 버튼의 낱말을 정답 문자열에 추가 + 문장 빈칸에 띄우기
        int id = button.getId();
        if (id == R.id.stage1_quiz1) {
            answer += "여";
            return R.drawable.stage1_answer1;
        }
        else if (id == R.id.stage1_quiz2){
            answer += "울";
            return R.drawable.stage1_answer2;
        }
        else if (id == R.id.stage1_quiz3) {
            answer += "가";
            return R.drawable.stage1_answer3;
        }
        else if (id == R.id.stage1_quiz4){
            answer += "겨";
            return R.drawable.stage1_answer4;
        }
        else if (id == R.id.stage1_quiz5){
            answer += "봄";
            return R.drawable.stage1_answer5;
        }
        else return R.drawable.stage1_answer1;
    }

    private void changeMusic() {
        // 다른 음악 파일로 BackgroundMusicService 호출
        startBackgroundMusicService(R.raw.metalslug_dessert);
    }

    private void startBackgroundMusicService(int musicResourceId) {
        Intent serviceIntent = new Intent(this, BackgroundMusicService.class);
        serviceIntent.putExtra("metalslug_dessert", musicResourceId);
        startService(serviceIntent);
    }
}

