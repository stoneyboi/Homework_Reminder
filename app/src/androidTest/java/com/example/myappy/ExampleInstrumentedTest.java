package com.example.myappy;

import android.content.Context;
import android.widget.TextView;

import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Test // checks to make sure the app uses the right package context
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.myappy", appContext.getPackageName());
    }

    @Test
    public void ClassTest() {
       onView(withId(R.id.NameD));
        onView(withId(R.id.NameD)).equals(withText("NAME:"));

    }

    @Test
    public void DeleteClass() {
        onView(withId(R.id.deleteButton));
        onView(withId(R.id.deleteButton)).equals(withText("Delete"));

    }

    @Test
    public void AddClass(){
        onView(withId(R.id.button1));
        onView(withId(R.id.button1)).equals(withText("Add Class"));
    }

    @Test
    public void AddTask(){
        onView(withId(R.id.floatAdd));
        onView(withId(R.id.floatAdd)).equals(withText("Add Task"));
    }

}
