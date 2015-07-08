package com.unaipme.tabbedtest;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    ActionBar.Tab firstTab, secondTab, thirdTab;
    Fragment firstFragment = new Fragment() {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.layout_test, container, false);
            ((TextView)rootView.findViewById(R.id.textView)).setText("First!");
            return rootView;
        }
    };
    Fragment secondFragment = new Fragment() {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.layout_test, container, false);
            ((TextView)rootView.findViewById(R.id.textView)).setText("Second!");
            return rootView;
        }
    };
    Fragment thirdFragment = new Fragment() {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.layout_test, container, false);
            ((TextView)rootView.findViewById(R.id.textView)).setText("Third!");
            return rootView;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        firstTab = actionBar.newTab().setText("First");
        secondTab = actionBar.newTab().setText("Second");
        thirdTab = actionBar.newTab().setText("Third");

        firstTab.setTabListener(new TabListener(firstFragment));
        secondTab.setTabListener(new TabListener(secondFragment));
        thirdTab.setTabListener(new TabListener(thirdFragment));

        actionBar.addTab(firstTab);
        actionBar.addTab(secondTab);
        actionBar.addTab(thirdTab);
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
}
