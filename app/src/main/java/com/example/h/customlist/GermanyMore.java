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

public class GermanyMore extends AppCompatActivity {
    Toolbar mToolbar;
    private TextView GerMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_germany_more);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        GerMore = (TextView) findViewById(R.id.GerActivityMore);
        parseXML();
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("Germany");
        }
    }
    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory=XmlPullParserFactory.newInstance();
            XmlPullParser parser=parserFactory.newPullParser();
            InputStream is=getAssets().open("Germany.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(is,null);

            processParsing(parser);
        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<GermanyXml> country=new ArrayList<>();
        int eventType=parser.getEventType();
        GermanyXml current=null;
        while(eventType!=XmlPullParser.END_DOCUMENT){
            String eltName=null;
            switch (eventType){
                case XmlPullParser.START_TAG:
                    eltName=parser.getName();
                    if("info".equals(eltName)){
                        current=new GermanyXml();
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

    private void printDetails(ArrayList<GermanyXml> country) {
        StringBuilder builder=new StringBuilder();

        for(GermanyXml info:country){
            builder.append(info.detail1).append(info.detail2);
        }
        GerMore.setText(builder.toString());
    }
}
