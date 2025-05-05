package com.mas6y6.horzion.tools;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class HorzionToolMaterial implements Tier {
    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getUses() {
        return 2000;
    }

    @Override
    public float getSpeed() {
        return 7.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 4.0f;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Horzion.RAW_HORZION.get());
    }
}