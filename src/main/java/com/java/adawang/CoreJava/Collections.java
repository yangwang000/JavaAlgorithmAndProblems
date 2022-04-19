package com.java.adawang.CoreJava;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

	@Test
	public void testSortArrayList(){
		List<String> names = Arrays.asList("Cat", "Dog", "Horse", "Cow");
		names.sort(Comparator.comparing(String::toString));
		System.out.println(names);

		names = Arrays.asList("Cat", "Dog", "Horse", "Cow");
		names = names.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println(names);
	}

	@Test
	public void testStream(){
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//get list of unique squares
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		squaresList.forEach(System.out::println);

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		//get count of empty string
		long count = strings.stream().filter(string -> !string.isEmpty()).count();
		System.out.println(count);

		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
	}

	@Test
	public void testArrays(){
		//The java.util.Arrays.asList(T... a) returns a fixed-size list backed by the specified array. (Changes to the returned list "write through" to the array.)
		String[] array = {"abc", "2", "10", "0"};
		List<String> list = Arrays.asList(array);
		java.util.Collections.sort(list);
		System.out.println(Arrays.toString(array));
	}

	@Test
	public void test(){
		List<String> list1 = new ArrayList<>();
		list1.add( "One" );
		list1.add( "Two" );
		list1.add( "Three" );

		List<String> list2 = new ArrayList<>();
		list2.add( "Two" );

		list1.remove( "T" );
		System.out.println(list1);
	}

	class Student{
		private int id;
		private String name;
		private double cgpa;

		public Student(int id, String name, double cgpa) {
			this.id = id;
			this.name = name;
			this.cgpa = cgpa;
		}

		public int getID() {
			return id;
		}

		public String getName() {
			return name;
		}

		public double getCGPA() {
			return cgpa;
		}
	}

	class StudentComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			if (o1.getCGPA() == o2.getCGPA()) {
				if(o1.getName().equals(o2.getName())) {
					return Integer.compare(o2.getID(), o1.getID());
				} else {
					return o1.getName().compareTo(o2.getName());
				}
			}
			return Double.compare(o2.getCGPA(), o1.getCGPA());
		}
	}

	class Priorities {
		public List<Student> getStudents(List<String> events) {
			PriorityQueue pq = new PriorityQueue<>(events.size(), new StudentComparator());

			for (String event: events) {
				String parts[] = event.split(" ");

				if (parts[0].equals("ENTER")) {
					Student stu = new Student(Integer.parseInt(parts[3]), parts[1], Double.parseDouble(parts[2]));
					pq.add(stu);
				} else {
					if (!pq.isEmpty()) {
						pq.poll();
					}
				}
			}

			List<Student> students = new ArrayList<>();
			while (!pq.isEmpty()) {
				students.add((Student) pq.poll());
			}

			return students;
		}
	}

	@Test
	public void testpq(){
		String[] input = {
				"ENTER John 3.75 50",
				"ENTER Mark 3.8 24",
				"ENTER Shafaet 3.7 35",
				"SERVED",
				"SERVED",
				"ENTER Samiha 3.85 36",
				"SERVED",
				"ENTER Ashley 3.9 42",
				"ENTER Maria 3.6 46",
				"ENTER Anik 3.95 49",
				"ENTER Dan 3.95 50",
				"SERVED"};
		List<String> il = Arrays.asList(input);
		Priorities priorities = new Priorities();
		List<Student> students = priorities.getStudents(il);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st: students) {
				System.out.println(st.getName());
			}
		}
	}
}
