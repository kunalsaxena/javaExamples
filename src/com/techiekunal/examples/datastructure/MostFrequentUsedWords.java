package com.techiekunal.examples.datastructure;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * MyWord objects will have word and its frequency
 * 
 * @author Kunal.Saxena
 *
 */
class MyWord implements Comparable<MyWord>{
	
	// word from array
	private String word;
	
	// word's frequency
	private int count;

	public MyWord(int count, String word) {
		this.count = count;
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// Objects are equals if words are same
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		MyWord myWord = (MyWord) obj;
		return this.word.equals(myWord.word);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	// Printing word and count against it
	@Override
	public String toString() {
		return this.word + " : " + this.count;
	}

	// comparison for descending order of count
	@Override
	public int compareTo(MyWord o) {
		if(this.count > o.count) {
			return -1;
		}
		if(this.count < o.count) {
			return 1;
		}
		return 0;
	}

}

public class MostFrequentUsedWords {

	// Input array
	private static String[] arr = { "geeks", "for", "geeks", "a", "portal", "to", "learn", "can", "be", "computer",
			"science", "zoom", "yup", "fire", "in", "be", "data", "a", "portal","geeks" };

	// Queue will work as max heap to store words
	private static PriorityQueue<MyWord> queue = new PriorityQueue<>();

	// Creating PriorityQueue from given input array
	private static void createQueue() {

		for (String word : arr) {
			// check if word already exists
			if (queue.contains(new MyWord(1, word))) {
				
				MyWord oldWord = null;
				// iterate to find word : we need latest frequency of that word
				Iterator<MyWord> itr = queue.iterator();
				while (itr.hasNext()) {
					
					MyWord next = itr.next();
					if (next.getWord().equals(word)) {
						oldWord = next;
					}
				}
				// create new word by incrementing frequency, remove old word from queue, adding new word to queue
				MyWord newWord = new MyWord(oldWord.getCount() + 1, oldWord.getWord());
				queue.remove(oldWord);
				queue.add(newWord);
				
			} else {
				// if word is not in queue : add it with frequency 1
				MyWord newWord = new MyWord(1, word);
				queue.add(newWord);
			}
		}

	}

	public static void main(String[] args) {
		
		// Create priority queue
		createQueue();

		// Print Queue
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
