package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public final static String RETURN_EXTRA_MESSAGE = "com.example.two-activity.MESSAGE";
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.editText_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }
    public void returnReply(View view) {
        String reply_message = editText.getText().toString();
        Intent intent_reply = new Intent();
        intent_reply.putExtra(RETURN_EXTRA_MESSAGE, reply_message);
        setResult(RESULT_OK,intent_reply);
        finish();
    }
}