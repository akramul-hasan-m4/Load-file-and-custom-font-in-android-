package com.example.loadpropertiesfileandcustomfont.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig {

    private PropertiesConfig() {
    }

    public static String getProperty(String key, Context context) throws IOException {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("file/config.properties");
        properties.load(inputStream);
        return properties.getProperty(key);
    }

    public static String getfromTxtFile(Context context, String fileName){
        String content = "";
        try {
            InputStream inputStream = context.getAssets().open("file/"+fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            content = new String(buffer, "UTF-8");
        }
        catch (IOException e){
            Log.e("message: ",e.getMessage());
        }
        return content;
    }
}
