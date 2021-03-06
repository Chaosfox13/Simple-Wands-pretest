package com.Chaosfox13.ModTest.handler;

import java.io.File;

import com.Chaosfox13.ModTest.reference.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler
{
	public static Configuration configuration;
	//put values here
	public boolean randomConfig = false;
	public static void init(File configFile)
	{
		configuration = new Configuration(configFile);
		if(configuration==null)
		{
			configuration = new Configuration(configFile);
		}

	}
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			//re sync config
			loadConfiguration();
		}
	}
	public void loadConfiguration()
	{
		randomConfig= configuration.getBoolean("randomConfig", configuration.CATEGORY_GENERAL, false, "insert witty remark");
		if(configuration.hasChanged())
		{
			configuration.save();
		}
	}
}
