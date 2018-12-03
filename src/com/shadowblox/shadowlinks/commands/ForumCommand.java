package com.shadowblox.shadowlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import com.shadowblox.shadowlinks.Format;
import com.shadowblox.shadowlinks.ShadowLinks;
import com.shadowblox.shadowlinks.korikutils.SubCommandExecutor;

public class ForumCommand extends SubCommandExecutor {
	private ShadowLinks plugin;

	public ForumCommand(ShadowLinks instance) {
		plugin = instance;
	}

	@command
	public void Null(CommandSender sender, String[] args) {
		if ((sender.isOp()) || (sender.hasPermission("shadowlinks.linkforum"))) {
			if (plugin.getConfig().getBoolean("Enable-Forum") == true) {
				sender.sendMessage(Format
						.messageInfo("You can visit our Forum here: ")
						+ (getConfig().getString("Forum")));
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
