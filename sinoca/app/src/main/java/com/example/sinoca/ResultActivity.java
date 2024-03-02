package com.example.sinoca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tx;
    private Button bt;
    public int pol1;
    public int stav1;
    public int stavv1;
    public int balan1;
    private LinearLayout ll;
    private Vibrator vibraton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        bt = findViewById(R.id.button1);
        vibraton = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        tx = findViewById(R.id.asnwer);
        ll = findViewById(R.id.lay0);
        Intent intent = getIntent();
        int pol1 = intent.getIntExtra("poll", -1);
        balan1 = intent.getIntExtra("balan",-1);
        int stav1 = intent.getIntExtra("stav", -1);
        int stavv1 = intent.getIntExtra("stavv", -1);
        if(pol1 ==1){
            tx.setText("You Won!"+"\n"+"+"+stavv1);
            vibraton.vibrate(100);
        } else if (pol1 == 0) {
            tx.setText("You Lose!"+"\n"+"-"+stav1);
            vibraton.vibrate(100);
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        intent.putExtra("balan12", balan1);
        startActivity(intent);
    }
}