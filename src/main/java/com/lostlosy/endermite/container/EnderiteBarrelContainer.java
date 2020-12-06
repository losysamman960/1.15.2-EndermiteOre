package com.lostlosy.endermite.container;

import com.lostlosy.endermite.init.ModBlocks;
import com.lostlosy.endermite.init.ModContainerTypes;
import com.lostlosy.endermite.tileentity.EnderiteBarrelTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.items.SlotItemHandler;

import java.util.Objects;

public class EnderiteBarrelContainer extends Container {

    public final EnderiteBarrelTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public EnderiteBarrelContainer(final int windowId, final PlayerInventory playerInventory, final EnderiteBarrelTileEntity tileEntity) {
        super(ModContainerTypes.ENDERITE_BARREL.get(), windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(Objects.requireNonNull(tileEntity.getWorld()), tileEntity.getPos());

        tileEntity.players++;
        tileEntity.playSound(SoundEvents.BLOCK_BARREL_OPEN);

        //Main Inventory
        int startX = 8;
        int startY = 19;
        int slotSize2 = 18;
        for (int row = 0; row < 5; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new SlotItemHandler(tileEntity.itemHandler, (row * 9) + column, startX + (column * slotSize2), startY + (row * slotSize2)));
            }
        }
        //Main Player Inventory
        int startPlayerInvY = startY * 5 + 28;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * slotSize2), startPlayerInvY + (row * slotSize2)));

            }
        }
        //HotBar
        int hotbarY = startPlayerInvY + 58;
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, startX + (column * slotSize2), hotbarY));
        }
    }


    private static EnderiteBarrelTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof EnderiteBarrelTileEntity) {
            return (EnderiteBarrelTileEntity) tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    public EnderiteBarrelContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }


    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.ENDERITE_BARREL.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < 45) {
                if (!this.mergeItemStack(itemstack1, 45, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 45, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }
}