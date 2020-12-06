package com.lostlosy.endermite.init;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.container.EnderiteBarrelContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, EndermiteMod.MOD_ID);

    public static final RegistryObject<ContainerType<EnderiteBarrelContainer>> ENDERITE_BARREL = CONTAINER_TYPES.register("enderite_barrel",
            () -> IForgeContainerType.create(EnderiteBarrelContainer::new));
}
