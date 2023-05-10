package Main;

import java.io.File;
import java.io.IOException;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.Point_cmd;
import Commands.Timber_cmd;
import Commands.Wasted_cmd;
import Listener.ChatFarbe;
import Listener.DeathMessage_listener;
import Listener.SaveAnnounce;
import Listener.Timber_listener;

public class Start extends JavaPlugin {

	public static File timberFile = new File("plugins//Fix//timber.yml");

	@Override
	public void onEnable() {
		if (!timberFile.exists()) {
			try {
				timberFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ChatFarbe(), this);
		pm.registerEvents(new DeathMessage_listener(), this);
		pm.registerEvents(new SaveAnnounce(this), this);
		pm.registerEvents(new Timber_listener(this), (Plugin) this);

		this.getCommand("wasted").setExecutor(new Wasted_cmd());
		this.getCommand("point").setExecutor(new Point_cmd());
		this.getCommand("timber").setExecutor(new Timber_cmd());
	}

	@Override
	public void onDisable() {

	}

}
