package com.example.billak.oddeven;


import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Score {
    private String batsmanName="";
    private int totalScore;
    private ArrayList<String> ScoreList;
    private int totalBalls;
    private BigDecimal totalOvers;


    public Score(){
        ScoreList = new ArrayList<String>();
        totalScore=0;
        totalBalls=0;
        totalOvers=new BigDecimal("0");

    }
    public void setBatsmanName(String batsmanName){
        batsmanName=this.batsmanName;
    }
    public void addBallToOver(){


        BigDecimal increment = new BigDecimal("0.1");
        totalOvers=totalOvers.add(increment);
    }

    public void setTotalOvers(double totalOvers){
        this.totalOvers=new BigDecimal(Double.toString(totalOvers));
    }
    public BigDecimal getTotalOvers(){
        return totalOvers;
    }
    public void addBall(){
        totalBalls+=1;
    }


    public int getTotalBalls(){
        return totalBalls;
    }

    public int getTotalScore(){
        calculateTotalScore();
        return totalScore;
    }
    public void addScore(int score){

        ScoreList.add(Integer.toString(score));

    }
    private void calculateTotalScore(){
        int tempScore=0;
        for(String x : ScoreList){
            tempScore+=Integer.parseInt(x);
        }
        totalScore=tempScore;
    }
    public void addScoreToFile(){
        File file=new File("data.dat");
        /**
        try {
            PrintWriter write = new PrintWriter(file);
            for (String str:ScoreList
                 ) {
                write.append(str+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         **/
    }

    public String toString(){
        return batsmanName+" Scored "+totalScore+" runs in "+totalBalls+" balls";
    }
public void reset(){
    batsmanName="";
    ScoreList = new ArrayList<String>();
    totalScore=0;
    totalBalls=0;
    totalOvers=new BigDecimal("0");
}
}
