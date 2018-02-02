package com.example.billak.oddeven;

import java.util.ArrayList;

/**
 * Created by billak on 2017-05-09.
 */

public class BatsmanList {

    private static ArrayList<String> batsmanList=new ArrayList<String>();


    public static void addtobatsmanList(String batsmanEntry){
        batsmanList.add(batsmanEntry);
    }

    public static String printList(){
        String list="";
        for(String entry:batsmanList){
            list+=entry+"\n";
        }
        return list;
    }

}
