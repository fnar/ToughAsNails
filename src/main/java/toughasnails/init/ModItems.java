/*******************************************************************************
 * Copyright 2020, the Glitchfiend Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package toughasnails.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import toughasnails.item.DirtyWaterBottleItem;
import toughasnails.item.FilledCanteenItem;
import toughasnails.item.EmptyCanteenItem;
import toughasnails.item.PurifiedWaterBottleItem;
import toughasnails.util.inventory.ItemGroupTAN;

import static toughasnails.api.item.TANItems.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems
{
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        empty_canteen = registerItem(new EmptyCanteenItem((new Item.Properties()).stacksTo(1).tab(ItemGroupTAN.INSTANCE)), "empty_canteen");
        dirty_water_canteen = registerItem(new FilledCanteenItem((new Item.Properties()).durability(5).tab(ItemGroupTAN.INSTANCE)), "dirty_water_canteen");
        water_canteen = registerItem(new FilledCanteenItem((new Item.Properties()).durability(5).tab(ItemGroupTAN.INSTANCE)), "water_canteen");
        purified_water_canteen = registerItem(new FilledCanteenItem((new Item.Properties()).durability(5).tab(ItemGroupTAN.INSTANCE)), "purified_water_canteen");
        dirty_water_bottle = registerItem(new DirtyWaterBottleItem((new Item.Properties()).stacksTo(1).tab(ItemGroupTAN.INSTANCE)), "dirty_water_bottle");
        purified_water_bottle = registerItem(new PurifiedWaterBottleItem((new Item.Properties()).stacksTo(1).tab(ItemGroupTAN.INSTANCE)), "purified_water_bottle");

        tan_icon = registerItem(new Item(new Item.Properties()), "tan_icon");
    }

    public static Item registerItem(Item item, String name)
    {
        item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
