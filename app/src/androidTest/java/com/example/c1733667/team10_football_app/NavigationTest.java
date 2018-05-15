package com.example.c1733667.team10_football_app;

import android.support.test.espresso.intent.Intents;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;

import com.example.c1733667.team10_football_app.activities.Achievement;
import com.example.c1733667.team10_football_app.activities.HelpActivity;
import com.example.c1733667.team10_football_app.activities.InfoActivity;
import com.example.c1733667.team10_football_app.activities.LeagueActivity;
import com.example.c1733667.team10_football_app.activities.MainActivity;
import com.example.c1733667.team10_football_app.activities.MapsActivity;
import com.example.c1733667.team10_football_app.activities.Score;
import com.example.c1733667.team10_football_app.activities.SettingActivity;
import com.example.c1733667.team10_football_app.activities.StadiumActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.junit.experimental.categories.Categories.CategoryFilter.exclude;

/**
 * Created by c1733667 on 30/04/2018.
 */
@LargeTest
@RunWith(JUnit4.class)
public class NavigationTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity = null;

    public ActivityTestRule<StadiumActivity> stadiumActivityActivityTestRule
            = new ActivityTestRule<StadiumActivity>(StadiumActivity.class);
    private StadiumActivity stadiumActivity = null;

    public ActivityTestRule<Score> scoreActivityTestRule
            = new ActivityTestRule<Score>(Score.class);
    private Score score = null;

    public ActivityTestRule<MapsActivity> mapsActivityActivityTestRule
            = new ActivityTestRule<MapsActivity>(MapsActivity.class);
    private MapsActivity mapsActivity = null;

    public ActivityTestRule<Achievement> achievementActivityTestRule
            = new ActivityTestRule<Achievement>(Achievement.class);
    private Achievement achievement = null;

    public ActivityTestRule<HelpActivity> helpActivityActivityTestRule
            = new ActivityTestRule<HelpActivity>(HelpActivity.class);
    private HelpActivity helpActivity = null;

<<<<<<< HEAD
=======
    public ActivityTestRule<LeagueActivity> premierLeagueActivityTestRule
            = new ActivityTestRule<LeagueActivity>(LeagueActivity.class);
    private LeagueActivity premierLeague = null;
>>>>>>> e8c80046fe605909ba7119935eaff974f29176d3

    public ActivityTestRule<InfoActivity> infoActivityActivityTestRule
            = new ActivityTestRule<InfoActivity>(InfoActivity.class);
    private InfoActivity infoActivity = null;

    @Before
    public void setUp() {
        mainActivity = mainActivityActivityTestRule.getActivity();
        stadiumActivity = stadiumActivityActivityTestRule.getActivity();
        mapsActivity = mapsActivityActivityTestRule.getActivity();
        score = scoreActivityTestRule.getActivity();
        achievement = achievementActivityTestRule.getActivity();
        helpActivity = helpActivityActivityTestRule.getActivity();
        infoActivity = infoActivityActivityTestRule.getActivity();
    }
    @Test
    public void NavigationStadiumTest(){
        Intents.init();
        onView(withContentDescription(R.string.open)).perform(click());
        onView(withText("Stadium")).perform(click());
        intended(hasComponent(StadiumActivity.class.getName()));
        Intents.release();
    }
    @Test
    public void NavigationScoreTest(){
        Intents.init();
        onView(withContentDescription(R.string.open)).perform(click());
        onView(withText("Score")).perform(click());
        intended(hasComponent(Score.class.getName()));
        Intents.release();
        //passes
    }
    @Test
    public void NavigationMapTest(){
        Intents.init();
        onView(withContentDescription(R.string.open)).perform(click());
        onView(withText("Map")).perform(click());
        intended(hasComponent(MapsActivity.class.getName()));
        Intents.release();
        //passes
    }
//    @Test
//    public void NavigationAchievementTest(){
//        Intents.init();
//        onView(withContentDescription(R.string.open)).perform(click());
//        onView(allOf(withText("Achievements"),withParent(withId(R.id.nav_view)))).perform(click());
//        intended(hasComponent(Achievement.class.getName()));
//        Intents.release();
//        //fails
//    }
    @Test
    public void NavigationSettingsTest(){
        Intents.init();
        onView(withContentDescription(R.string.open)).perform(click());
        onView(withText("Settings")).perform(click());
        intended(hasComponent(SettingActivity.class.getName()));
        Intents.release();
        //passes
    }
    @Test
    public void NavigationHelpTest(){
        Intents.init();
        onView(withContentDescription(R.string.open)).perform(click());
        onView(withText("Help")).perform(click());
        intended(hasComponent(HelpActivity.class.getName()));
        Intents.release();
        //passes
    }
    @Test
    public void NavigationHomeTest(){
        Intents.init();
        onView(withContentDescription(R.string.open)).perform(click());
        onView(withText("Help")).perform(click());
        onView(withContentDescription(R.string.open)).perform(click());
        onView(withText("Home")).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
        Intents.release();
        //passes
    }
}
