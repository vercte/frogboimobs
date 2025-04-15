package net.vercte.frogboimobs;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.vercte.frogboimobs.content.item.PartyHornItem;
import net.vercte.frogboimobs.platform.Services;

import java.util.function.Supplier;

public class ModItems {
    public static final Supplier<PartyHornItem> PARTY_HORN = register("party_horn", PartyHornItem::new);

    public static <T extends Item> Supplier<T> register(String id, Supplier<T> item) {
        return Services.REGISTRY.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void initialize() {}
}
