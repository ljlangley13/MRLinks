package com.shadowblox.shadowlinks.commands;

import org.bukkit.command.CommandSender;

import com.shadowblox.shadowlinks.Format;
import com.shadowblox.shadowlinks.ShadowLinks;
import com.shadowblox.shadowlinks.korikutils.SubCommandExecutor;

public class ShadowLinksCommand extends SubCommandExecutor {
	public ShadowLinksCommand(ShadowLinks instance) {
	}

	@command
	public void Null(CommandSender sender, String[] args) {
		sender.sendMessage(Format
				.notificationMessage("You're running ShadowLinks version "
						+ ShadowLinks.getInstance().getDescription()
								.getVersion())
				+ ".");
	}

	@command
	public void Version(CommandSender sender, String[] args) {
		sender.sendMessage(Format
				.notificationMessage("The version of ShadowLinks you're running is "
						+ ShadowLinks.getInstance().getDescription()
								.getVersion()));
	}

}
