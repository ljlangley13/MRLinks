package com.mushroomrevival.mrlinks;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.mushroomrevival.mrlinks.Metrics;
import com.mushroomrevival.mrlinks.CommandManager;

public class MRLinks extends JavaPlugin {
	public final Logger logger = Bukkit.getServer().getLogger();
	public static MRLinks plugin;
	public CommandManager commandManager;
	private static MRLinks instance;

	public static MRLinks getInstance() {
		return instance;
	}

	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled");
	}
	@Override
	public void onEnable(){	
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
			System.out.println("Error Submitting stats!");
		}
		File configFile = new File(this.getDataFolder().getAbsolutePath(),"config.yml");
		if(configFile.exists() == false){
			configFile.mkdir();
			saveDefaultConfig();
		}
		instance = this;
		commandManager = new CommandManager(this) {
			{
				initCommands();
			}
		};
	}	
}