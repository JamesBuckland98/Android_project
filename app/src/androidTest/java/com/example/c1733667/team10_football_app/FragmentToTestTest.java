package com.example.c1733667.team10_football_app;

import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.c1733667.team10_football_app.activities.FragmentToTest;
import com.example.c1733667.team10_football_app.activities.TestActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

/**
 * Created by c1722696 on 5/8/2018.
 */
public class FragmentToTestTest {

    @Rule
    public ActivityTestRule<TestActivity> mActivityTestRule = new ActivityTestRule<TestActivity>(TestActivity.class);

    private TestActivity mActivity = null;



    @Before
    public void setUp() throws Exception{

        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        RelativeLayout rlContainer = (RelativeLayout) mActivity.findViewById(R.id.test_container);

        FragmentToTest fragment = new FragmentToTest();

        assertNotNull(rlContainer);

        mActivity.getFragmentManager().beginTransaction().add(rlContainer.getId(), fragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();

        View view = fragment.getView().findViewById(R.id.view_in_fragment);

        assertNotNull(view);

        //test if fragment is launched or not
    }

    @After
    public void tearDown() throws Exception{

        mActivity = null;
        mActivity = null;

    }

}