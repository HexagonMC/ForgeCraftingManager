package eu.mccluster.mod.forgecraftingmanager;


import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
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
    
    private ArrayList<String> forbiddenrecipes = new ArrayList<String>();

    
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        forbiddenrecipes.add("Thunder Stone Pickaxe");
        forbiddenrecipes.add("Thunder Stone Hammer");
        forbiddenrecipes.add("Thunder Stone Axe");
        forbiddenrecipes.add("Thunder Stone Shovel");
        forbiddenrecipes.add("Thunder Stone Hoe");
        forbiddenrecipes.add("Thunder Stone Sword");
        
        Iterator<IRecipe> iterator = CraftingManager.getInstance().getRecipeList().iterator();

        while (iterator.hasNext())
        {
            IRecipe recipe = iterator.next();
            if (recipe == null)
             continue;
            ItemStack output = recipe.getRecipeOutput();
            if (output != null && forbiddenrecipes.contains(output.getDisplayName()))
            	iterator.remove();
        }
    }
}
