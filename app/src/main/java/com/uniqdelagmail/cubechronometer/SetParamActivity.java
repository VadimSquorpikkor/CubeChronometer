package com.uniqdelagmail.cubechronometer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SetParamActivity extends AppCompatActivity {

    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_param);

        editText1 = (EditText) findViewById(R.id.editText1);
    }


    public void saveSecret(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("average", editText1.getText().toString());
        startActivity(intent);
        finish();
    }

}
