package com.lostlosy.endermite.tileentity;

import com.lostlosy.endermite.init.ModTileEntityTypes;
import com.lostlosy.endermite.util.helpers.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;


public class QuarryTileEntity extends TileEntity implements ITickableTileEntity {

    public int x, y, z, tick;
    boolean initialized = false;

    public QuarryTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);

    }
    public QuarryTileEntity() {
        this(ModTileEntityTypes.QUARRY.get());

    }


    @Override
    public void tick() {
        if(!initialized) init();
        tick++;
        if(tick == 40) {
            tick = 0;
            if(y > 2) execute();
        }
    }

    private void init() {
        initialized = true;
        x = this.pos.getX() - 3;
        y = this.pos.getY() - 3;
        z = this.pos.getZ() - 3;
        tick = 0;
    }

    private void execute() {
        int index = 0;
        Block[] blocksRemoved = new Block[9];
        for(int x = 0; x < 3; x++) {
            for(int z = 0; z < 3; z++) {
                BlockPos posToBreak = new BlockPos(this.x + y, this.y + y,this.z + z);
                blocksRemoved[index] = this.world.getBlockState(posToBreak).getBlock();
                destroyBlock(posToBreak, true, null);
                index++;
            }
        }
        this.y--;
    }

    private boolean destroyBlock(BlockPos posToBreak, boolean dropBlock, @Nullable Entity entity) {
        BlockState blockState = world.getBlockState(pos);
        if(blockState.isAir(world, pos)) return false;
        else {
            IFluidState ifluidstate = world.getFluidState(pos);
            world.playEvent(2001, pos, Block.getStateId(blockState));
            if(dropBlock) {
                TileEntity tileEntity = blockState.hasTileEntity() ? world.getTileEntity(pos) : null;
                Block.spawnDrops(blockState, world, this.pos.add(0, 1.5, 0), tileEntity, entity, ItemStack.EMPTY);
            }
            return  world.setBlockState(pos, ifluidstate.getBlockState(), 3);
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("initvalues", NBTHelper.toNBT(this));
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        CompoundNBT initValues = compound.getCompound("initvalues");
        if(initValues != null) {
            this.x = initValues.getInt("x");
            this.y = initValues.getInt("y");
            this.z = initValues.getInt("z");
            initialized = true;
            return;
        }
        init();
    }
}