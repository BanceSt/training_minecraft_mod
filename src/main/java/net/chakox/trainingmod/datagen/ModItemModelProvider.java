package net.chakox.trainingmod.datagen;

import net.chakox.trainingmod.TrainingMod;
import net.chakox.trainingmod.block.ModBlocks;
import net.chakox.trainingmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TrainingMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.PINE_CONE);
        simpleItem(ModItems.RAW_SAPPHIRE);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.STRAWBERRY);

        simpleBlockItem(ModBlocks.SAPPHIRE_DOOR);

        evenSimplerBlockItem(ModBlocks.SAPPHIRE_STAIR);
        evenSimplerBlockItem(ModBlocks.SAPPHIRE_SLAB);
        evenSimplerBlockItem(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.SAPPHIRE_FENCE_GATE);

        fenceInventory("sapphire_fence", modLoc("block/sapphire_block"));
        buttonInventory("sapphire_button", modLoc("block/sapphire_block"));
        wallInventory("sapphire_wall", modLoc("block/sapphire_block"));
        trapdoorBottom("sapphire_trap_door", modLoc("block/sapphire_trap_door"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TrainingMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TrainingMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TrainingMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
