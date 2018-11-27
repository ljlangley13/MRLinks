package com.shadowblox.shadowlinks.commands;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.shadowblox.shadowlinks.Format;
import com.shadowblox.shadowlinks.ShadowLinks;
import com.shadowblox.shadowlinks.korikutils.SubCommandExecutor;

public class NoteCommand extends SubCommandExecutor {
	private ShadowLinks plugin;

	public NoteCommand(ShadowLinks instance) {
		plugin = instance;
	}

	public static String join(String[] a, String delimiter, Integer startIndex) {
		try {
			Collection<String> s = Arrays.asList(a);
			StringBuffer buffer = new StringBuffer();
			Iterator<String> iter = s.iterator();

			while (iter.hasNext()) {
				if (startIndex == 0) {
					buffer.append(iter.next());
					if (iter.hasNext()) {
						buffer.append(delimiter);
					}
				} else {
					startIndex--;
					iter.next();
				}
			}

			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@command
	public void Null(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.YELLOW + "Notes System Commands:");
		sender.sendMessage(Format.noteHelp("read") + Format.notehelpInfo("Shows you all your notes."));
		sender.sendMessage(Format.noteHelp("save <Note>") + Format.notehelpInfo("Allows you to save a note."));
		sender.sendMessage(Format.noteHelp("delete <number>") + Format.notehelpInfo("Allows you to delete a note."));
	}

	@command
	public void read(CommandSender sender, String[] args) {
		if ((plugin.getConfig().getBoolean("Enable-Notes") == true)
				&& sender.hasPermission("shadowlinks.note.read")) {
			sender.sendMessage(Format.notificationMessage("Your notes:"));
			File noteFile = new File(plugin.getDataFolder() + "/notes/",
					sender.getName() + ".yml");
			if (noteFile.exists()) {
				YamlConfiguration note = YamlConfiguration
						.loadConfiguration(noteFile);
				int ii = 1;
				while (note.contains("Note" + ii)) {
					sender.sendMessage(Format.noteMessage ("Note ")
							+ Integer.toString(ii) + ": " + ChatColor.GRAY
							+ note.getString("Note" + ii));
					ii++;
				}
			}
		}
	}

	@command
	public void save(CommandSender sender, String[] args) {

		if ((plugin.getConfig().getBoolean("Enable-Notes") == true)
				&& (sender.hasPermission("shadowlinks.note.save"))) {

			File noteFile = new File(plugin.getDataFolder().getAbsolutePath()
					+ "/notes/", sender.getName() + ".yml");
			if (noteFile.exists() == false) {
			}
			new YamlConfiguration();
			YamlConfiguration note = YamlConfiguration
					.loadConfiguration(noteFile);

			int i = 1;
			boolean isSaved = false;
			while (isSaved == false) {
				if (note.contains("Note" + Integer.toString(i))) {
				} else {
					note.set("Note" + i, join(args, " ", 0));
					isSaved = true;
					try {
						note.save(noteFile);
						sender.sendMessage(Format.notegoodMessage(
								"Your note number " + i + " has been saved."));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				i++;
			}
		} else {
			sender.sendMessage(Format.errorMessage("You do not have permission to use this ShadowLinks command."));
		}

	}

	@command
	public void delete(CommandSender sender, String[] args) {

		if((plugin.getConfig().getBoolean("Enable-Notes") == true) && (sender.hasPermission("shadowlinks.note.delete"))){   
                    File noteFile = new File(plugin.getDataFolder() + "/notes/", sender.getName() + ".yml");
                    if(noteFile.exists()){
                            YamlConfiguration note = YamlConfiguration.loadConfiguration(noteFile);
                            try{
                                    if(args.length == 1){                          
                                            int deletenoteNUMBER = Integer.parseInt(args[0]); //deletenoteNUMBER = 4
                                            int i = deletenoteNUMBER  +1; ///i = 5
                                        note.set("Note"+deletenoteNUMBER,null); //Delete note 4.
                                            while(note.contains("Note"+i)){ //Contains 5
                                                    String noteString = note.getString("Note"+i); //note string = 5
                                                    int newNmbr =i - 1; ///NewNmbr = 4
                                                    note.set("Note"+newNmbr,  noteString); //Set note +4 set to 5  
                                                note.set("Note"+i,null); //Remove 5
                                                    i++;
                                            }
                                            note.save(noteFile);
                                            sender.sendMessage (Format.notegoodMessage ("The note has been deleted." ));
                                            }
                                    else{
                                    }
                            }
                    catch(Exception e){
                            e.printStackTrace();
                            }
                    }
            }
            else{
            	sender.sendMessage(Format.errorMessage("You do not have permission to use this ShadowLinks command."));                      
            }
    }

	public FileConfiguration getConfig() {
		return plugin.getConfig();
	}
}
