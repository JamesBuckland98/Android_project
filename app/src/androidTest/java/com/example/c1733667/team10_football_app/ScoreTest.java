package com.example.c1733667.team10_football_app;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import com.example.c1733667.team10_football_app.activities.Score;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by c1621693 on 5/22/2018.
 */
public class ScoreTest {
    @Rule
    public ActivityTestRule<Score> mActivityTestRule = new ActivityTestRule<>(Score.class);

    private Score mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Score.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }
    @Test
    public void testLounchShareFuction()
    {
        assertNotNull(mActivity.findViewById(R.id.btnShare));

        onView(withId(R.id.btnShare)).perform(click());
    }

    @After
    public void tearDown() throws Exception {

        mActivity = null ;
    }

}