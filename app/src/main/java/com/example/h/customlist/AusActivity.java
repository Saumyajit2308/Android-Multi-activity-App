package com.example.h.customlist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by h on 10/19/2017.
 */
public class AusActivity extends AppCompatActivity{
    private TextView pop=null;
    private TextView area=null;
    Toolbar mToolbar;
    Button btn;

    private static final int ALERT_DIALOG_ID=1;
    private Aus ausdata=null;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aus);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        btn=(Button)findViewById(R.id.auswebbtn);


        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("Australia");
        }
        pop =(TextView)findViewById(R.id.pop1);
        area =(TextView)findViewById(R.id.area1);
        Intent intent= getIntent();
        Bundle bundle =intent.getExtras();

        ausdata =(Aus) bundle.getSerializable("dataaus");

        pop.setText(ausdata.getPopulation());
        area.setText(ausdata.getAreaaus());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(isOnline()==false && v.getId()==R.id.auswebbtn) {
                    showDialog(ALERT_DIALOG_ID);}
                else if(isOnline()==true) {
                    Intent i = new Intent(AusActivity.this, AusWeb.class);
                    startActivity(i);
                }


            }
        });

    }
    protected Dialog onCreateDialog (int id){
        switch (id) {
            case ALERT_DIALOG_ID:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("OOPS!! No Internet Connection.");
                builder.setMessage("Please go to connections settings and enable internet connectivity to view web conte.");
                builder.setIcon(android.R.drawable.btn_star);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        return;
                    }
                });
                return builder.create();
        }
        return null;
    }

    private boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            return false;
        }
        return true;
    }

}
