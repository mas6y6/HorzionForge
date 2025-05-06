package com.mas6y6.horzion.tools;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import com.mas6y6.horzion.Horzion;


public enum AiriumToolMaterial implements Tier {
    INSTANCE;

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getUses() {
        return 1561;
    }

    @Override
    public float getSpeed() {
        return 8.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 3.0f;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Horzion.RAW_AIRIUM.get());
    }
}