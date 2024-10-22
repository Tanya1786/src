package csis3475;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.random.RandomGenerator;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		question1();
		
		
		
		Stack<String> names = new Stack<>();
		
		names.add("Peter");
		names.add("Cathy");		
		names.add("Jane");
		names.add("Bob");
		
		sortStack(names);
		
		ArrayList<String> nameArray = new ArrayList<String>();
		nameArray.add("Vancouver");
		nameArray.add("Victoria");
		nameArray.add("Calgary");
		nameArray.add("Regina");
		nameArray.add("Toronto");
		
		
		ArrayList<Integer> populationArray = new ArrayList<Integer>();
		populationArray.add(662000);
		populationArray.add(91000);
		populationArray.add(136000);
		populationArray.add(226000);
		populationArray.add(2790000);
		
		sortCityByPopulation(nameArray, populationArray);
				
	
		
	}
	
	
	
	public static void sortCityByPopulation(ArrayList<String> cityName, ArrayList<Integer> cityPopulation) {
		ArrayList<City> cityArray = new ArrayList<City>();
		
		for(int i=0; i<5; i++) {
			cityArray.add(new City(cityName.get(i), cityPopulation.get(i)));
			
		}

	    PriorityQueue<City> pq = new PriorityQueue<>(new CityComparator());
	    for (City city : cityArray) {
	        pq.offer(city);
	    }

	    cityArray.clear();
	    while (!pq.isEmpty()) {
	        cityArray.add(pq.poll());
	    }
	    
	    System.out.println(cityArray);

	}
	
	
	public static void sortStack(Stack<String> s) {

		
		StringComparator sc = new StringComparator();
		PriorityQueue<String> names = new PriorityQueue<>(sc);

		names.offer("Peter");
		names.offer("Cathy");
		names.offer("Jane");
		names.offer("Bob");


		while (!names.isEmpty()) {
		    System.out.println(names.poll());
		}

	}
	
	public static void question1() {
		
		Random rand = new Random();	
		
		boolean isAlphabetFull = false;
		
		Queue<String> alphabetQueue = new LinkedList();
		
		
		while(!isAlphabetFull) {
			
			char c =(char)(rand.nextInt(26) + 'a');
			
			
			if(c == 'a') {
				alphabetQueue.add(c+"");
			}
			
			if(c == 'e') {
				alphabetQueue.add(c+"");
			}
			
			if(c == 'i') {
				alphabetQueue.add(c+"");
			}
			
			if(c == 'o') {
				alphabetQueue.add(c+"");
			}
			
			if(c == 'u') {
				alphabetQueue.add(c+"");
			}
					
			
			if(alphabetQueue.size() == 5) {
				isAlphabetFull = true;
			}
			
		}
		
		for(int i=0; i<=alphabetQueue.size(); i++) {
			System.out.println(alphabetQueue.poll());
		}
	}
	
	
	
	

}
