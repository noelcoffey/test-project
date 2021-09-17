package com.sample.web;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

	private List<String> messages = new ArrayList<>();


	public ErrorResponse() {
	}

	public ErrorResponse(String message) {
		messages.add(message);
	}

	public List<String> getMessages() {
		return messages;
	}

	public void addMessage(String message) {
		this.messages.add(message);
	}

}
