package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    public ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

//        String joke = new EndpointsAsyncTask().execute(new Pair<Context, String>(this.getApplicationContext(), null)).get();

        //new EndpointsAsyncTask().execute(new Pair<Context, String>(this, null));
        new EndpointsAsyncTask(this, mLoadingIndicator).execute();
//        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, com.nanodegree.yj.jokedisplay.JokeActivity.class);
//        Joker joker = new Joker();
//        String joke = joker.getJoke();
//        intent.putExtra(JokeActivity.JOKE_KEY, joke);
//        startActivity(intent);
    }

}
