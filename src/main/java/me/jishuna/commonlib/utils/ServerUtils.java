package me.jishuna.commonlib.utils;

import org.bukkit.Bukkit;
import org.bukkit.Server;

public class ServerUtils {

	private static final Server SERVER = Bukkit.getServer();

	public static String getOnlineMode() {
		if (SERVER.getOnlineMode())
			return "Online";

		if (SERVER.spigot().getConfig().getBoolean("settings.bungeecord", false))
			return "Bungee";

		return "Offline";
	}
}
