package com.mushroomrevival.mrlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import com.mushroomrevival.mrlinks.Format;
import com.mushroomrevival.mrlinks.MRLinks;
import com.mushroomrevival.mrlinks.korikutils.SubCommandExecutor;

public class VoteCommand extends SubCommandExecutor {
	private MRLinks plugin;

	public VoteCommand(MRLinks instance) {
		plugin = instance;
	}

	@command
	public void Null(CommandSender sender, String[] args) {
		if ((sender.isOp()) || (sender.hasPermission("mrlinks.linkvote"))) {
			if (plugin.getConfig().getBoolean("Enable-Vote") == true) {
				sender.sendMessage(Format
						.messageInfo("You can vote for our server here: ")
						+ (getConfig().getString("Vote")));
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
