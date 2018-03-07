package com.example.h.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class IndiaMore extends AppCompatActivity {
    Toolbar mToolbar;
    private TextView IndMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_more);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        IndMore = (TextView) findViewById(R.id.IndActivityMore);
        parseXML();
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("India");
        }
    }
    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory=XmlPullParserFactory.newInstance();
            XmlPullParser parser=parserFactory.newPullParser();
            InputStream is=getAssets().open("India.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(is,null);

            processParsing(parser);
        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<IndiaXml> country=new ArrayList<>();
        int eventType=parser.getEventType();
        IndiaXml current=null;
        while(eventType!=XmlPullParser.END_DOCUMENT){
            String eltName=null;
            switch (eventType){
                case XmlPullParser.START_TAG:
                    eltName=parser.getName();
                    if("info".equals(eltName)){
                        current=new IndiaXml();
                        country.add(current);
                    } else if(current!=null){
                        if("detail1".equals(eltName)){
                            current.detail1=parser.nextText();
                        }  else if("detail2".equals(eltName)){
                            current.detail2=parser.nextText();
                        }
                    }
                    break;
            }
            eventType=parser.next();
        }
        printDetails(country);
    }

    private void printDetails(ArrayList<IndiaXml> country) {
        StringBuilder builder=new StringBuilder();

        for(IndiaXml info:country){
            builder.append(info.detail1).append(info.detail2);
        }
        IndMore.setText(builder.toString());
    }
}
