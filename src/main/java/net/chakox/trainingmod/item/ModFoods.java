package net.chakox.trainingmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().fast()
            .nutrition(2).saturationModifier(0.2f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.5f).build();
}
