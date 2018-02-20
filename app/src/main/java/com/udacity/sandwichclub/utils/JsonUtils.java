
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
            if (aka != null) {
                for (int i = 0; i < aka.length(); i++) {
                    akaList.add(aka.getString(i));
                }
                finalSandwich.setAlsoKnownAs(akaList);
            }

            finalSandwich.setPlaceOfOrigin(sandwichDetails.getString("placeOfOrigin"));

            finalSandwich.setDescription(sandwichDetails.getString("description"));

            finalSandwich.setImage(sandwichDetails.getString("image"));

            JSONArray ingredients = (JSONArray) sandwichDetails.get("ingredients");
            if (ingredients != null) {
                for (int i = 0; i < ingredients.length(); i++) {
                    ingredientsList.add(ingredients.getString(i));
                }
                finalSandwich.setIngredients(ingredientsList);
            }

            return finalSandwich;

        } catch (final JSONException e) {
            Log.e(TAG, "JSON parsing error: ");
        }

        return null;
    }
}