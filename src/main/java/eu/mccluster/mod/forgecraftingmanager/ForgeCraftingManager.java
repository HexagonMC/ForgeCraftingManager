package eu.mccluster.mod.forgecraftingmanager;


import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


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
    
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLLog.info("Starting inject of Pixelmons economy system with the one from Sponge");
        Iterator<IRecipe> iterator = CraftingManager.getInstance().getRecipeList().iterator();
        while (iterator.hasNext())
        {
            IRecipe recipe = iterator.next();
            if (recipe == null)
             continue;
            ItemStack output = recipe.getRecipeOutput();
            System.out.println("Recipe: " + output.getDisplayName());
        }
    }
}
