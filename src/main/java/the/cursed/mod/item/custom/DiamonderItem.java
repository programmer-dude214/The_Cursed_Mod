package the.cursed.mod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class DiamonderItem extends Item {
    private static final Map<Block, Block> DIAMOND_MAP =
            Map.of(
                    Blocks.DIRT, Blocks.DIAMOND_BLOCK,
                    Blocks.GRASS_BLOCK, Blocks.DIAMOND_BLOCK,
                    Blocks.STONE, Blocks.NETHERITE_BLOCK,
                    Blocks.DIAMOND_BLOCK, Blocks.DIRT

            );


    public DiamonderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(DIAMOND_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), DIAMOND_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(01, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_STEP, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}

