package net.chakox.trainingmod.util;

import net.chakox.trainingmod.TrainingMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEED_SAPPHIRE_TOOL = tag("need_sapphire_tool");
        public static final TagKey<Block> NONE_BLOCK = tag("none_block");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TrainingMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(TrainingMod.MOD_ID, name));
        }
    }
}
