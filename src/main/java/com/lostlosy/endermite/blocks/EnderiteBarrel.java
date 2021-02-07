package com.lostlosy.endermite.blocks;

import com.lostlosy.endermite.init.ModTileEntityTypes;
import com.lostlosy.endermite.tileentity.EnderiteBarrelTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

public class EnderiteBarrel extends Block {


    public EnderiteBarrel() {
        super(Block.Properties.create(Material.WOOD)
                .hardnessAndResistance(1f, 1f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE));

    }
        @Override
        public boolean hasTileEntity(BlockState state) {
            return true;
        }

        @Override
        public TileEntity createTileEntity(BlockState state, IBlockReader world) {
            return ModTileEntityTypes.ENDERITE_BARREL.get().create();
        }
        @Override
        public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand
        handIn, BlockRayTraceResult result) {
            if(!worldIn.isRemote) {
                TileEntity tile = worldIn.getTileEntity(pos);
                if(tile instanceof EnderiteBarrelTileEntity) {
                    NetworkHooks.openGui((ServerPlayerEntity)player, (EnderiteBarrelTileEntity)tile, pos);
                    return ActionResultType.SUCCESS;
                }
            }
            return ActionResultType.SUCCESS;
        }

        @Override
        public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
            if(state.getBlock() != newState.getBlock()) {
                TileEntity te = worldIn.getTileEntity(pos);
                if(te instanceof EnderiteBarrelTileEntity) {
                    EnderiteBarrelTileEntity enderiteBarrelTileEntity = (EnderiteBarrelTileEntity) te;

                    dropItems(enderiteBarrelTileEntity, worldIn, pos);

                }
            }
            super.onReplaced(state, worldIn, pos, newState, isMoving);
    }

    private void dropItems(EnderiteBarrelTileEntity enderiteBarrelTileEntity, World worldIn, BlockPos pos) {
    }
}

