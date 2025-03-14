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
    
    public static void subObjects(String type, String subtype){
        try (InputStream is = new FileInputStream("src/main/resources/dev/cards.json")) {
            JSONObject jsonObject = new JSONObject(new JSONTokener(is));
            JSONObject twProperty = jsonObject.getJSONObject("TW").getJSONObject("cards");
            
            
            JSONArray filtered = new JSONArray();
            Iterator<String> keys = twProperty.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                JSONObject card = twProperty.getJSONObject(key);
                if (type.equals(card.getString("type"))) {
                    if (subtype!=null) {
                        String cardSubtype = card.getJSONObject("attributes").getString("subtype");
                        if (cardSubtype.equals(subtype)) {
                            filtered.put(card);
                        }
                    }else filtered.put(card);
                }
            }
            String fileName = type+ (subtype==null? "":"-"+subtype) +".json";
            try (OutputStream os = new FileOutputStream("src/main/resources/dev/"+fileName)) {
                os.write(filtered.toString(4).getBytes());
                System.out.println("TW Property written to src/main/resources/dev/"+fileName+" "+filtered.length()+" objects");
            }
        } catch (IOException e) {
            System.out.println("Unable to filter cards");
            e.printStackTrace();
        }
    }
}
