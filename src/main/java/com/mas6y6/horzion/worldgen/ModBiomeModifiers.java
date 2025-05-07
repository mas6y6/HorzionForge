package com.mas6y6.horzion.worldgen;

import com.mas6y6.horzion.Horzion;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_AIRIUM_ORE = registerKey("add_airium_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var PlacedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biome = context.lookup(Registries.BIOME);

        context.register(ADD_AIRIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
            biome.getOrThrow(BiomeTags.IS_OVERWORLD),
            HolderSet.direct(PlacedFeatures.getOrThrow(ModPlacedFeatures.AIRIUM_ORE_PLACED_KEY)),
            GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }

    @SuppressWarnings("removal")
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Horzion.MODID, name));
    }
}
