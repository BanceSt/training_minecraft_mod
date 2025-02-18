package net.chakox.trainingmod.item;


import net.chakox.trainingmod.TrainingMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;

public class ModArmorMaterials  {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, TrainingMod.MOD_ID);

    public static final RegistryObject<ArmorMaterial> SAPPHIRE_MATERIAL = ARMOR_MATERIALS.register("sapphire",
            () -> new ArmorMaterial(
                    Map.of( ArmorItem.Type.HELMET, 3,
                            ArmorItem.Type.CHESTPLATE, 6,
                            ArmorItem.Type.LEGGINGS, 8,
                            ArmorItem.Type.BOOTS, 3),
                            15,
                    SoundEvents.ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.of(ModItems.SAPPHIRE.get()),
                    List.of(new ArmorMaterial.Layer(new ResourceLocation("trainingmod", "sapphire"))),
                    0.0f, 0.0f));



    public static Holder<ArmorMaterial> getHolder(RegistryObject<ArmorMaterial> registryObject){
        return registryObject.getHolder().orElseThrow(()-> new RuntimeException("Armor material " + registryObject.getKey() + " not found!"));
    }



    public static void register(IEventBus eventBus){
        ARMOR_MATERIALS.register(eventBus);
    }
}
