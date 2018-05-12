package com.example.c1733667.team10_football_app;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.c1733667.team10_football_app.activities.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by c1722696 on 5/8/2018.
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =  new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity = mainActivityActivityTestRule.getActivity();

    }

    @Test
    public void testLauncg(){
        View view = mActivity.findViewById(R.id.btnStadium);

        assertNotNull(view);
    }


    @After
    public void tearDown() throws Exception {

        mActivity = null;

    }

}