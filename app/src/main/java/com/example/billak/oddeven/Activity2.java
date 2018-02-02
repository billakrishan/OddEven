
package com.example.billak.oddeven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {
    private TextView declareOut;

    private TextView finalScore;
    private Button btnnextBatsman;
    private Button btnExit;
    private TextView batsmanList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        declareOut = (TextView) findViewById(R.id.declareOut);

        finalScore = (TextView) findViewById(R.id.finalScoreC);

        Intent intent = getIntent();
        String finalScoreC = intent.getStringExtra(MainActivity.MY_VALUE);

        finalScore.setText("You Scored " + finalScoreC + " Runs");

        btnnextBatsman = (Button) findViewById(R.id.nextBatsman);
        btnExit = (Button) findViewById(R.id.Exit);

        btnnextBatsman.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          nextBatsman();
                                      }
                                  }
        );

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });

        batsmanList=(TextView)findViewById(R.id.batsmanList);
        batsmanList.setText(BatsmanList.printList());
    }


    private void nextBatsman() {
        finish();
    }

    private void exit(){
        //Toast.makeText(Activity2.this,"Thankyou!...",Toast.LENGTH_SHORT).show();
        finish();
        System.exit(0);
    }
}