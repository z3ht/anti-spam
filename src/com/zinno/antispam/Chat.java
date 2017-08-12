package com.zinno.antispam;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
	
	@EventHandler
	public void acyncChatEvent(AsyncPlayerChatEvent event) {
		
		int recentMessagesFromPlayer = 0;
		for(String messageHistory : ChatStorage.getChatInputs()) {
			if(messageHistory == null) {
				continue;
			}
			if(messageHistory.equalsIgnoreCase(event.getPlayer().getName())) {
				recentMessagesFromPlayer += 1;
			}
		}
		int counter = 0;
		for(String s : ChatStorage.getChatInputs()) {
			if(counter == 4) {
				ChatStorage.setChatInputs(counter, event.getPlayer().getName());
				continue;
			}
			ChatStorage.setChatInputs(counter, ChatStorage.getChatInputs(counter+1));
			counter+=1;
		}
		if(recentMessagesFromPlayer < 4) {
			return;
		}
		
		event.getRecipients().removeAll(Bukkit.getOnlinePlayers());
		event.getRecipients().add(event.getPlayer());
	}
	
}
