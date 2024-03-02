package com.example.sinoca;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int SStavka;
    public int answ;
    public int pol = 1;
    public int x = 2;
    public int balance = 10000;;
    public TextView bal;
    private TextView xx;
    public int balll;
    private CheckBox r;
    private CheckBox g;
    private CheckBox b;

    private EditText stavka;
    public Random random = new Random();
    private Button bet;
    public int xx1;
    public static final int MENU_QUIT_ID = 1;
    public static final int MENU_RESET_ID = 2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bal = findViewById(R.id.balance);
        xx = findViewById(R.id.xx);
        r = findViewById(R.id.redd);
        g = findViewById(R.id.greenn);
        b = findViewById(R.id.blackk);
        stavka = findViewById(R.id.stavka);
        bet = findViewById(R.id.bettt);
        Intent intent = getIntent();
        balll = intent.getIntExtra("balan12", balance);
        xx1 = intent.getIntExtra("xx1", x);
        xx.setText(xx1 + "X");
        if(balll <=0){
            Toast.makeText(this, "you have run out of funds. best wishes", Toast.LENGTH_SHORT).show();
            finish();
        }
        bal.setText("Balance:"+balll);
        r.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b.setChecked(false);
                    g.setChecked(false);
                    answ = 1;
                }
            }
        });

        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    r.setChecked(false);
                    g.setChecked(false);
                    answ = 2;
                }
            }
        });

        g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b.setChecked(false);
                    r.setChecked(false);
                    answ = 3;
                }
            }
        });
    }


    public void onClick(View view) {
        if (!r.isChecked() && !g.isChecked() && !b.isChecked()) {
            Toast.makeText(this, "Choose color.", Toast.LENGTH_SHORT).show();
        }
        else{
            try {
                SStavka =  Integer.parseInt(String.valueOf(stavka.getText()));
                if(SStavka> balll || SStavka <=0 ){
                    Toast.makeText(this, "insufficient funds or value less than zero.", Toast.LENGTH_SHORT).show();
                }
                else {
                    int rnd = random.nextInt(3)+1;
                    if(rnd == answ){
                        pol = 1;
                        balance = balance + (SStavka*xx1);
                        bal.setText("Balance:"+balance);
                    }
                    else {
                        pol = 0;
                        balance = balance - SStavka;
                        bal.setText("Balance:"+balance);
                    }
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("poll", pol);
                    intent.putExtra("stav", SStavka);
                    intent.putExtra("balan", balance);
                    intent.putExtra("stavv", SStavka*2);
                    startActivity(intent);
                }

            }catch (Exception e){
                Toast.makeText(this, "No values.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,MENU_RESET_ID,0,"Change multiplier");
        menu.add(0,MENU_QUIT_ID,0,"Quit");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_QUIT_ID:
                finish();
                break;
            case MENU_RESET_ID:
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("xx1", x);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}