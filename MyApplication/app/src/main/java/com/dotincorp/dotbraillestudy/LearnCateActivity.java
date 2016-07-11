package com.dotincorp.dotbraillestudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by jeong-gimgibo on 16. 7. 11..
 */
public class LearnCateActivity extends Activity {

    public static final String[][] CATE_STR_ARRAY
            = {{"자음 첫소리","자음 받침","모음","약자,약어","숫자,연산","문장부호"},
            {"Consonant","vowel","Abbreviation","number,calculate","Punctuation"},
            {"حرف ساكن","حرف متحرك","الاختصار","عدد","ترقيم"}}; // 버튼 글자
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

        Button btn[] = new Button[CATE_STR_ARRAY[langId].length];
        for(int i = 0 ; i <CATE_STR_ARRAY[langId].length ; i++){
            btn[i] = new Button(this);
            btn[i].setText(CATE_STR_ARRAY[langId][i]);
            btn[i].setWidth(BTN_WIDTH);
            btn[i].setTextSize(BTN_TEXT_SIZE);
            btn[i].setId(i);
            layout.addView(btn[i]);
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 클릭 이벤트 동작 확인
                    //Toast.makeText(MenuActivity.this,view.getId()+"",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LearnActivity.class);
                    intent.putExtra("langId", langId);
                    intent.putExtra("cateId", view.getId());
                    startActivity(intent);
                }
            });

        }
    }
}
