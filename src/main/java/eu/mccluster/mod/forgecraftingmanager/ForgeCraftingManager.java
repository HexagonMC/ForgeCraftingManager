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
        forbiddenrecipes.add("pixelmon:ThunderstoneHammer");
        forbiddenrecipes.add("pixelmon:ThunderstonePickaxe");
        forbiddenrecipes.add("pixelmon:ThunderstoneAxe");
        forbiddenrecipes.add("pixelmon:ThunderstoneShovel");
        forbiddenrecipes.add("pixelmon:ThunderstoneHoe");
        forbiddenrecipes.add("pixelmon:ThunderstoneSword");
        
        forbiddenrecipes.add("pixelmon:FirestoneHammer");
        forbiddenrecipes.add("pixelmon:FirestonePickaxe");
        forbiddenrecipes.add("pixelmon:FirestoneAxe");
        forbiddenrecipes.add("pixelmon:FirestoneShovel");
        forbiddenrecipes.add("pixelmon:FirestoneHoe");
        forbiddenrecipes.add("pixelmon:FirestoneSword");
        
        forbiddenrecipes.add("pixelmon:SapphireHelm");
        forbiddenrecipes.add("pixelmon:SapphirePlate");
        forbiddenrecipes.add("pixelmon:SapphireLegs");
        forbiddenrecipes.add("pixelmon:SapphireBoots");
        forbiddenrecipes.add("pixelmon:GalacticHelm");
        forbiddenrecipes.add("pixelmon:GalacticPlate");
        forbiddenrecipes.add("pixelmon:GalacticLegs");
        forbiddenrecipes.add("pixelmon:GalacticBoots");
        forbiddenrecipes.add("pixelmon:RubyHelm");
        forbiddenrecipes.add("pixelmon:RubyPlate");
        forbiddenrecipes.add("pixelmon:RubyLegs");
        forbiddenrecipes.add("pixelmon:RubyBoots");
        forbiddenrecipes.add("pixelmon:NeoPlasmaHelm");
        forbiddenrecipes.add("pixelmon:NeoPlasmaPlate");
        forbiddenrecipes.add("pixelmon:NeoPlasmaLegs");
        forbiddenrecipes.add("pixelmon:NeoPlasmaBoots");
        forbiddenrecipes.add("pixelmon:PlasmaHelm");
        forbiddenrecipes.add("pixelmon:PlasmaPlate");
        forbiddenrecipes.add("pixelmon:PlasmaLegs");
        forbiddenrecipes.add("pixelmon:PlasmaBoots");
        forbiddenrecipes.add("pixelmon:RocketHelm");
        forbiddenrecipes.add("pixelmon:RocketPlate");
        forbiddenrecipes.add("pixelmon:RocketLegs");
        forbiddenrecipes.add("pixelmon:RocketBoots");
        
        
        Iterator<IRecipe> iterator = CraftingManager.getInstance().getRecipeList().iterator();

        while (iterator.hasNext())
        {
            IRecipe recipe = iterator.next();
            if (recipe == null)
             continue;
            ItemStack output = recipe.getRecipeOutput();
            if (output != null && forbiddenrecipes.contains(output.getItem().getRegistryName()))
            	iterator.remove();
        }
    }
}
