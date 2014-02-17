package com.mushroomrevival.mrlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import com.mushroomrevival.mrlinks.Format;
import com.mushroomrevival.mrlinks.MRLinks;
import com.mushroomrevival.mrlinks.korikutils.SubCommandExecutor;

public class ContestCommand extends SubCommandExecutor {
	private MRLinks plugin;

	public ContestCommand(MRLinks instance) {
		plugin = instance;
	}

	@command
	public void Null(CommandSender sender, String[] args) {
		if ((sender.isOp()) || (sender.hasPermission("mrlinks.linkcontest"))) {
			if (plugin.getConfig().getBoolean("Enable-Contest") == true) {
				sender.sendMessage(Format
						.messageInfo("You can find out about any contests here: ")
						+ (getConfig().getString("Contest")));
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
