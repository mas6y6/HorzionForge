package com.mas6y6.horzion.items;

import com.mas6y6.horzion.Horzion;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Horzion.MODID);

    public static final RegistryObject<CreativeModeTab> HORZION_CREATIVETAB = CREATIVE_MODE_TABS.register("",() -> CreativeModeTab.builder()
    
    .displayItems((params, output) -> registerItems(params, output))
    .title(Component.translatable("itemGroup.horzion.tab"))
    .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    public static void registerItems(ItemDisplayParameters params,Output output) {
        output.accept(ModItems.RAW_AIRIUM.get());
        output.accept(ModItems.AIRIUM_ORE_ITEM.get());
        output.accept(ModItems.AIRIUM_INGOT.get());
        output.accept(ModItems.AIRIUM_SWORD.get());
        output.accept(ModItems.AIRIUM_PICKAXE.get());
        output.accept(ModItems.AIRIUM_AXE.get());
        output.accept(ModItems.AIRIUM_SHOVEL.get());
        output.accept(ModItems.AIRIUM_HOE.get());
        output.accept(ModItems.BLOCK_OF_AIRIUM_ITEM.get());

        output.accept(ModItems.RAW_HORZION.get());
        output.accept(ModItems.HORZION_INGOT.get());
        output.accept(ModItems.EXCALIBUR.get());
    }
}
