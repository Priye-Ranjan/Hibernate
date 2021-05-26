package com.maven.one2many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question1 {
	@Id
	private int questionid;
	private String question;
	@OneToMany(mappedBy="question",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Answer1> answers;
	
	public Question1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question1(int questionid, String question, List<Answer1> answers) {
		super();
		this.questionid = questionid;
		this.question = question;
		this.answers = answers;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer1> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer1> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [questionid=" + questionid + ", question=" + question + ", answers=" + answers + "]";
	}
	
	
	
	
}