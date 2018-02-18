
package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    private static final String TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {
        Sandwich finalSandwich = new Sandwich();

        ArrayList<String> akaList = new ArrayList<String>();
        ArrayList<String> ingredientsList = new ArrayList<String>();

        try {
            JSONObject sandwichDetails = new JSONObject(json);

            JSONObject name = sandwichDetails.getJSONObject("name");
            finalSandwich.setMainName(name.getString("mainName"));

            JSONArray aka = (JSONArray) name.get("alsoKnownAs");
            for (int i=0; i< aka.length(); i++){
                akaList.add((String)aka.get(i));
            }

            finalSandwich.setPlaceOfOrigin(sandwichDetails.getString("placeOfOrigin"));

            finalSandwich.setDescription(sandwichDetails.getString("description"));

            finalSandwich.setImage(sandwichDetails.getString("image"));

            JSONArray ingredients = (JSONArray) sandwichDetails.get("ingredients");
            for (int i=0; i< ingredients.length(); i++){
                ingredientsList.add((String)ingredients.get(i));
            }

            return finalSandwich;

        } catch (final JSONException e) {
            Log.e(TAG, "JSON parsing error: ");
        }

        return null;
    }
}