package com.dotincorp.dotbraillestudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by jeong-gimgibo on 16. 7. 11..
 */
public class LearnFinishActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_finish);

        Intent intent = getIntent();
        final int langId = intent.getExtras().getInt("langId"); // Main으로부터 넘어온 language ID
        final int count = intent.getExtras().getInt("count"); // 학습한 문자 수
    }

    public void setUI(){

    }
}
