package me.supersimplelifts.drycowmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText numCows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numCows = (EditText)findViewById(R.id.editText);
    }

    public void onGo(View v) {
        int value = Integer.parseInt(numCows.getText().toString());

        Intent intent = new Intent(this, CalculatedActivity.class);
        intent.putExtra("numCows", value);
        startActivity(intent);
    }
}
