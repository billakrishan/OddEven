package com.example.billak.oddeven;

/**
 * Created by billak on 2017-02-21.
 */

public class Random {
    private int randomNumber;

    public int getRandomNumber(int a, int b){
        return (int)(Math.random()*(b-a)) + a;
    }

}
