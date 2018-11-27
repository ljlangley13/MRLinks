package com.shadowblox.shadowlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import com.shadowblox.shadowlinks.Format;
import com.shadowblox.shadowlinks.ShadowLinks;
import com.shadowblox.shadowlinks.korikutils.SubCommandExecutor;

public class YoutubeCommand extends SubCommandExecutor {
	private ShadowLinks plugin;
	public YoutubeCommand(ShadowLinks instance) {
		plugin = instance;
	}
	@command
	public void Null(CommandSender sender, String[] args) {
		if ((sender.isOp()) || (sender.hasPermission("shadowlinks.linkyoutube"))) {
			if (plugin.getConfig().getBoolean("Enable-Youtube") == true) {
				sender.sendMessage(Format
						.messageInfo("Our Youtube link is: ")
						+ (getConfig().getString("Youtube")));
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
