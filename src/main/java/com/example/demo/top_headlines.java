package com.example.demo;

import java.util.ArrayList;

public class top_headlines {

	private String status;
	private int totalResults;
	private ArrayList<article> articles;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	public ArrayList<article> getArticles() {
		return articles;
	}
	public void setArticles(ArrayList<article> articles) {
		this.articles = articles;
	}
	
	
}
