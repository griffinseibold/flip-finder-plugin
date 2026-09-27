package com.flipfinder.runelite;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(FlipFinderPlugin.CONFIG_GROUP)
public interface FlipFinderConfig extends Config
{
	@ConfigItem(
		keyName = "sendAccountData",
		name = "Send account data",
		description = "Send your membership, coins, Grand Exchange offers and buy limit use to your Flip Finder server",
		warning = "Sends your RuneScape display name and account hash, membership and ironman status, "
			+ "inventory and last-seen bank coins, Grand Exchange offers, and tracked buy-limit usage to the "
			+ "configured 3rd-party Flip Finder server. The server also receives your IP address.",
		position = 1
	)
	default boolean sendAccountData()
	{
		return false;
	}

	@ConfigItem(
		keyName = "serverUrl",
		name = "Server URL",
		description = "Address of your Flip Finder server, such as the homelab's http://flipfinder.localhost:8080",
		position = 2
	)
	default String serverUrl()
	{
		return "http://flipfinder.localhost:8080";
	}
}
