
package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {
    private static final String TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {
        Sandwich finalSandwich = new Sandwich();
        try {
            JSONObject sandwichDetails = new JSONObject(json);
            JSONObject name = sandwichDetails.getJSONObject("name");
            String mainName = name.getString("mainName");
            Log.v(TAG, "Sandwich Main Name: "+ mainName);
        } catch (final JSONException e) {
            Log.e(TAG, "JSON parsing error: ");
        }




        return null;
    }
}