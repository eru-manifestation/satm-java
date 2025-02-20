package com.erumf.utils.data.management;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DataManagement {

    
    private static void subObjects(){
        try (InputStream is = new FileInputStream("C:\\Users\\Pablo\\Desktop\\VSCode Workspace\\erus-will\\src/main/resources/cards.json")) {
            JSONObject jsonObject = new JSONObject(new JSONTokener(is));
            JSONObject twProperty = jsonObject.getJSONObject("TW").getJSONObject("cards");
            
            JSONArray filtered = new JSONArray();
            Iterator<String> keys = twProperty.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                JSONObject card = twProperty.getJSONObject(key);
                if ("Site".equals(card.getString("type"))) {
                    filtered.put(card);
                }
            }

            try (OutputStream os = new FileOutputStream("C:\\Users\\Pablo\\Desktop\\VSCode Workspace\\erus-will\\src/main/resources/TWSites.json")) {
                os.write(filtered.toString(4).getBytes());
                System.out.println("TW Property written to resources/TWSites.json: "+filtered.length()+" objects");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
