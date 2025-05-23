package com.mas6y6.horzion.worldgen;

import java.util.List;

import com.mas6y6.horzion.Horzion;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AIRIUM_ORE_PLACED_KEY = registerKey("airium_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, AIRIUM_ORE_PLACED_KEY, 
            configuredFeature.getOrThrow(ModConfiguredFeatures.OVERWORLD_AIRIUM_ORE),
            ModOrePlacement.commonOrePlacement(
                42,
                HeightRangePlacement.uniform(
                    VerticalAnchor.absolute(0), VerticalAnchor.absolute(68)
                )
            )
        );
    }


    @SuppressWarnings("removal")
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Horzion.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
