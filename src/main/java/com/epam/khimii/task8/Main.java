package com.epam.khimii.task8;

import com.epam.khimii.task8.searchingByteSequence.FindSequence;
import com.epam.khimii.task8.searchingSimpleNumbers.FindInRange;

public class Main {
    public static void main(String[] args) {
        //first part of task8
      /* FindInRange findInRange = new FindInRange();
        try {
            findInRange.start();
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //second part of task8
        FindSequence findSequence = new FindSequence();
        findSequence.findSequence();
    }
}