package com.java.adawang.CoreJava;

import org.junit.Test;
import java.util.*;
import org.json.*;

public class Collections {
	public HashMap<String, Integer> sortHashmap(HashMap<String, Integer> hm){
		List<Map.Entry<String, Integer> > list =
				new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

		// Sort the list
		java.util.Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
			@Override
			public int compare(Map.Entry<String, Integer> o1,
							   Map.Entry<String, Integer> o2)
			{
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	@Test
	public void testSortHashmap(){
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		// enter data into hashmap
		hm.put("Math", 98);
		hm.put("Data Structure", 85);
		hm.put("Database", 91);
		hm.put("Java", 95);
		hm.put("Operating System", 79);
		hm.put("Networking", 80);
		Map<String, Integer> hm1 = sortHashmap(hm);

		// print the sorted hashmap
		for (Map.Entry<String, Integer> en : hm1.entrySet()) {
			System.out.println("Key = " + en.getKey() +
					", Value = " + en.getValue());
		}
	}

	public String sortJson(String input){
		JSONArray jsonArr = new JSONArray(input);
		JSONArray sortedJsonArray = new JSONArray();

		List<JSONObject> jsonValues = new ArrayList<>();
		for(int i=0; i < jsonArr.length(); i++){
			jsonValues.add(jsonArr.getJSONObject(i));
		}

		java.util.Collections.sort(jsonValues, new Comparator<JSONObject>() {
			private static final String KEY_NAME = "Name";
			@Override
			public int compare(JSONObject o1, JSONObject o2) {
				String valA = new String();
				String valB = new String();
				try{
					valA = (String) o1.get(KEY_NAME);
					valB = (String) o2.get(KEY_NAME);
				}catch (JSONException e){}
				return valA.compareTo(valB);
			}
		});

		for(int i=0; i < jsonArr.length(); i++){
			sortedJsonArray.put(jsonValues.get(i));
		}

		return sortedJsonArray.toString();
	}

	@Test
	public void testSortedJson(){
		String input = "[ { \"ID\": \"135\", \"Name\": " +
				"\"Fargo Chan\" },{ \"ID\": \"432\", \"Name\": \"Aaron Luke\" },{ \"ID\": \"252\", \"Name\": \"Dilip Singh\" }]";
		String output = sortJson(input);
		System.out.println(output);
	}
}
