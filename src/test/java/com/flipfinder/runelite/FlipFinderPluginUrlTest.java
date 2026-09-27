package com.flipfinder.runelite;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import okhttp3.HttpUrl;
import org.junit.Test;
public class FlipFinderPluginUrlTest
{
	@Test
	public void allowsHttpsServers()
	{
		assertTrue(FlipFinderPlugin.isAllowedServerUrl(HttpUrl.parse("https://flip.example.com")));
	}

	@Test
	public void allowsHttpForLoopbackServers()
	{
		assertTrue(FlipFinderPlugin.isAllowedServerUrl(HttpUrl.parse("http://localhost:8080")));
		assertTrue(FlipFinderPlugin.isAllowedServerUrl(HttpUrl.parse("http://flipfinder.localhost:8080")));
		assertTrue(FlipFinderPlugin.isAllowedServerUrl(HttpUrl.parse("http://127.0.0.1:8080")));
		assertTrue(FlipFinderPlugin.isAllowedServerUrl(HttpUrl.parse("http://[::1]:8080")));
	}

	@Test
	public void rejectsHttpForRemoteServers()
	{
		assertFalse(FlipFinderPlugin.isAllowedServerUrl(HttpUrl.parse("http://flip.example.com")));
	}

	@Test
	public void rejectsMissingUrls()
	{
		assertFalse(FlipFinderPlugin.isAllowedServerUrl(null));
	}
}
