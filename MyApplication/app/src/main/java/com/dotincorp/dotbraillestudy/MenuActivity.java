package com.dotincorp.dotbraillestudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by jeong-gimgibo on 16. 7. 11..
 */
public class MenuActivity extends Activity {

    public static final String[][] LANG_STR_ARRAY
            = {{"점자 배우기","점자 연습하기","진도 확인"},
            {"Learn Braille","Practice Braille","Check Progress"},
            {"تعلم","ممارسة","الاختيار التقدم"}}; // 버튼 글자
    public static final int BTN_WIDTH = 66; // 버튼 가로
    public static final int BTN_TEXT_SIZE = 11; // 버튼 글자 크기


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton();
    }

    // 메뉴 버튼 생성
    public void createButton(){
        LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);

        Intent intent = getIntent();
        final int langId = intent.getExtras().getInt("langId"); // Main으로부터 넘어온 language ID

        Button btn[] = new Button[LANG_STR_ARRAY[langId].length];
        for(int i = 0 ; i <LANG_STR_ARRAY[langId].length ; i++){
            btn[i] = new Button(this);
            btn[i].setText(LANG_STR_ARRAY[langId][i]);
            btn[i].setWidth(BTN_WIDTH);
            btn[i].setTextSize(BTN_TEXT_SIZE);
            btn[i].setId(i);
            layout.addView(btn[i]);
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 클릭 이벤트 동작 확인
                    //Toast.makeText(MenuActivity.this,view.getId()+"",Toast.LENGTH_SHORT).show();
                    switch (view.getId()){
                        case 0: // 점자 배우기
                            // 데이터 전달
                            Intent intent = new Intent(getApplicationContext(), LearnCateActivity.class);
                            intent.putExtra("langId", langId);
                            startActivity(intent);
                            break;
                    }
                }
            });
        }
    }
}
