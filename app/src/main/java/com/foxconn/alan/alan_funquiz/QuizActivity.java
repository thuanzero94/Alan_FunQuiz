package com.foxconn.alan.alan_funquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends AppCompatActivity {
    private static final String TAG = QuizActivity.class.getSimpleName();

    private Button mBtnTrue;
    private Button mBtnFalse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mBtnTrue = (Button) findViewById(R.id.Btn_true);
        mBtnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do nothings
            }
        });

        mBtnFalse = (Button) findViewById(R.id.Btn_false);
        mBtnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do nothings
            }
        });
    }
}
