package com.example.h.customlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GerWeb extends AppCompatActivity {
    Toolbar mToolbar;
    WebView aw;
    public  static TextView data;
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ger_web);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        aw=(WebView)findViewById(R.id.webViewGer);
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("Australia");
        }
        data = (TextView) findViewById(R.id.fetcheddataGer);
        fetchDataGer process = new fetchDataGer();
        process.execute();
        aw.setBackgroundColor(0);
    }
}
