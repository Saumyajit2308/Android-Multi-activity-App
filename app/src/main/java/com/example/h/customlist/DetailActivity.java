package com.example.h.customlist;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Toolbar mToolbar;
    ImageView mImageView,iv;
    Button button,btn2;
    TextView mTextView,de;
    private Aus ausdata = null;
    private Braz brazdata=null;
    private China chinadata=null;
    private Fra fradata=null;
    private Ger gerdata=null;
    private Ind inddata=null;
    private Irl irldata=null;
    private Ita itadata=null;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.
                    transition.shared_element_transition_a));
        }
        setContentView(R.layout.activity_detail);

        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mImageView = (ImageView) findViewById(R.id.imageView2);
        iv=(ImageView)findViewById(R.id.imageView4);
        mTextView=(TextView)findViewById(R.id.textView5);
        de=(TextView)findViewById(R.id.textView6);
        button = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        ausdata = (new AusData()).getData();
        brazdata = (new BrazData()).getData();
        chinadata = (new ChinaData()).getData();
        fradata = (new FraData()).getData();
        gerdata = (new GerData()).getData();
        inddata = (new IndData()).getData();
        irldata = (new IrlData()).getData();
        itadata = (new ItaData()).getData();
        Bundle mBundle = getIntent().getExtras();

        if (mBundle != null) {
            mToolbar.setTitle(mBundle.getString("countryName"));
            mImageView.setImageResource(mBundle.getInt("countryFlag"));
            iv.setImageResource(mBundle.getInt("img"));
            mTextView.setText(mBundle.getString("gdp"));
            de.setText(mBundle.getString("d"));

            i=mBundle.getInt("VALUE");
        }
        Log.i("ADebugTag", "Value: " + MainActivity.countryNames[i]);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.countryNames[i].equals("Australia")){
                    Intent i=new Intent(DetailActivity.this,AustraliaMore.class);
                    startActivity(i);
                } else if(MainActivity.countryNames[i].equals("Brazil")){
                    Intent i=new Intent(DetailActivity.this,BrazilMore.class);
                    startActivity(i);
                }else if(MainActivity.countryNames[i].equals("China")){
                    Intent i=new Intent(DetailActivity.this,ChinaMore.class);
                    startActivity(i);
                }else if(MainActivity.countryNames[i].equals("France")){
                    Intent i=new Intent(DetailActivity.this,FranceMore.class);
                    startActivity(i);
                }else if(MainActivity.countryNames[i].equals("Germany")){
                    Intent i=new Intent(DetailActivity.this,GermanyMore.class);
                    startActivity(i);
                }else if(MainActivity.countryNames[i].equals("India")){
                    Intent i=new Intent(DetailActivity.this,IndiaMore.class);
                    startActivity(i);
                }else if(MainActivity.countryNames[i].equals("Ireland")){
                    Intent i=new Intent(DetailActivity.this,IrelandMore.class);
                    startActivity(i);
                }else if(MainActivity.countryNames[i].equals("Italy")){
                    Intent i=new Intent(DetailActivity.this,ItalyMore.class);
                    startActivity(i);
                }
            }
        });
            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make an intent

                    if(MainActivity.countryNames[i].equals("Australia")) {
                        Intent intent = new Intent(DetailActivity.this, AusActivity.class);
                        Bundle bundle = new Bundle();

                        //populate the bundle with data
                        bundle.putSerializable("dataaus", ausdata);
                        intent.putExtras(bundle);

                        //start activity
                        startActivity(intent);
                    } else if(MainActivity.countryNames[i].equals("Brazil")) {
                        Intent intent = new Intent(DetailActivity.this, BrazActivity.class);
                        Bundle bundle = new Bundle();

                        //populate the bundle with data
                        bundle.putSerializable("databraz", brazdata);
                        intent.putExtras(bundle);

                        //start activity
                        startActivity(intent);
                    } else if(MainActivity.countryNames[i].equals("China")) {
                        Intent intent = new Intent(DetailActivity.this, ChinaActivity.class);
                        Bundle bundle = new Bundle();

                        //populate the bundle with data
                        bundle.putSerializable("datachi", chinadata);
                        intent.putExtras(bundle);

                        //start activity
                        startActivity(intent);
                    }else if(MainActivity.countryNames[i].equals("France")) {
                        Intent intent = new Intent(DetailActivity.this, FraActivity.class);
                        Bundle bundle = new Bundle();

                        //populate the bundle with data
                        bundle.putSerializable("datafra", fradata);
                        intent.putExtras(bundle);

                        //start activity
                        startActivity(intent);
                    }else if(MainActivity.countryNames[i].equals("Germany")) {
                        Intent intent = new Intent(DetailActivity.this, GerActivity.class);
                        Bundle bundle = new Bundle();

                        //populate the bundle with data
                        bundle.putSerializable("datager", gerdata);
                        intent.putExtras(bundle);

                        //start activity
                        startActivity(intent);
                    }else if(MainActivity.countryNames[i].equals("India")) {
                        Intent intent = new Intent(DetailActivity.this, IndActivity.class);
                        Bundle bundle = new Bundle();

                        //populate the bundle with data
                        bundle.putSerializable("dataind", inddata);
                        intent.putExtras(bundle);

                        //start activity
                        startActivity(intent);
                    }else if(MainActivity.countryNames[i].equals("Ireland")) {
                        Intent intent = new Intent(DetailActivity.this, IrlActivity.class);
                        Bundle bundle = new Bundle();

                        //populate the bundle with data
                        bundle.putSerializable("datairl", irldata);
                        intent.putExtras(bundle);

                        //start activity
                        startActivity(intent);
                    }else if(MainActivity.countryNames[i].equals("Italy")) {
                        Intent intent = new Intent(DetailActivity.this, ItaActivity.class);
                        Bundle bundle = new Bundle();

                        //populate the bundle with data
                        bundle.putSerializable("dataita", itadata);
                        intent.putExtras(bundle);

                        //start activity
                        startActivity(intent);
                    }

            }
        });

    }

}
