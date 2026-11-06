package com.cheloviymode.axe;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = 
            DeferredRegister.createBlocks(AxeMod.MOD_ID);

    // Платиновая руда
    public static final DeferredBlock<Block> PLATINUM_ORE = BLOCKS.registerSimpleBlock(
            "platinum_ore",
            BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F) // Прочность как у каменной руды
                    .requiresCorrectToolForDrops() // Требует кирку
                    .sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)
    );
}