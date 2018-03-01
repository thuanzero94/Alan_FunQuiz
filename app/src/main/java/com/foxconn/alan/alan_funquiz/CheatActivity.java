package com.foxconn.alan.alan_funquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String TAG = CheatActivity.class.getSimpleName();

    private static final String EXTRA_ANSWER_IS_TRUE = "com.foxconn.alan.alan_funquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.foxconn.alan.alan_funquiz.answer_shown";
    private static final String KEY_INDEX = "index";
    private static final String EXTRA_IS_CHEATER = "com.foxconn.alan.alan_funquiz.is_cheater";

    private boolean mAnswerIsTrue;

    private Button mBtnShowAnswer;
    private TextView mTextAnswer;

    private boolean mIsCheater = false;

    public static Intent newIntent (Context packageContext, boolean answerIsTrue, boolean isCheater){
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        i.putExtra(EXTRA_IS_CHEATER, isCheater);
        return i;
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mIsCheater = getIntent().getBooleanExtra(EXTRA_IS_CHEATER, false);

        mTextAnswer = (TextView) findViewById(R.id.Text_answer);
        mBtnShowAnswer = (Button) findViewById(R.id.Btn_showAnswer);

        if (savedInstanceState != null){
            mIsCheater = savedInstanceState.getBoolean(KEY_INDEX, false);
            setAnswerShownResult(mIsCheater);
        }

        setOnClickListener();
    }

    private void setOnClickListener(){
        mBtnShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue){
                    mTextAnswer.setText(R.string.true_button);
                } else {
                    mTextAnswer.setText(R.string.false_button);
                }
                mIsCheater = true;
                setAnswerShownResult(mIsCheater);
            }
        });
    }

    private boolean setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
        return isAnswerShown;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY_INDEX, mIsCheater);
    }

}
