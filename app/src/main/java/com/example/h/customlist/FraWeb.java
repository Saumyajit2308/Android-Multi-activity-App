package com.example.h.customlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FraWeb extends AppCompatActivity {
    Toolbar mToolbar;
    public  static TextView data;
    private ProgressBar spinner;
    WebView aw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fra_web);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        aw=(WebView)findViewById(R.id.webViewFra);
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("France");
        }
        data = (TextView) findViewById(R.id.fetcheddataFra);
        fetchDataFra process = new fetchDataFra();
        process.execute();
        aw.setBackgroundColor(0);
    }
}
