package br.com.cep.ui

import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import br.com.cep.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityUITest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testeCorretodeCEP(){
        onView(withId(R.id.cep)).perform(typeText("03967000"))
        onView(withId(R.id.buscar)).perform(click())
        SystemClock.sleep(2000)
    }
    @Test
    fun testeErradodeCEP(){
        onView(withId(R.id.cep)).perform(typeText("1"))
        onView(withId(R.id.buscar)).perform(click())
        SystemClock.sleep(2000)
    }

}