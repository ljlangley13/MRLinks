package com.mushroomrevival.mrlinks.commands;

import org.bukkit.command.CommandSender;

import com.mushroomrevival.mrlinks.Format;
import com.mushroomrevival.mrlinks.MRLinks;
import com.mushroomrevival.mrlinks.korikutils.SubCommandExecutor;

public class MRLinksCommand extends SubCommandExecutor {
	public MRLinksCommand(MRLinks instance) {
	}

	@command
	public void Null(CommandSender sender, String[] args) {
		sender.sendMessage(Format
				.notificationMessage("You're running MRLinks version "
						+ MRLinks.getInstance().getDescription()
								.getVersion())
				+ ".");
	}

	@command
	public void Version(CommandSender sender, String[] args) {
		sender.sendMessage(Format
				.notificationMessage("The version of MRLinks you're running is "
						+ MRLinks.getInstance().getDescription()
								.getVersion()));
	}

}
