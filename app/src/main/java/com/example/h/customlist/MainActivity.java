package com.example.h.customlist;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;
    public static String[] countryNames = {"Australia", "Brazil", "China", "France", "Germany", "India", "Ireland", "Italy"};
    int[] countryFlags = {R.drawable.flag_australia,
            R.drawable.flag_brazil,
            R.drawable.flag_china,
            R.drawable.flag_france,
            R.drawable.flag_germany,
            R.drawable.flag_india,
            R.drawable.flag_ireland,
            R.drawable.flag_italy,
            };
    public static String[] detail={"The name Australia in Australian English is derived from the Latin Terra Australis, a name used for a hypothetical continent in the Southern Hemisphere since ancient times."
    ,"Brazil is now the largest grower of sugar cane in the world. Brazil, Indonesia, and Mexico sell a lot of coffee. For almost 400 years, the Amazon region of Brazil was the world's main producer of rubber."
    ,"Ancient China is a very old civilization. There are written records of the history of China which date from 1500 BC in the Shang dynasty (c. 1600–1046 BC)."
    ,"The Flag of France is called the Tricolour (French: le drapeau tricolore). It was adopted 15 February 1794."
    ,"The Federal Republic of Germany (FRG) has 16 states. The biggest is Bavaria and the smallest is Bremen."
    ,"The word \"India\" is a Western transliteration of the Sanskrit word Sindhu, meaning body of water. It specifically refers to what we know today as the Indus river."
    ,"The modern Irish Éire evolved from the Old Irish word Ériu, which was the name of a Gaelic goddess. Ériu is generally believed to have been the matron goddess of Ireland, a goddess of sovereignty."
    ,"Italy is a country in the south of Europe. It is divided into 20 regions. A region is a part of the country with a government and a president. In Italy, regions can decide some things. They can give money to local business."};
    int image=R.drawable.sub_ic;
    int [] images={R.drawable.australia,
            R.drawable.brazil,
            R.drawable.china,
            R.drawable.france,
            R.drawable.germany,
            R.drawable.india,
            R.drawable.ireland,
            R.drawable.italy,
            };
    public static String[] gdps={"|   GDP: 1.30 trillion USD","|   GDP: 2.10 trillion USD","|   GDP: 11.7 trillion USD",
            "|   GDP: 2.42 trillion USD","|   GDP: 3.40 trillion USD","|   GDP: 2.45 trillion USD",
            "|   GDP: .294 trillion USD","|   GDP: 1.80 trillion USD"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 21){
            getWindow().setSharedElementExitTransition(TransitionInflater.
                    from(this).inflateTransition(R.transition.shared_element_transition_a));
        }
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mListView = (ListView) findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, countryNames, countryFlags,gdps, image);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent mIntent = new Intent(MainActivity.this, DetailActivity.class);
                mIntent.putExtra("countryName", countryNames[i]);
                mIntent.putExtra("countryFlag", images[i]);
                mIntent.putExtra("gdp",gdps[i]);
                mIntent.putExtra("img",image);
                mIntent.putExtra("d",detail[i]);

                Bundle b = new Bundle();
                b.putInt("VALUE",i);
                mIntent.putExtras(b);


                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.
                      makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.listView),"blue_name");
               startActivity(mIntent, optionsCompat.toBundle());

            }
        });
    }

}
