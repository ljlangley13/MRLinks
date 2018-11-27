package com.shadowblox.shadowlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import com.shadowblox.shadowlinks.Format;
import com.shadowblox.shadowlinks.ShadowLinks;
import com.shadowblox.shadowlinks.korikutils.SubCommandExecutor;
public class FacebookCommand extends SubCommandExecutor {
	private ShadowLinks plugin;
	public FacebookCommand(ShadowLinks instance) {
		plugin = instance;
	}
	@command
	public void Null(CommandSender sender, String[] args) {
		if ((sender.isOp()) || (sender.hasPermission("shadowlinks.linkfacebook"))) {
			if (plugin.getConfig().getBoolean("Enable-Facebook") == true) {
				sender.sendMessage(Format
						.messageInfo("Our Facebook link is: ")
						+ (getConfig().getString("Facebook")));
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
