package com.example.h.customlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BrazWeb extends AppCompatActivity {
    Toolbar mToolbar;
    WebView aw;
    private ProgressBar spinner;

    public  static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braz_web);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        aw=(WebView)findViewById(R.id.webViewBraz);
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("Brazil");
        }
        data = (TextView) findViewById(R.id.fetcheddataBraz);
        fetchDataBraz process = new fetchDataBraz();
        process.execute();
        aw.setBackgroundColor(0);

    }
}
