package com.fsoft.bn.domain.news;

public class VoteChoiceResult {

	private String questionText;
	private int numberOfChoices;
	private int percentage;
	private int totalVoteOfQuestions;

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getNumberOfChoices() {
		return numberOfChoices;
	}

	public void setNumberOfChoices(int numberOfChoices) {
		this.numberOfChoices = numberOfChoices;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public int getTotalVoteOfQuestions() {
		return totalVoteOfQuestions;
	}

	public void setTotalVoteOfQuestions(int totalVoteOfQuestions) {
		this.totalVoteOfQuestions = totalVoteOfQuestions;
	}
	
	@Override
	public String toString() {
		return "VoteChoiceResult [questionText=" + questionText + ", numberOfChoices=" + numberOfChoices 
				+ ", percentage=" + percentage + ", totalVoteOfQuestions" + totalVoteOfQuestions +" ]";
	}
}