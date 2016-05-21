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
        forbiddenrecipes.add("Aqua Helmet");
        forbiddenrecipes.add("Aqua Chestplate");
        forbiddenrecipes.add("Aqua Leggings");
        forbiddenrecipes.add("Aqua Boots");
        forbiddenrecipes.add("Galactic Swag");
        forbiddenrecipes.add("Galactic Chestplate");
        forbiddenrecipes.add("Galactic Leggings");
        forbiddenrecipes.add("Galactic Boots");
        forbiddenrecipes.add("Magma Helmet");
        forbiddenrecipes.add("Magma Chestplate");
        forbiddenrecipes.add("Magma Leggings");
        forbiddenrecipes.add("Magma Boots");
        forbiddenrecipes.add("Neo Plasma Helmet");
        forbiddenrecipes.add("Neo Plasma Chestplate");
        forbiddenrecipes.add("Neo Plasma Leggings");
        forbiddenrecipes.add("Neo Plasma Boots");
        forbiddenrecipes.add("Plasma Helmet");
        forbiddenrecipes.add("Plasma Chestplate");
        forbiddenrecipes.add("Plasma Leggings");
        forbiddenrecipes.add("Plasma Boots");
        forbiddenrecipes.add("Rocket Helmet");
        forbiddenrecipes.add("Rocket Chestplate");
        forbiddenrecipes.add("Rocket Leggings");
        forbiddenrecipes.add("Rocket Boots");
        
        
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
