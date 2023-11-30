package com.example.MGP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MGP.PuzzleActivity;
import com.example.MGP.R;

public class PuzzleActivityEBoss extends AppCompatActivity {
// 1-보스 스테이지

    static int life = 3;

    ImageButton[] blanks = new ImageButton[3];
    ImageButton[] quizzes = new ImageButton[9];
    int temp = 0;   //버튼이 눌려 입력된 문자의 수를 감지하기 위한 변수

    String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzleboss1);
        // 상태바 및 내비게이션 바 숨기기
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        blanks[0] = findViewById(R.id.blank1);
        blanks[1] = findViewById(R.id.blank2);
        blanks[2] = findViewById(R.id.blank3);

        quizzes[0] = findViewById(R.id.boss1_quiz1);
        quizzes[1] = findViewById(R.id.boss1_quiz2);
        quizzes[2] = findViewById(R.id.boss1_quiz3);
        quizzes[3] = findViewById(R.id.boss1_quiz4);
        quizzes[4] = findViewById(R.id.boss1_quiz5);
        quizzes[5] = findViewById(R.id.boss1_quiz6);
        quizzes[6] = findViewById(R.id.boss1_quiz7);
        quizzes[7] = findViewById(R.id.boss1_quiz8);
        quizzes[8] = findViewById(R.id.boss1_quiz9);

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
                    if(answer.equals("윷놀이")) {
                        DataManager.getInstance().setBossCount();
                        Intent intent = new Intent(PuzzleActivityEBoss.this, ClearActivity.class);
                        startActivity(intent);
                    }

                        //정답을 맞추지 못했으면 문자열 길이가 3 넘는지 확인, 넘는다면 빈칸 비우기
                    else {
                        if (answer.length() >= 3){
                            life --;
                            if (life <= 0){
                                Intent intent = new Intent(PuzzleActivityEBoss.this, StartActivity.class);
                                startActivity(intent);
                            }
                            answer = "";
                            blanks[0].setImageResource(R.drawable.tutorial_answer1);
                            blanks[1].setImageResource(R.drawable.tutorial_answer1);
                            blanks[2].setImageResource(R.drawable.tutorial_answer1);
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
        if (id == R.id.boss1_quiz1) {
            answer += "집";
            return R.drawable.boss1_answer1;
        }
        else if (id == R.id.boss1_quiz2){
            answer += "차";
            return R.drawable.boss1_answer2;
        }
        else if (id == R.id.boss1_quiz3) {
            answer += "래";
            return R.drawable.boss1_answer3;
        }
        else if (id == R.id.boss1_quiz4){
            answer += "놀";
            return R.drawable.boss1_answer4;
        }
        else if (id == R.id.boss1_quiz5){
            answer += "이";
            return R.drawable.boss1_answer5;
        }
        else if (id == R.id.boss1_quiz6){
            answer += "슬";
            return R.drawable.boss1_answer6;
        }
        else if (id == R.id.boss1_quiz7){
            answer += "기";
            return R.drawable.boss1_answer7;
        }
        else if (id == R.id.boss1_quiz8){
            answer += "윷";
            return R.drawable.boss1_answer8;
        }
        else if (id == R.id.boss1_quiz9){
            answer += "제";
            return R.drawable.boss1_answer9;
        }
        else return R.drawable.boss1_answer1;
    }
}







