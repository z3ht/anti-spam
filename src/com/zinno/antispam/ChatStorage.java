package com.zinno.antispam;

public class ChatStorage {
	
	public static String[] getChatInputs() {
		return chatInputs;
	}
	
	public static String getChatInputs(int slot) {
		return chatInputs[slot];
	}
	
	public static void setChatInputs(String[] chatInputs) {
		ChatStorage.chatInputs = chatInputs;
	}
	
	public static void setChatInputs(int slot, String name) {
		ChatStorage.chatInputs[slot] = name;
	}
	
	private static String[] chatInputs = new String[5];
	
}
