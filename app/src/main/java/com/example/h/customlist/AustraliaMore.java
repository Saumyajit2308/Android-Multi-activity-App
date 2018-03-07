package com.example.h.customlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AustraliaMore extends AppCompatActivity {
    Toolbar mToolbar;
    private TextView AusMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_australia_more);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        AusMore = (TextView) findViewById(R.id.AusActivityMore);
        parseXML();
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("Australia");
        }
    }

    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory=XmlPullParserFactory.newInstance();
            XmlPullParser parser=parserFactory.newPullParser();
            InputStream is=getAssets().open("Australia.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(is,null);

            processParsing(parser);
        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<AustraliaXml> country=new ArrayList<>();
        int eventType=parser.getEventType();
        AustraliaXml current=null;
        while(eventType!=XmlPullParser.END_DOCUMENT){
            String eltName=null;
            switch (eventType){
                case XmlPullParser.START_TAG:
                    eltName=parser.getName();
                    if("info".equals(eltName)){
                        current=new AustraliaXml();
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

    private void printDetails(ArrayList<AustraliaXml> country) {
        StringBuilder builder=new StringBuilder();

        for(AustraliaXml info:country){
            builder.append(info.detail1).append(info.detail2);
        }
       AusMore.setText(builder.toString());
    }
}