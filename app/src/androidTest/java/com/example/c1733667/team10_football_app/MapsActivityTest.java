package com.example.c1733667.team10_football_app;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import com.example.c1733667.team10_football_app.activities.MapsActivity;
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
public class MapsActivityTest {
    @Rule
    public ActivityTestRule<MapsActivity> mActivityTestRule = new ActivityTestRule<>(MapsActivity.class);

    private MapsActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MapsActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }
    @Test
    public void testLounchShareFuction()
    {
        assertNotNull(mActivity.findViewById(R.id.share));

        onView(withId(R.id.share)).perform(click());
    }

    @After
    public void tearDown() throws Exception {

        mActivity = null ;
    }

}