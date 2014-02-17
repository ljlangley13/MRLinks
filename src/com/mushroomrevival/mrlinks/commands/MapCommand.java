package com.mushroomrevival.mrlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import com.mushroomrevival.mrlinks.Format;
import com.mushroomrevival.mrlinks.MRLinks;
import com.mushroomrevival.mrlinks.korikutils.SubCommandExecutor;

public class MapCommand extends SubCommandExecutor {
	private MRLinks plugin;
	public MapCommand(MRLinks instance) {
		plugin = instance;
	}
	@command
	public void Null(CommandSender sender, String[] args) {
		if ((sender.isOp()) || (sender.hasPermission("mrlinks.linkmap"))) {
			if (plugin.getConfig().getBoolean("Enable-Map") == true) {
				sender.sendMessage(Format
						.messageInfo("You can see our server's map here: ")
						+ (getConfig().getString("Map")));
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
