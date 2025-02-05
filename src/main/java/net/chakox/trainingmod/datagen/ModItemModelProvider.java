package net.chakox.trainingmod.datagen;

import net.chakox.trainingmod.TrainingMod;
import net.chakox.trainingmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TrainingMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
