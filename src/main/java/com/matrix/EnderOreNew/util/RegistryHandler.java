package com.matrix.EnderOreNew.util;

import com.matrix.EnderOreNew.EnderOreNewMod;
import com.matrix.EnderOreNew.blocks.EnderOre;
import com.matrix.EnderOreNew.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EnderOreNewMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EnderOreNewMod.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> ENDER_DUST = ITEMS.register("ender_dust", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> ENDER_ORE_BLOCK = BLOCKS.register("ender_ore", EnderOre::new);

    // Block Items
    public static final RegistryObject<Item> ENDER_ORE_BLOCK_ITEM = ITEMS.register("ender_ore", () -> new BlockItem(ENDER_ORE_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

}
