package com.example.loadpropertiesfileandcustomfont;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.loadpropertiesfileandcustomfont.util.PropertiesConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview = findViewById(R.id.textView);
        Typeface font = ResourcesCompat.getFont(this, R.font.greatvibes_regular);
        textview. setTypeface(font);

        printFromProperTies();
        printFromTxtFile();
        printFromJsonFile();
        printFromXml();
        printFromYmlFile();
    }

    private void printFromProperTies(){
        try {
            Log.d(TAG, "printFromProperTies: prop "+ PropertiesConfig.getProperty("name", this));
            Log.d(TAG, "printFromProperTies: prop "+ PropertiesConfig.getProperty("age", this));
        } catch (IOException e) {
            Log.d(TAG, "printFromProperTies: exception "+ e.getMessage());
        }
    }

    private void printFromTxtFile(){
        Log.d(TAG, "printFromTxtFile: txt "+PropertiesConfig.getfromTxtFile(this, "message.txt"));
    }

    private void printFromJsonFile(){
        String jsonObj = PropertiesConfig.getfromTxtFile(this, "sample.json");
        try {
            JSONObject jsonobject = new JSONObject(jsonObj);
            JSONArray jarray = jsonobject.getJSONArray("credential");
            for(int i=0;i<jarray.length();i++)
            {
                JSONObject jb =(JSONObject) jarray.get(i);
                String name = jb.getString("name");
                String url = jb.getString("url");
                Log.d(TAG, "printFromJsonFile: json "+name);
                Log.d(TAG, "printFromJsonFile: json "+url);
            }

        } catch (JSONException e) {
            Log.d(TAG, "printFromJsonFile: ex "+ e.getMessage());
        }
    }

    private void printFromXml(){
        try {
            InputStream is = getAssets().open("file/sample.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element=doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("employee");

            for (int i=0; i<nList.getLength(); i++) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;
                    String name = getValue("name", element2);
                    String surName = getValue("surname", element2);
                    String salary = getValue("salary", element2);

                    Log.d(TAG, "printXml: "+ name);
                    Log.d(TAG, "printXml: "+ surName);
                    Log.d(TAG, "printXml: "+ salary);
                }
            }

        } catch (Exception e) {
            Log.e(TAG, "printFromXml: " +e.getMessage());
        }
    }

    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    private void printFromYmlFile(){
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = getAssets().open("file/config.yml");
            Map<String, Object> obj = (Map<String, Object>) yaml.load(inputStream);
            Log.d(TAG, "printFromYmlFile: "+ obj.get("firstName"));
            Log.d(TAG, "printFromYmlFile: "+ obj.get("contactDetails"));
        } catch (Exception e) {
            Log.e(TAG, "printFromYmlFile: "+ e.getMessage() );
        }
    }
}
