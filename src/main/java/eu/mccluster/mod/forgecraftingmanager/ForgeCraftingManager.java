package eu.mccluster.mod.forgecraftingmanager;


import java.util.ArrayList;

import org.spongepowered.api.Sponge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

@Mod(
        name = ForgeCraftingManager.NAME,
        modid = ForgeCraftingManager.MODID,
        version = ForgeCraftingManager.VERSION,
        dependencies = "required-after:pixelmon;required-after:sponge",
        acceptableRemoteVersions = "*",
        acceptedMinecraftVersions = "[1.8.9]")
public class ForgeCraftingManager
{
    public static final String  NAME    = "ForgeCraftingManager";
    public static final String  MODID   = "forgecraftingmanager";
    public static final String  VERSION = "1.0";
    
    @Instance(MODID)
    public static ForgeCraftingManager INSTANCE;
    
    private ArrayList<String> forbiddenrecipes = new ArrayList<String>();

    
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(INSTANCE);
        
        forbiddenrecipes.add("Thunder Stone Pickaxe");
        forbiddenrecipes.add("Thunder Stone Hammer");
        forbiddenrecipes.add("Thunder Stone Axe");
        forbiddenrecipes.add("Thunder Stone Shovel");
        forbiddenrecipes.add("Thunder Stone Hoe");
        forbiddenrecipes.add("Thunder Stone Sword");
    }
    
    @SubscribeEvent
    public void itemCrafted(ItemCraftedEvent event)
    {
    	if(!Sponge.getServer().getPlayer(event.player.getName()).orElse(null).hasPermission("forgecraftingmanager.bypass"))
    	{
    		if(event.crafting != null && event.crafting.getDisplayName() != null && forbiddenrecipes.contains(event.crafting.getDisplayName()))
    		{
    			event.setResult(Result.DENY);
    		}
    	}
    }
}
