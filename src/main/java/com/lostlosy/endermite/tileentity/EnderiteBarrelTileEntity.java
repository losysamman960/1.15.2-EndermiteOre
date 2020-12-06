package com.lostlosy.endermite.tileentity;

import com.lostlosy.endermite.blocks.EnderiteBarrel;
import com.lostlosy.endermite.container.EnderiteBarrelContainer;
import com.lostlosy.endermite.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class EnderiteBarrelTileEntity extends TileEntity implements INamedContainerProvider {
    private final LazyOptional<ItemStackHandler> optional = LazyOptional.of(() -> this.itemHandler);
    public int size = 45;
    public final ItemStackHandler itemHandler = createHandler(size);
    public int players = 0;

    public EnderiteBarrelTileEntity() {
        super(ModTileEntityTypes.ENDERITE_BARREL.get());
    }

    private ItemStackHandler createHandler(int size) {
        return new ItemStackHandler(size) {
            @Override
            protected void onContentsChanged(int slot) {
                super.onContentsChanged(slot);
                markDirty();
            }
        };
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent(this.getBlockState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
        return new EnderiteBarrelContainer(id, playerInventory, this);
    }

    public void playSound(SoundEvent soundEvent) {
        if (this.getBlockState().getBlock() instanceof EnderiteBarrel) {
            double x = this.pos.getX() + 0.5D;
            double y = this.pos.getY() + 0.5D;
            double z = this.pos.getZ() + 0.5D;
            if (this.world != null) {
                this.world.playSound(null, x, y, z, soundEvent,
                        SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1F + 0.9F);
            }
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        optional.ifPresent(h -> nbt.put("inv", h.serializeNBT()));
        itemHandler.serializeNBT();
        return super.write(nbt);
    }

    @Override
    public void read(CompoundNBT nbt) {
        optional.ifPresent(h -> h.deserializeNBT(nbt.getCompound("inv")));
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(nbt);
}

    @Override
    public CompoundNBT getUpdateTag() {
        return super.write(new CompoundNBT());
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbt = new CompoundNBT();
        this.write(nbt);

        return new SUpdateTileEntityPacket(this.pos, 0, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.read(pkt.getNbtCompound());
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return optional.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void remove() {
        super.remove();
        this.optional.invalidate();
    }
}

