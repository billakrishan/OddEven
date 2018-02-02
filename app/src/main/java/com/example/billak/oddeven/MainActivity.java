package com.example.billak.oddeven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    public static final String MY_VALUE="VALUE";
    private EditText txtOne;
    private EditText txtTwo;
    private Button btnOne;
    private TextView totalBalls;
    private TextView totalScore;
    private TextView totalOvers;
    private Score score;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtOne=(EditText)findViewById(R.id.edittxtOne);
        txtTwo=(EditText)findViewById(R.id.edittxtTwo);
         btnOne = (Button) findViewById(R.id.btnOne);
        totalScore=(TextView)findViewById(R.id.totalScoreC);
        totalBalls=(TextView)findViewById(R.id.totalBallsC);
        totalOvers=(TextView)findViewById(R.id.totalOversC);

        btnOne.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          hitScore();
                                      }
                                  }

        );
        score=new Score();


    }

    @Override
    public void onResume(){
        super.onResume();
        txtOne.clearComposingText();
        txtTwo.clearComposingText();
        txtTwo.setVisibility(View.INVISIBLE);
        score.reset();
        DisplayScore(score);

    }
public  void hitScore(){
    int user_score=Integer.parseInt(txtOne.getText().toString());
    int machine_score=genMachineScore();
    txtTwo.setVisibility(View.VISIBLE);
    txtTwo.setText(Integer.toString(machine_score));
    txtTwo.setEnabled(false);


    if(checkScore(user_score,machine_score).equals("notOut")){
            score.addScore(user_score);
        Toast.makeText(MainActivity.this,"Score Added\nNextTurn",Toast.LENGTH_SHORT).show();

    }else{
        Toast.makeText(MainActivity.this,"You are Out!",Toast.LENGTH_SHORT).show();
        BatsmanList.addtobatsmanList(score.toString());

        declareOut();
    }


    score.addBall();
    score.addBallToOver();

    if(score.getTotalBalls()% 6 == 0 ){
        score.setTotalOvers(Math.round(score.getTotalOvers().doubleValue()));
    }




    DisplayScore(score);


}

    public int genMachineScore(){
        Random random= new Random();
        int machine_score=random.getRandomNumber(1,10);

        return machine_score;
    }
    public String checkScore(int user_score,int machine_score){
        if(user_score != machine_score) return "notOut";
        else return "Out";
    }
    public void DisplayScore(Score score){
        totalBalls.setText(Integer.toString(score.getTotalBalls()));
        totalScore.setText(Integer.toString(score.getTotalScore()));
        totalOvers.setText(Double.toString((score.getTotalOvers().doubleValue())));

    }

    public void declareOut(){
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(MY_VALUE,Integer.toString(Math.round(score.getTotalScore())));
        startActivity(intent);

    }


}
