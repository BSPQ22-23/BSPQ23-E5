package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;

public class APIUtils {
	public static String getStringHeader(HttpExchange t, String name, String def) {
		return new String(Base64.getDecoder().decode(t.getRequestHeaders().getOrDefault(name, List.of(def)).get(0)), StandardCharsets.UTF_8);
	}
	public static HashMap<String, String> objectToHeaders(Object o) {
		HashMap<String, String> output = new HashMap<>();
		for(Field f : o.getClass().getDeclaredFields())
			try {
				f.setAccessible(true);
				if(f.getType().isPrimitive())
					output.put(f.getName(), f.get(o).toString());
				else if(f.getType().equals(String.class))
					output.put(f.getName(), new String(Base64.getEncoder().encode(f.get(o).toString().getBytes()), StandardCharsets.UTF_8));
				else if(o instanceof Collection<?>)
					output.put(f.getName(), listToJSONArray((Collection<?>)o).toString());
				else
					output.put(f.getName(), objectToJSON(f.get(o)).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		return output;
	}
	public static String readBody(HttpExchange t) throws IOException{
		InputStreamReader isr = new InputStreamReader(t.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);

        int b;
        StringBuilder buf = new StringBuilder();
        while ((b = br.read()) != -1) {
            buf.append((char) b);
        }

        br.close();
        isr.close();
    	return buf.toString();
	}
	public static JSONArray listToJSONArray(Collection<?> o) {
		JSONArray array = new JSONArray();
		for(Object obj : (Collection<?>)o)
			if(obj instanceof Collection<?>)
				listToJSONArray((Collection<?>)obj);
			else if(obj.getClass().equals(String.class))
				array.put(new String(Base64.getEncoder().encode(obj.toString().getBytes()), StandardCharsets.UTF_8));
			else if(obj.getClass().isPrimitive())
				array.put(obj);
			else
				array.put(objectToJSON(obj));
		return array;
	}
	public static JSONObject objectToJSON(Object o) {
		JSONObject output = new JSONObject();
		try {
			for(Field f : o.getClass().getDeclaredFields()){
				f.setAccessible(true);
				 if(f.getType().equals(Collection.class))
					output.put(f.getName(), listToJSONArray((Collection<?>)f.get(o)));
				else if(f.getType().isPrimitive())
					output.put(f.getName(), f.get(o));
				else if(f.getType().equals(String.class))
					output.put(f.getName(), new String(Base64.getEncoder().encode(f.get(o).toString().getBytes()), StandardCharsets.UTF_8));
				else
					output.put(f.getName(), objectToJSON(f.get(o)));
			}
		} catch (JSONException | IllegalArgumentException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return output;
	}
	public static String decode(String value) {
		return new String(Base64.getDecoder().decode(value), StandardCharsets.UTF_8);
	}
}
