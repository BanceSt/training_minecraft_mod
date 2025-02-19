package net.chakox.trainingmod.loot;


import com.mojang.serialization.MapCodec;
import net.chakox.trainingmod.TrainingMod;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, TrainingMod.MOD_ID);

    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> ADD_ITEM_MODIFIER =
            LOOT_MODIFIER_SERIALIZERS.register("add_item", () -> AddItemModifiers.CODEC);
    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> ADD_SUS_SAND_ITEM_MODIFIER =
            LOOT_MODIFIER_SERIALIZERS.register("add_sus_sand_item", () -> AddSusSandItemModifiers.CODEC);

    public static void register(IEventBus eventBus){
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}
