package net.chakox.trainingmod.item;

import net.chakox.trainingmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier SAPPHIRE = new ForgeTier(
            5000,
            8.0f,
            4.0f,
            22,
            ModTags.Blocks.NEED_SAPPHIRE_TOOL,
            () -> Ingredient.of(ModItems.SAPPHIRE.get()),
            ModTags.Blocks.NONE_BLOCK
    );
}
