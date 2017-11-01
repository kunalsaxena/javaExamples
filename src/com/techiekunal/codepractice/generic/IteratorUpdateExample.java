package com.techiekunal.codepractice.generic;

import java.util.*;

class MyWord {
	
	private int seq;
	private String word;
	
	public MyWord(int seq, String word) {
		this.seq = seq;
		this.word = word;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	@Override
	public String toString() {
		return "seq : " + seq + " & word : " + word;
	}
}


public class IteratorUpdateExample {

	private static List<MyWord> list = new ArrayList<>();
	
	public static void main(String[] args) {
		list.add(new MyWord(1, "One"));
		list.add(new MyWord(2, "Two"));
		list.add(new MyWord(3, "Three"));
		list.add(new MyWord(4, "Four"));
		list.add(new MyWord(5, "Five"));
		
		System.out.println(list);
		
		// Now iterate and try to update
		Iterator<MyWord> itr = list.iterator();
		while(itr.hasNext()) {
			MyWord next = itr.next();
			next.setWord("Yee");
		}
		System.out.println("After Update..");
		System.out.println(list);
	}
	
}
