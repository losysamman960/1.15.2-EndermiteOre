package com.lostlosy.endermite.init;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.tileentity.EnderiteBarrelTileEntity;
import com.lostlosy.endermite.tileentity.QuarryTileEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES =
            new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, EndermiteMod.MOD_ID);

    public static final RegistryObject<TileEntityType<QuarryTileEntity>>
            QUARRY = TILE_ENTITY_TYPES.register("quarry",
            () -> TileEntityType.Builder.create(QuarryTileEntity::new,
                    ModBlocks.QUARRY.get()).build(null));

    public static final RegistryObject<TileEntityType<EnderiteBarrelTileEntity>>
            ENDERITE_BARREL = TILE_ENTITY_TYPES.register("enderite_barrel",
            () -> TileEntityType.Builder.create(EnderiteBarrelTileEntity::new,
                    ModBlocks.ENDERITE_BARREL.get()).build(null));
}
