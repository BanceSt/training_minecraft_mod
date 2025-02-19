package net.chakox.trainingmod.datagen;

import net.chakox.trainingmod.TrainingMod;
import net.chakox.trainingmod.item.ModItems;
import net.chakox.trainingmod.loot.AddItemModifiers;
import net.chakox.trainingmod.loot.AddSusSandItemModifiers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, TrainingMod.MOD_ID, registries);
    }

    @Override
    protected void start() {
        add("pine_cone_from_short_grass", new AddItemModifiers(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, ModItems.PINE_CONE.get()));

        add("pine_cone_from_tall_grass", new AddItemModifiers(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()
        }, ModItems.PINE_CONE.get()));

        add("pine_cone_from_creeper", new AddItemModifiers(
                new LootItemCondition[] {new LootTableIdCondition.Builder(
                        new ResourceLocation("entities/creeper")).build()
                }, ModItems.PINE_CONE.get()));

        add("metal_detector_from_jungle_temple", new AddItemModifiers(
                new LootItemCondition[] {new LootTableIdCondition.Builder(
                        new ResourceLocation("chests/jungle_temple")).build()
                }, ModItems.METAL_DETECTOR.get()));

        add("metal_detector_from_suspicious_sand", new AddSusSandItemModifiers(
                new LootItemCondition[] {new LootTableIdCondition.Builder(
                        new ResourceLocation("archaeology/desert_pyramid")).build()
                }, ModItems.METAL_DETECTOR.get()));
    }
}
