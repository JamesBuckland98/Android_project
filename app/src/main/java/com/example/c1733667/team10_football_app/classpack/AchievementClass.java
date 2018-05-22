package com.example.c1733667.team10_football_app.classpack;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

/**
 * Created by c1733667 on 12/04/2018.
 */

public class AchievementClass {
    private String name;
    private Integer targetNumber;
    private Integer actualNumber;
    private ProgressBar progressBar;

    public AchievementClass(String name, Integer targetNumber, Integer actualNumber) {
        this.name = name;
        this.targetNumber = targetNumber;
        this.actualNumber = actualNumber;
    }
    public boolean unlocked(){
        if (targetNumber > actualNumber){
            return false;
        }else{
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public Integer getTargetNumber() {
        return targetNumber;
    }

    public int setTargetNumber(Integer targetNumber) {
        this.targetNumber = targetNumber;
        return targetNumber;
    }

    public Integer getActualNumber() {
        return actualNumber;
    }

    public int setActualNumber(Integer actualNumber) {
        this.actualNumber = actualNumber;
        return actualNumber;
    }

    public void createProgessBar(ProgressBar progressBar){
        Log.d("actual number", String.valueOf(actualNumber));
        Log.d("target number", String.valueOf(targetNumber));
        ObjectAnimator anim =ObjectAnimator.ofInt(progressBar, "progress", 0, (actualNumber*100)/targetNumber);
        anim.setDuration(850);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
    }
}
