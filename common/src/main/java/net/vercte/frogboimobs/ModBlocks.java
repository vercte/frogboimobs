package net.vercte.frogboimobs;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.vercte.frogboimobs.platform.Services;

import java.util.function.Supplier;

public class ModBlocks {
    public static final Supplier<Block> TEST = register("test", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static <T extends Block> Supplier<T> register(String id, Supplier<T> block) {
        return Services.REGISTRY.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {}
}
