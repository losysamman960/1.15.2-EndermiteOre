package com.lostlosy.endermite.blocks;

import com.lostlosy.endermite.init.ModTileEntityTypes;
import com.lostlosy.endermite.tileentity.EnderiteBarrelTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class EnderiteWorkBench extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(2, 0, 2, 14, 4, 14), Block.makeCuboidShape(4, 4, 3, 12, 5, 13),
            Block.makeCuboidShape(6, 5, 4, 10, 10, 12), Block.makeCuboidShape(3, 10, 0, 13, 16, 16),
            Block.makeCuboidShape(4, 7, 4, 5, 8, 12), Block.makeCuboidShape(5, 7, 3, 6, 8, 4),
            Block.makeCuboidShape(6, 7, 2, 10, 8, 3), Block.makeCuboidShape(10, 7, 3, 11, 8, 4),
            Block.makeCuboidShape(11, 7, 4, 12, 8, 12), Block.makeCuboidShape(5, 7, 12, 6, 8, 13),
            Block.makeCuboidShape(10, 7, 12, 11, 8, 13), Block.makeCuboidShape(6, 7, 13, 10, 8, 14),
            Block.makeCuboidShape(5, 5, 9, 6, 9, 10), Block.makeCuboidShape(5, 9, 8, 6, 10, 11),
            Block.makeCuboidShape(5, 8, 7, 6, 9, 8), Block.makeCuboidShape(5, 8, 11, 6, 9, 12),
            Block.makeCuboidShape(10, 8, 4, 11, 9, 7), Block.makeCuboidShape(10, 5, 5, 11, 8, 6)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(2, 0, 2, 14, 4, 14), Block.makeCuboidShape(3, 4, 4, 13, 5, 12),
            Block.makeCuboidShape(4, 5, 6, 12, 10, 10), Block.makeCuboidShape(0, 10, 3, 16, 16, 13),
            Block.makeCuboidShape(4, 7, 4, 12, 8, 5), Block.makeCuboidShape(12, 7, 5, 13, 8, 6),
            Block.makeCuboidShape(13, 7, 6, 14, 8, 10), Block.makeCuboidShape(12, 7, 10, 13, 8, 11),
            Block.makeCuboidShape(4, 7, 11, 12, 8, 12), Block.makeCuboidShape(3, 7, 5, 4, 8, 6),
            Block.makeCuboidShape(3, 7, 10, 4, 8, 11), Block.makeCuboidShape(2, 7, 6, 3, 8, 10),
            Block.makeCuboidShape(6, 5, 5, 7, 9, 6), Block.makeCuboidShape(5, 9, 5, 8, 10, 6),
            Block.makeCuboidShape(8, 8, 5, 9, 9, 6), Block.makeCuboidShape(4, 8, 5, 5, 9, 6),
            Block.makeCuboidShape(9, 8, 10, 12, 9, 11), Block.makeCuboidShape(10, 5, 10, 11, 8, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(2, 0, 2, 14, 4, 14), Block.makeCuboidShape(4, 4, 3, 12, 5, 13),
            Block.makeCuboidShape(6, 5, 4, 10, 10, 12), Block.makeCuboidShape(3, 10, 0, 13, 16, 16),
            Block.makeCuboidShape(11, 7, 4, 12, 8, 12), Block.makeCuboidShape(10, 7, 12, 11, 8, 13),
            Block.makeCuboidShape(6, 7, 13, 10, 8, 14), Block.makeCuboidShape(5, 7, 12, 6, 8, 13),
            Block.makeCuboidShape(4, 7, 4, 5, 8, 12), Block.makeCuboidShape(10, 7, 3, 11, 8, 4),
            Block.makeCuboidShape(5, 7, 3, 6, 8, 4), Block.makeCuboidShape(6, 7, 2, 10, 8, 3),
            Block.makeCuboidShape(10, 5, 6, 11, 9, 7), Block.makeCuboidShape(10, 9, 5, 11, 10, 8),
            Block.makeCuboidShape(10, 8, 8, 11, 9, 9), Block.makeCuboidShape(10, 8, 4, 11, 9, 5),
            Block.makeCuboidShape(5, 8, 9, 6, 9, 12), Block.makeCuboidShape(5, 5, 10, 6, 8, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(2, 0, 2, 14, 4, 14), Block.makeCuboidShape(3, 4, 4, 13, 5, 12),
            Block.makeCuboidShape(4, 5, 6, 12, 10, 10), Block.makeCuboidShape(0, 10, 3, 16, 16, 13),
            Block.makeCuboidShape(4, 7, 11, 12, 8, 12), Block.makeCuboidShape(3, 7, 10, 4, 8, 11),
            Block.makeCuboidShape(2, 7, 6, 3, 8, 10), Block.makeCuboidShape(3, 7, 5, 4, 8, 6),
            Block.makeCuboidShape(4, 7, 4, 12, 8, 5), Block.makeCuboidShape(12, 7, 10, 13, 8, 11),
            Block.makeCuboidShape(12, 7, 5, 13, 8, 6), Block.makeCuboidShape(13, 7, 6, 14, 8, 10), Block.makeCuboidShape(9, 5, 10, 10, 9, 11),
            Block.makeCuboidShape(8, 9, 10, 11, 10, 11), Block.makeCuboidShape(7, 8, 10, 8, 9, 11),
            Block.makeCuboidShape(11, 8, 10, 12, 9, 11), Block.makeCuboidShape(4, 8, 5, 7, 9, 6), Block.makeCuboidShape(5, 5, 5, 6, 8, 6)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public EnderiteWorkBench() {
        super(Block.Properties.create(Material.ANVIL)
                .hardnessAndResistance(5.0f, 5.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)     {
        builder.add(FACING);
    }
}



