package com.spikespaz.blocks;

import com.spikespaz.items.ModItems;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;


public class SulfurBlock
  extends Block
{
  protected SulfurBlock(Material sulfur)
  {
    super(sulfur);
    setHardness(0.4F);
    setResistance(3.0F);
    setHarvestLevel("picaxe", 0);
  }


  public Item getItemDropped(int par1, Random random, int par2)
  {
    return ModItems.Sulfur;
  }

  public int quantityDropped(Random par1Random)
  {
    return 4;
  }
}


/* Location:              C:\Users\spike\Desktop\EssentialAdditions_1.2.8-1.7.10-deobf.jar!\com\spikespaz\blocks\SulfurBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */