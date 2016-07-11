package com.dotincorp.dotbraillestudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by jeong-gimgibo on 16. 7. 11..
 */
public class LearnActivity extends Activity {


    public static final String[] BTN_STR_ARRAY = {"확인","check answer",""}; // 버튼 글자
    public static final String[] BTN_FIN_STR_ARRAY = {"종료","finish",""}; // 버튼 글자
    public static final String[][] QUESTION_ARRAY = {{"가","나","다"},{"A","B","C"},{"أ","ب","ت"}};
    public static final int BTN_WIDTH = 66; // 버튼 가로
    public static final int BTN_TEXT_SIZE = 11; // 버튼 글자 크기
    public static int index;
    public static int langId;
    public static Button answerBtn;
    public static TextView questionText;
    public static View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        setDefault();
        setUI();
    }

    public void setDefault(){
        index = 0;
        Intent intent = getIntent();
        langId = intent.getExtras().getInt("langId"); // Main으로부터 넘어온 language ID
    }


    public void setUI(){
        view = findViewById(R.id.learn_layout);
        answerBtn = (Button) findViewById(R.id.answerBtn);
        answerBtn.setText(BTN_STR_ARRAY[langId]);
        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuestion();
            }
        });
        questionText = (TextView) findViewById(R.id.questText);
        questionText.setText(QUESTION_ARRAY[langId][index]);
    }

    // 다음 문자 호출
    public void nextQuestion(){


        if( index < (QUESTION_ARRAY[langId].length-1) ){ // 다음 문자
            index++;
            questionText.setText(QUESTION_ARRAY[langId][index]);
            if(index > (QUESTION_ARRAY[langId].length-2)){
                answerBtn.setText(BTN_FIN_STR_ARRAY[langId]);
            }
            view.invalidate();
        }
        else
        { // 교육 종료
            // 데이터 전달
            Intent intent = new Intent(getApplicationContext(), LearnFinishActivity.class);
            intent.putExtra("langId", langId);
            intent.putExtra("count", index);
            startActivity(intent);
            finish();
        }

    }

}
