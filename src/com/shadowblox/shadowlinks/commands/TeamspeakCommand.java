package com.mushroomrevival.mrlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import com.mushroomrevival.mrlinks.Format;
import com.mushroomrevival.mrlinks.MRLinks;
import com.mushroomrevival.mrlinks.korikutils.SubCommandExecutor;

public class TeamspeakCommand extends SubCommandExecutor {
	private MRLinks plugin;
	public TeamspeakCommand(MRLinks instance) {
		plugin = instance;
	}
	@command
	public void Null(CommandSender sender, String[] args) {
		if ((sender.isOp()) || (sender.hasPermission("mrlinks.linkteamspeak"))) {
			if (plugin.getConfig().getBoolean("Enable-Teamspeak") == true) {
				sender.sendMessage(Format
						.messageInfo("Our Teamspeak IP is: ")
						+ (getConfig().getString("Teamspeak")));
			} else {
				sender.sendMessage(Format
						.errorMessage("This command is disabled in your MRLinks config file."));
			}
		} else {
			sender.sendMessage(Format
					.errorMessage("You do not have permission to use this MRLinks command."));
		}
	}

	public FileConfiguration getConfig() {
		return plugin.getConfig();
	}

}
