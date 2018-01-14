package toughasnails.util.inventory;

import glitchcore.entity.EntityHelper;
import glitchcore.inventory.GFCreativeTab;
import glitchcore.util.GFNonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import toughasnails.api.item.TANItems;
import toughasnails.core.ToughAsNails;

public class CreativeTabTAN extends GFCreativeTab
{
    public static final CreativeTabs instance = new CreativeTabTAN(CreativeTabs.getNextID(), "tabToughAsNails");

    private CreativeTabTAN(int index, String label)
    {
        super(index, label);
    }

    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(TANItems.tan_icon);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(GFNonNullList<ItemStack> itemList)
    {
        super.displayAllRelevantItems(itemList);
        for (EntityList.EntityEggInfo eggInfo : EntityList.ENTITY_EGGS.values())
        {
            if (EntityHelper.getEntityEggOwner(eggInfo).equals(ToughAsNails.MOD_ID))
            {
                ItemStack itemstack = new ItemStack(Items.SPAWN_EGG, 1);
                ItemMonsterPlacer.applyEntityIdToItemStack(itemstack, eggInfo.spawnedID);
                itemList.add(itemstack);
            }
        }
    }
}
