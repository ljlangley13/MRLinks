package com.shadowblox.shadowlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import com.shadowblox.shadowlinks.Format;
import com.shadowblox.shadowlinks.ShadowLinks;
import com.shadowblox.shadowlinks.korikutils.SubCommandExecutor;

public class TwitchCommand extends SubCommandExecutor {
	private ShadowLinks plugin;
	public TwitchCommand(ShadowLinks instance) {
		plugin = instance;
	}
	@command
	public void Null(CommandSender sender, String[] args) {
		if ((sender.isOp()) || (sender.hasPermission("shadowlinks.linktwitch"))) {
			if (plugin.getConfig().getBoolean("Enable-Twitch") == true) {
				sender.sendMessage(Format
						.messageInfo("Our Twitch TV link is: ")
						+ (getConfig().getString("Twitch")));
			} else {
				sender.sendMessage(Format
						.errorMessage("This command is disabled in your ShadowLinks config file."));
			}
		} else {
			sender.sendMessage(Format
					.errorMessage("You do not have permission to use this ShadowLinks command."));
		}
	}


	public FileConfiguration getConfig() {
		return plugin.getConfig();
	}

}
