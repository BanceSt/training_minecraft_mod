package net.chakox.trainingmod.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddItemModifiers extends LootModifier {

    public static final MapCodec<AddItemModifiers> CODEC =
            RecordCodecBuilder.mapCodec(
                    inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec().fieldOf("item")
                            .forGetter(m -> m.item)).apply(inst, AddItemModifiers::new));

    private final Item item;

    public AddItemModifiers(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> objectArrayList, LootContext lootContext) {
        for(LootItemCondition condition : this.conditions){
            if(!condition.test(lootContext)){
                return objectArrayList;
            }
        }
        objectArrayList.add(new ItemStack(this.item));
        return objectArrayList;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
