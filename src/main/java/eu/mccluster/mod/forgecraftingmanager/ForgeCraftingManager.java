package eu.mccluster.mod.forgecraftingmanager;


import java.util.ArrayList;

import com.google.common.collect.ImmutableList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

@Mod(
        name = ForgeCraftingManager.NAME,
        modid = ForgeCraftingManager.MODID,
        version = ForgeCraftingManager.VERSION,
        dependencies = "required-after:pixelmon;required-after:sponge",
        acceptableRemoteVersions = "*",
        acceptedMinecraftVersions = "[1.12.2]")
public class ForgeCraftingManager
{
    public static final String  NAME    = "ForgeCraftingManager";
    public static final String  MODID   = "forgecraftingmanager";
    public static final String  VERSION = "1.0.1";
    
    @Instance(MODID)
    public static ForgeCraftingManager INSTANCE;
    
    private ArrayList<String> forbiddenrecipes = new ArrayList<String>();
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        //forbiddenrecipes.add("pixelmon:thunder_stone_hammer");
        //forbiddenrecipes.add("pixelmon:thunder_stone_pickaxe");
        //forbiddenrecipes.add("pixelmon:thunder_stone_axe");
        //forbiddenrecipes.add("pixelmon:thunder_stone_shovel");
        //forbiddenrecipes.add("pixelmon:thunder_stone_hoe");
        //forbiddenrecipes.add("pixelmon:thunder_stone_sword");
        //forbiddenrecipes.add("pixelmon:thunder_stone_helm");
        //forbiddenrecipes.add("pixelmon:thunder_stone_plate");
        //forbiddenrecipes.add("pixelmon:thunder_stone_legs");
        forbiddenrecipes.add("pixelmon:thunder_stone_boots");
        
        forbiddenrecipes.add("pixelmon:dawn_stone_boots");
        
        forbiddenrecipes.add("pixelmon:fire_stone_hammer");
        forbiddenrecipes.add("pixelmon:fire_stone_pickaxe");
        forbiddenrecipes.add("pixelmon:fire_stone_axe");
        forbiddenrecipes.add("pixelmon:fire_stone_shovel");
        forbiddenrecipes.add("pixelmon:fire_stone_hoe");
        forbiddenrecipes.add("pixelmon:fire_stone_sword");
        
        //forbiddenrecipes.add("pixelmon:sapphire_helm");
        //forbiddenrecipes.add("pixelmon:sapphire_plate");
        //forbiddenrecipes.add("pixelmon:sapphire_legs");
        //forbiddenrecipes.add("pixelmon:sapphire_boots");
        
        //forbiddenrecipes.add("pixelmon:galactic_helm");
        //forbiddenrecipes.add("pixelmon:galactic_plate");
        //forbiddenrecipes.add("pixelmon:galactic_legs");
        //forbiddenrecipes.add("pixelmon:galactic_boots");
        
        //forbiddenrecipes.add("pixelmon:ruby_helm");
        //forbiddenrecipes.add("pixelmon:ruby_plate");
        //forbiddenrecipes.add("pixelmon:ruby_legs");
        //forbiddenrecipes.add("pixelmon:ruby_boots");
        
        //forbiddenrecipes.add("pixelmon:neo_plasma_helm");
        //forbiddenrecipes.add("pixelmon:neo_plasma_plate");
        //forbiddenrecipes.add("pixelmon:neo_plasma_legs");
        //forbiddenrecipes.add("pixelmon:neo_plasma_boots");
        
        //forbiddenrecipes.add("pixelmon:plasma_helm");
        //forbiddenrecipes.add("pixelmon:plasma_plate");
        //forbiddenrecipes.add("pixelmon:plasma_legs");
        //forbiddenrecipes.add("pixelmon:plasma_boots");
        
        forbiddenrecipes.add("pixelmon:rocket_helm");
        forbiddenrecipes.add("pixelmon:rocket_plate");
        forbiddenrecipes.add("pixelmon:rocket_legs");
        forbiddenrecipes.add("pixelmon:rocket_boots");
        
        ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
        ImmutableList<IRecipe> recipes = ImmutableList.copyOf(recipeRegistry.getValues());
        
        for (IRecipe r : recipes) {
            ItemStack output = r.getRecipeOutput();
               if (output != null) {
                   for (String result : forbiddenrecipes) {
                       if (result.equalsIgnoreCase(output.getItem().getRegistryName().toString())) {
                           recipeRegistry.remove(r.getRegistryName());
                           recipeRegistry.register(EmptyRecipe.from(r));
                       }
                }
            }
       }
    }
}
