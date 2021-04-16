package com.matrix.EnderOreNew.world.gen;

import com.matrix.EnderOreNew.EnderOreNewMod;
import com.matrix.EnderOreNew.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnderOreNewMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModOreGen {
    @SubscribeEvent
    public static void generateOres(final BiomeLoadingEvent event){
        if(!(event.getCategory().equals(Biome.Category.NETHER) && event.getCategory().equals(Biome.Category.THEEND))){
            genOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.ENDER_ORE_BLOCK.get().getBlock().defaultBlockState(), 2, 5, 20, 8);
        }
    }

    private static void genOre(BiomeGenerationSettingsBuilder settings, RuleTest filler, BlockState state, int veinSize, int minHeight, int maxHeight, int amount){
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreFeatureConfig(filler, state, veinSize))
                        .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight,0,maxHeight)))
                        .squared().count(amount));
    }

}
