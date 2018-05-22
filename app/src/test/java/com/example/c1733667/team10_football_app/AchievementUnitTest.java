package com.example.c1733667.team10_football_app;

import android.widget.ProgressBar;

import com.example.c1733667.team10_football_app.classpack.AchievementClass;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by c1733667 on 12/05/2018.
 */
public class AchievementUnitTest {
    String name;
    int targetNumber;
    AchievementClass achievementClass;
    ProgressBar progressBar;

    @Before
    public void initialValues() {
        name = "achievement";
        targetNumber = 5;
    }

    @Test
    public void AchievementUnlockedTest() throws Exception {
        achievementClass = new AchievementClass(name, targetNumber, 5);
        assertEquals(true, achievementClass.unlocked());
    }

    @Test
    public void AchievementLockedTest() throws Exception {
        achievementClass = new AchievementClass(name, targetNumber, 3);
        assertEquals(false, achievementClass.unlocked());
    }

    @Test
    public void GetAchievementNameTest() throws Exception {
        achievementClass = new AchievementClass(name, targetNumber, 5);
        assertEquals("achievement", achievementClass.getName());
    }

    @Test
    public void setNameTest() throws Exception {
        achievementClass = new AchievementClass(name, targetNumber, 4);
        String result = achievementClass.setName("foobar");
        assertEquals("foobar", result);
    }

    @Test
    public void setTargetNumberTest() throws Exception {
        achievementClass = new AchievementClass(name, targetNumber, 3);
        int result = achievementClass.setTargetNumber(3);
        assertEquals(3, result);
    }

    @Test
    public void setActualNumberTest() throws Exception {
        achievementClass = new AchievementClass(name, targetNumber, 6);
        int result = achievementClass.setActualNumber(2);
        assertEquals(2, result);
    }
}
