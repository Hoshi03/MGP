package com.example.MGP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MGP.PuzzleActivity;
import com.example.MGP.R;

public class PuzzleActivityNBoss extends AppCompatActivity {
// 2-보스 스테이지

    ImageButton[] blanks = new ImageButton[2];
    ImageButton[] quizzes = new ImageButton[10];
    int temp = 0;   //버튼이 눌려 입력된 문자의 수를 감지하기 위한 변수

    String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzleboss2);
        // 상태바 및 내비게이션 바 숨기기
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        blanks[0] = findViewById(R.id.blank1);
        blanks[1] = findViewById(R.id.blank2);


        quizzes[0] = findViewById(R.id.boss2_quiz1);
        quizzes[1] = findViewById(R.id.boss2_quiz2);
        quizzes[2] = findViewById(R.id.boss2_quiz3);
        quizzes[3] = findViewById(R.id.boss2_quiz4);
        quizzes[4] = findViewById(R.id.boss2_quiz5);
        quizzes[5] = findViewById(R.id.boss2_quiz6);
        quizzes[6] = findViewById(R.id.boss2_quiz7);
        quizzes[7] = findViewById(R.id.boss2_quiz8);
        quizzes[8] = findViewById(R.id.boss2_quiz9);
        quizzes[9] = findViewById(R.id.boss2_quiz10);


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
                    if(answer.equals("인과")) {
                        Intent intent = new Intent(PuzzleActivityNBoss.this, PuzzleActivityH1.class);
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
        if (id == R.id.boss2_quiz1) {
            answer += "시";
            return R.drawable.boss2_answer1;
        }
        else if (id == R.id.boss2_quiz2){
            answer += "조";
            return R.drawable.boss2_answer2;
        }
        else if (id == R.id.boss2_quiz3) {
            answer += "의";
            return R.drawable.boss2_answer3;
        }
        else if (id == R.id.boss2_quiz4){
            answer += "정";
            return R.drawable.boss2_answer4;
        }
        else if (id == R.id.boss2_quiz5){
            answer += "과";
            return R.drawable.boss2_answer5;
        }
        else if (id == R.id.boss2_quiz6){
            answer += "석";
            return R.drawable.boss2_answer6;
        }
        else if (id == R.id.boss2_quiz7){
            answer += "인";
            return R.drawable.boss2_answer7;
        }
        else if (id == R.id.boss2_quiz8){
            answer += "분";
            return R.drawable.boss2_answer8;
        }
        else if (id == R.id.boss2_quiz9){
            answer += "예";
            return R.drawable.boss2_answer9;
        }
        else if (id == R.id.boss2_quiz10){
            answer += "대";
            return R.drawable.boss2_answer10;
        }
        else return R.drawable.boss2_answer1;
    }
}










