package com.mas6y6.horzion;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import com.mas6y6.horzion.items.Excalibur;
import com.mas6y6.horzion.tools.AiriumToolMaterial;
import com.mas6y6.horzion.tools.HorzionToolMaterial;
import com.mas6y6.horzion.items.AiriumSword;
import com.mas6y6.horzion.sounds.ModSounds;

@Mod(Horzion.MODID)
public class Horzion {
    public static final String MODID = "horzion";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<Block> AIRIUM_ORE = Horzion.BLOCKS.register("airium_ore", 
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
            .strength(1.5f, 1.5f)
            .lightLevel(state -> 0)
        )
    );

    public static final RegistryObject<Block> BLOCK_OF_AIRIUM = Horzion.BLOCKS.register("block_of_airium", 
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
        () -> new PickaxeItem(AiriumToolMaterial, 1, -2.8f, new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_AXE = ITEMS.register("airium_axe", 
        () -> new AxeItem(AiriumToolMaterial, 5.0f, -3.0f, new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_SWORD = ITEMS.register("airium_sword", 
        () -> new AiriumSword(Tiers.DIAMOND, Float.MAX_VALUE, -4.2f, new Item.Properties())
    );

    public static final RegistryObject<Item> EXCALIBUR = ITEMS.register("excalibur", 
        () -> new Excalibur(Tiers.DIAMOND, 1000f, -1.0f, new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_HOE = ITEMS.register("airium_hoe", 
        () -> new HoeItem(AiriumToolMaterial, -2, 0.0f, new Item.Properties())
    );

    public static final RegistryObject<Item> AIRIUM_SHOVEL = ITEMS.register("airium_shovel", 
        () -> new ShovelItem(AiriumToolMaterial, 1.5f, -3.0f, new Item.Properties())
    );

    public static final RegistryObject<Item> SPAMDISC = ITEMS.register("spamdisc", 
        () -> new RecordItem(15, ModSounds.SPAMTRACK.getHolder().get(), 
            new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2840)
    );

    public void init(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
} 