package com.mytaxi.android_demo.activities;


import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.mytaxi.android_demo.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import android.support.test.espresso.IdlingResource;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class myTaxiTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setActivity() {
        mActivity = mActivityTestRule.getActivity();
    }


    @Test
    public void mainActivityTest() throws InterruptedException {

        //Enter the Username and verify the Username

        onView(withId(R.id.edt_username)).perform(typeText("whiteelephant261"))
                .check(matches(withText("whiteelephant261")));

        //Enter the Password and verify the password
        onView(withId(R.id.edt_password)).perform(typeText("video1"))
                .check(matches(withText("video1")));


        //Click Login Button
        onView(withId(R.id.btn_login)).perform(click());

        Thread.sleep(1000);

        //Check if Text Search element is displayed before performing action
        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));

       //Clear textSearch
        onView(withId(R.id.textSearch)).perform(clearText());

        //Enter the text "sa"
        onView(withId(R.id.textSearch)).perform(typeText("sa"));

       //Select "Sarah Friedrich" and perform click
        onView(withText("Sarah Friedrich"))
          .inRoot(RootMatchers.withDecorView(not(is(mActivity.getWindow().getDecorView()))))
               .perform(click());

        //in the next View verify Sarah Friedrich is displayed
        onView(withId(R.id.textViewDriverName)).check(matches(withText("Sarah Friedrich")));




/*        synchronized (this) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
            }
        }*/

       //Check for Button before click
        onView(withId(R.id.fab)).check(matches(isDisplayed()));

        //Perform Click Action on the button
        onView(withId(R.id.fab)).perform(click());


    }

}
