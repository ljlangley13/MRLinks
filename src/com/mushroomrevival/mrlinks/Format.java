package com.mushroomrevival.mrlinks;

import org.bukkit.ChatColor;

public class Format {
	public static String helpinfoColour = "" + ChatColor.GRAY;
	public static String notehelpColour = "" + ChatColor.WHITE;
	public static String errorColour = "" + ChatColor.DARK_RED;
	public static String messageColour = "" + ChatColor.GOLD;
	public static String noteColour = "" + ChatColor.GOLD;
	public static String notegoodColour = "" + ChatColor.GREEN;
	public static String notifcationColour = "" + ChatColor.GOLD;
	
	public static String helpInfo(String string) {
		return helpinfoColour + "" + string;
	}
	public static String noteMessage(String string) {
		return noteColour + "" + string;
	}
	public static String notificationMessage(String string) {
		return notifcationColour + "" + string;
	}
	public static String notehelpInfo(String string) {
		return notehelpColour + " - " + string;
	}
	public static String notegoodMessage(String string) {
		return notegoodColour + "" + string;
	}
	public static String noteHelp(String string) {
		return helpinfoColour + "/note " + string;
	}
	public static String messageInfo(String string) {
		return messageColour + "" + string;
	}
	public static String errorMessage(String string) {
		return errorColour + "" + string;
	}

}
