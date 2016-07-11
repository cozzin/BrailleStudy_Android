package com.dotincorp.dotbraillestudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String[] LANG_STR_ARRAY = {"한국어","English","العربية"}; // 버튼 글자
    public static final int BTN_WIDTH = 66; // 버튼 가로
    public static final int BTN_TEXT_SIZE = 11; // 버튼 글자 크기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton();
    }

    // 언어 선택 버튼 생성
    public void createButton(){
        LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);

        Button btn[] = new Button[LANG_STR_ARRAY.length];
        for(int i = 0 ; i <LANG_STR_ARRAY.length ; i++){
            btn[i] = new Button(this);
            btn[i].setText(LANG_STR_ARRAY[i]);
            btn[i].setWidth(BTN_WIDTH);
            btn[i].setTextSize(BTN_TEXT_SIZE);
            btn[i].setId(i);
            layout.addView(btn[i]);
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 클릭 이벤트 동작 확인
                    //Toast.makeText(MainActivity.this,view.getId()+"",Toast.LENGTH_SHORT).show();

                    // 데이터 전달
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("langId", view.getId());
                    startActivity(intent);
                }
            });
        }
    }
}
