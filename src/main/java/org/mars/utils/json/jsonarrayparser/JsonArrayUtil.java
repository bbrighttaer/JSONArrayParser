/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mars.utils.json.jsonarrayparser;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.mars.utils.json.model.ArrayHolder;

/**
 *Utility class for JSON workarounds
 * @author AG BRIGHTER
 */
public class JsonArrayUtil 
{
    private Gson gson;

    public JsonArrayUtil() {
        this.gson = new Gson();
    }
    
    /**
     * Takes a JSON parsed <code>float</code> array, e.g. [1.9,3.6,7.1], and return the <code>float[]</code>
     * form of it
     * @param jsonArrayStr The JSON string of the parsed float array
     * @return <code>float</code> array
     */
    public float[] getFloatArray(String jsonArrayStr)
    {
        try 
        {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"elements\":").append(jsonArrayStr).append("}");
            ArrayHolder<Float> arrayHolder = gson.fromJson(sb.toString(), ArrayHolder.class);
            System.out.println(sb.toString());
            Object[] floats = arrayHolder.getElements();
            float[] fs = new float[floats.length];
            for (int i = 0; i < fs.length; i++) {
                fs[i] = (float)((double)floats[i]);
            }
            return fs;
        } catch (JsonSyntaxException | NumberFormatException e) {
            java.util.logging.Logger.getLogger(JsonArrayUtil.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            return null;
        }
    }
}
