package com.mas6y6.horzion.items;

import com.mas6y6.horzion.Horzion;
import com.mas6y6.horzion.tools.AiriumToolMaterial;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Horzion.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Horzion.MODID);

    public static final RegistryObject<Block> AIRIUM_ORE = BLOCKS.register("airium_ore", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
            .strength(1.5f, 1.5f)
            .lightLevel(state -> 0)
        )
    );

    public static final RegistryObject<Block> BLOCK_OF_AIRIUM = BLOCKS.register("block_of_airium", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
            .strength(2f, 2f)
            .lightLevel(state -> 1)
        )
    );

    public static final RegistryObject<Item> AIRIUM_ORE_ITEM = ITEMS.register("airium_ore", 
        () -> new BlockItem(AIRIUM_ORE.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> BLOCK_OF_AIRIUM_ITEM = ITEMS.register("block_of_airium", 
        () -> new BlockItem(BLOCK_OF_AIRIUM.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> RAW_AIRIUM = ITEMS.register("raw_airium", 
        () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> RAW_HORZION = ITEMS.register("raw_horzion", 
        () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_INGOT = ITEMS.register("airium_ingot", 
        () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> HORZION_INGOT = ITEMS.register("horzion_ingot", 
        () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_PICKAXE = ITEMS.register("airium_pickaxe", 
        () -> new PickaxeItem(AiriumToolMaterial.INSTANCE, 1, -2.8f, new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_AXE = ITEMS.register("airium_axe", 
        () -> new AxeItem(AiriumToolMaterial.INSTANCE, 5.0f, -3.0f, new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_SWORD = ITEMS.register("airium_sword", 
        () -> new AiriumSword(Tiers.DIAMOND, Float.MAX_VALUE, -4.2f, new Item.Properties())
    );

    public static final RegistryObject<Item> EXCALIBUR = ITEMS.register("excalibur", 
        () -> new Excalibur(Tiers.DIAMOND, 1000f, -1.0f, new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_HOE = ITEMS.register("airium_hoe", 
        () -> new HoeItem(AiriumToolMaterial.INSTANCE, -2, 0.0f, new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_SHOVEL = ITEMS.register("airium_shovel", 
        () -> new ShovelItem(AiriumToolMaterial.INSTANCE, 1.5f, -3.0f, new Item.Properties())
    );

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
    }
}
