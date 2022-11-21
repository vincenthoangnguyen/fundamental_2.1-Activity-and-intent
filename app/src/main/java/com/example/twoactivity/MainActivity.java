package com.example.twoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.two-activity.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private final static String LOG_TAG =
            MainActivity.class.getSimpleName();
    private TextView mReplyHeaderTv;
    private TextView mReplyMessageTv;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeaderTv = findViewById(R.id.text_reply_header);
        mReplyMessageTv = findViewById(R.id.text_reply_message);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked");
        Intent intent = new Intent(this, SecondActivity.class);

        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent,TEXT_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                assert data != null;
                String message_reply = data.getStringExtra(SecondActivity.RETURN_EXTRA_MESSAGE);
                mReplyHeaderTv.setVisibility(View.VISIBLE);
                mReplyMessageTv.setText(message_reply);
                mReplyMessageTv.setVisibility(View.VISIBLE);
            }
        }
    }
}