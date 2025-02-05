package net.chakox.trainingmod.datagen;

import net.chakox.trainingmod.TrainingMod;
import net.chakox.trainingmod.block.ModBlocks;
import net.chakox.trainingmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
            ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModBlocks.END_STONE_SAPPHIRE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }



    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        oreBlasting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        oreSmelting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 400, "sapphire");

        oreSmelting(recipeOutput, List.of(ModBlocks.RAW_SAPPHIRE_BLOCK.get()), RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get(), 2.25f, 3600, "sapphire_block");
        oreBlasting(recipeOutput, List.of(ModBlocks.RAW_SAPPHIRE_BLOCK.get()), RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get(), 2.25f, 900, "sapphire_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.RAW_SAPPHIRE.get()), has(ModItems.RAW_SAPPHIRE.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_SAPPHIRE.get(), 9)
                .requires(ModBlocks.RAW_SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_SAPPHIRE_BLOCK.get()), has(ModBlocks.RAW_SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);

        // Decorative block craft
        stairBuilder( ModBlocks.SAPPHIRE_STAIR.get(), Ingredient.of(ModBlocks.SAPPHIRE_BLOCK.get()),12)
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);
        slab( recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_SLAB.get(), ModBlocks.SAPPHIRE_BLOCK.get(), 12);

        fenceBuilder( ModBlocks.SAPPHIRE_FENCE.get(), Ingredient.of(ModBlocks.SAPPHIRE_BLOCK.get()), ModItems.SAPPHIRE.get(), 6)
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);
        fenceGateBuilder( ModBlocks.SAPPHIRE_FENCE_GATE.get(), Ingredient.of(ModBlocks.SAPPHIRE_BLOCK.get()), ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);
        wall( recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_WALL.get(), ModBlocks.SAPPHIRE_BLOCK.get(), 12);

        buttonBuilder(ModBlocks.SAPPHIRE_BUTTON.get(), Ingredient.of(ModBlocks.SAPPHIRE_BLOCK.get()))
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.SAPPHIRE_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.SAPPHIRE_BLOCK.get()))
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);

        doorBuilder(ModBlocks.SAPPHIRE_DOOR.get(), Ingredient.of(ModBlocks.SAPPHIRE_BLOCK.get()), 6)
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);
        trapdoorBuilder(ModBlocks.SAPPHIRE_TRAP_DOOR.get(), Ingredient.of(ModBlocks.SAPPHIRE_BLOCK.get()), 6)
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);

    }

    protected static RecipeBuilder buttonBuilder(ItemLike pButton, Ingredient pMaterial) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, pButton).requires(pMaterial);
    }

    protected static RecipeBuilder doorBuilder(ItemLike pDoor, Ingredient pMaterial, int pCount) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pDoor, pCount).define('#', pMaterial).pattern("##").pattern("##").pattern("##");
    }

    protected static RecipeBuilder fenceBuilder(ItemLike pFence, Ingredient pMaterial, ItemLike pMateriel2, int pCount) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pFence, pCount).define('W', pMaterial).define('#', pMateriel2).pattern("W#W").pattern("W#W");
    }

    protected static RecipeBuilder fenceGateBuilder(ItemLike pFenceGate, Ingredient pMaterial, ItemLike pMateriel2) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pFenceGate).define('#', pMateriel2).define('W', pMaterial).pattern("#W#").pattern("#W#");
    }

    protected static void pressurePlate(RecipeOutput pRecipeOutput, ItemLike pPressurePlate, ItemLike pMaterial) {
        pressurePlateBuilder(RecipeCategory.REDSTONE, pPressurePlate, Ingredient.of(new ItemLike[]{pMaterial})).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pRecipeOutput);
    }

    protected static RecipeBuilder pressurePlateBuilder(RecipeCategory pCategory, ItemLike pPressurePlate, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(pCategory, pPressurePlate).define('#', pMaterial).pattern("##");
    }

    protected static void slab(RecipeOutput pRecipeOutput, RecipeCategory pCategory, ItemLike pSlab, ItemLike pMaterial, int pCount) {
        slabBuilder(pCategory, pSlab, Ingredient.of(new ItemLike[]{pMaterial}), pCount).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pRecipeOutput);
    }

    protected static RecipeBuilder slabBuilder(RecipeCategory pCategory, ItemLike pSlab, Ingredient pMaterial, int pCount) {
        return ShapedRecipeBuilder.shaped(pCategory, pSlab, pCount).define('#', pMaterial).pattern("###");
    }

    protected static RecipeBuilder stairBuilder(ItemLike pStairs, Ingredient pMaterial, int pCount) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, pStairs, pCount).define('#', pMaterial).pattern("#  ").pattern("## ").pattern("###");
    }

    protected static RecipeBuilder trapdoorBuilder(ItemLike pTrapdoor, Ingredient pMaterial, int pCount) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pTrapdoor, pCount).define('#', pMaterial).pattern("###").pattern("###");
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void wall(RecipeOutput pRecipeOutput, RecipeCategory pCategory, ItemLike pWall, ItemLike pMaterial, int pCount) {
        wallBuilder(pCategory, pWall, Ingredient.of(new ItemLike[]{pMaterial}), pCount).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pRecipeOutput);
    }

    protected static RecipeBuilder wallBuilder(RecipeCategory pCategory, ItemLike pWall, Ingredient pMaterial, int pCount) {
        return ShapedRecipeBuilder.shaped(pCategory, pWall, pCount).define('#', pMaterial).pattern("###").pattern("###");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.
                    generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, TrainingMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }


}
