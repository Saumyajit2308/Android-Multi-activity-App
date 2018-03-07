package com.example.h.customlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ItaWeb extends AppCompatActivity {
    Toolbar mToolbar;
    public  static TextView data;
    private ProgressBar spinner;
    WebView aw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ita_web);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        aw=(WebView)findViewById(R.id.webViewIta);
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("Italy");
        }
        data = (TextView) findViewById(R.id.fetcheddataIta);

        fetchDataIta process = new fetchDataIta();
        process.execute();
        aw.setBackgroundColor(0);
    }
}
