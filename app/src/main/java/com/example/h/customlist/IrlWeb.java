package com.example.h.customlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class IrlWeb extends AppCompatActivity {
    Toolbar mToolbar;
    private ProgressBar spinner;
    public  static TextView data;
    WebView aw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irl_web);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        aw=(WebView)findViewById(R.id.webViewIrl);
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("Ireland");
        }
        data = (TextView) findViewById(R.id.fetcheddataIrl);
        fetchDataIrl process = new fetchDataIrl();
        process.execute();
        aw.setBackgroundColor(0);
    }
}
