package com.shadowblox.shadowlinks;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.shadowblox.shadowlinks.CommandManager;

public class ShadowLinks extends JavaPlugin {
	public final Logger logger = Bukkit.getServer().getLogger();
	public static ShadowLinks plugin;
	public CommandManager commandManager;
	private static ShadowLinks instance;

	public static ShadowLinks getInstance() {
		return instance;
	}

	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled");
	}
	@Override
	public void onEnable(){	
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
        if (getConfig().getBoolean("Metrics"))
           new MetricsLite(this); 
	}	
}