package com.shadowblox.shadowlinks;

import com.shadowblox.shadowlinks.commands.ContestCommand;
import com.shadowblox.shadowlinks.commands.MapCommand;
import com.shadowblox.shadowlinks.commands.DonateCommand;
import com.shadowblox.shadowlinks.commands.FacebookCommand;
import com.shadowblox.shadowlinks.commands.InstagramCommand;
import com.shadowblox.shadowlinks.commands.MumbleCommand;
import com.shadowblox.shadowlinks.commands.NoteCommand;
import com.shadowblox.shadowlinks.commands.ShadowLinksCommand;
import com.shadowblox.shadowlinks.commands.TeamspeakCommand;
import com.shadowblox.shadowlinks.commands.TwitchCommand;
import com.shadowblox.shadowlinks.commands.TwitterCommand;
import com.shadowblox.shadowlinks.commands.VoteCommand;
import com.shadowblox.shadowlinks.commands.WebsiteCommand;
import com.shadowblox.shadowlinks.commands.YoutubeCommand;

public class CommandManager {
	public ContestCommand contestCommand;
	public MapCommand mapCommand;
	public DonateCommand donateCommand;
	public FacebookCommand facebookCommand;
	public InstagramCommand instagramCommand;
	public NoteCommand noteCommand;
	public ShadowLinksCommand shadowlinksCommand;
	public TeamspeakCommand teamspeakCommand;
	public MumbleCommand mumbleCommand;
	public TwitterCommand twitterCommand;
	public VoteCommand voteCommand;
	public WebsiteCommand websiteCommand;
	public YoutubeCommand youtubeCommand;
	public TwitchCommand twitchCommand;
	public ShadowLinks plugin;

	public CommandManager(ShadowLinks mrLinks) {
		this.plugin = mrLinks;
	}

	public void initCommands() {
		this.contestCommand = new ContestCommand(plugin);
		this.mumbleCommand = new MumbleCommand(plugin);
		this.twitchCommand = new TwitchCommand(plugin);
		this.shadowlinksCommand = new ShadowLinksCommand(plugin);
		this.donateCommand = new DonateCommand(plugin);
		this.facebookCommand = new FacebookCommand(plugin);
		this.mapCommand = new MapCommand(plugin);
		this.instagramCommand = new InstagramCommand(plugin);
		this.noteCommand = new NoteCommand(plugin);
		this.teamspeakCommand = new TeamspeakCommand(plugin);
		this.twitterCommand = new TwitterCommand(plugin);
		this.voteCommand = new VoteCommand(plugin);
		this.websiteCommand = new WebsiteCommand(plugin);
		this.youtubeCommand = new YoutubeCommand(plugin);

		this.plugin.getCommand("Contest").setExecutor(
				this.contestCommand);
		this.plugin.getCommand("Map").setExecutor(
				this.mapCommand);
		this.plugin.getCommand("Mumble").setExecutor(
				this.mumbleCommand);
		this.plugin.getCommand("ShadowLinks").setExecutor(
				this.shadowlinksCommand);
		this.plugin.getCommand("Donate").setExecutor(
				this.donateCommand);
		this.plugin.getCommand("Facebook").setExecutor(
				this.facebookCommand);
		this.plugin.getCommand("Instagram").setExecutor(
				this.instagramCommand);
		this.plugin.getCommand("Note").setExecutor(
				this.noteCommand);
		this.plugin.getCommand("Teamspeak").setExecutor(
				this.teamspeakCommand);
		this.plugin.getCommand("Twitter").setExecutor(
				this.twitterCommand);
		this.plugin.getCommand("Vote").setExecutor(
				this.voteCommand);
		this.plugin.getCommand("Website").setExecutor(
				this.websiteCommand);
		this.plugin.getCommand("Youtube").setExecutor(
				this.youtubeCommand);
		this.plugin.getCommand("Twitch").setExecutor(
				this.twitchCommand);
		
	}

}
