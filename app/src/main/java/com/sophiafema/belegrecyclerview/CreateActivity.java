package com.sophiafema.belegrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.roomwordssample.REPLY";
    private EditText mEditProductnameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        mEditProductnameView = findViewById(R.id.edt_produktname_create);

        final Button saveButton = findViewById(R.id.btn_save_create);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(mEditProductnameView.getText()))
                {
                    setResult(RESULT_CANCELED, replyIntent);
                }
                else
                {
                    String productname = mEditProductnameView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, productname);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }
}
