package com.mytaxi.android_demo.activities;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class myTaxiFunctions {


    public static void  Login(String Usn,String Pwd){
        onView(withId(R.id.edt_username)).perform(typeText(Usn))
                .check(matches(withText(Usn)));

        onView(withId(R.id.edt_password)).perform(typeText(Pwd))
                .check(matches(withText(Pwd)));

        //Click Login Button
        onView(withId(R.id.btn_login)).perform(click());
    }

    public static void Search(String str){
        onView(withId(R.id.textSearch)).perform(clearText());

        onView(withId(R.id.textSearch)).perform(typeText(str));
    }


}
