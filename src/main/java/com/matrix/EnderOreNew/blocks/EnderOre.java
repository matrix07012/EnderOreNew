package com.matrix.EnderOreNew.blocks;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class EnderOre extends OreBlock {
    public EnderOre() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops()
                .strength(5f,6f)
        );
    }

}
