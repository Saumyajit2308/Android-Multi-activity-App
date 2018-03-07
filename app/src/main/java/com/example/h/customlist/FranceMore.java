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

public class FranceMore extends AppCompatActivity {
    Toolbar mToolbar;
    private TextView FraMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_france_more);
        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        FraMore = (TextView) findViewById(R.id.FraActivityMore);
        parseXML();
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle("France");
        }
    }
    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory=XmlPullParserFactory.newInstance();
            XmlPullParser parser=parserFactory.newPullParser();
            InputStream is=getAssets().open("France.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(is,null);

            processParsing(parser);
        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<FranceXml> country=new ArrayList<>();
        int eventType=parser.getEventType();
        FranceXml current=null;
        while(eventType!=XmlPullParser.END_DOCUMENT){
            String eltName=null;
            switch (eventType){
                case XmlPullParser.START_TAG:
                    eltName=parser.getName();
                    if("info".equals(eltName)){
                        current=new FranceXml();
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

    private void printDetails(ArrayList<FranceXml> country) {
        StringBuilder builder=new StringBuilder();

        for(FranceXml info:country){
            builder.append(info.detail1).append(info.detail2);
        }
        FraMore.setText(builder.toString());
    }
}
