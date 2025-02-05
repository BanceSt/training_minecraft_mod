package net.chakox.trainingmod.datagen;


import net.chakox.trainingmod.datagen.loot.ModBlockLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider{
    public static LootTableProvider create(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        return new LootTableProvider(
                packOutput,
                Set.of(), // Paramètre des types de loot
                List.of(  // Liste des sous-fournisseurs (SubProviders)
                        new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
                ),
                lookupProvider
        );
    }
}
