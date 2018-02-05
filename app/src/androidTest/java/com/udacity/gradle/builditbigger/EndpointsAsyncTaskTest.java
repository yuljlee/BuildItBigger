package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.fail;

/**
 * Created by u2stay1915 on 1/25/18.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    private String jokeExpected = "Java? Write once, debug everywhere!";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testEmptyJoke() throws Exception {

        try {
            // code review
//            String joke = new EndpointsAsyncTask().execute(new Pair<Context, String>(InstrumentationRegistry.getTargetContext(), null))
//                    .get(30, TimeUnit.SECONDS);
            String joke = new EndpointsAsyncTask(InstrumentationRegistry.getTargetContext(), null)
                    .execute()
                    .get(30, TimeUnit.SECONDS);
            Assert.assertNotNull(joke);
            Assert.assertTrue(!joke.isEmpty());
            //System.out.println(joke);
            Assert.assertEquals(jokeExpected, joke);

        } catch (Exception e) {
            fail("Time Out");
        }
    }
}