package com.spikespaz.essentialadditions.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;

public class EyeOre extends BaseBlock{

    public EyeOre(Material material, String unlocalizedName, Float hardness,
                  Float resistance, String tool, Integer mineLevel, CreativeTabs creativeTab){
        super(material,unlocalizedName,hardness,resistance,tool,mineLevel,creativeTab);
    }


    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> arrayList= new ArrayList<ItemStack>();
        arrayList.add(new ItemStack(Items.ender_pearl));
        arrayList.add(new ItemStack(Items.blaze_powder));
        return arrayList;
    }

    @Override
    public void onBlockPreDestroy(World world, int x, int y, int z, int p_149725_5_) {
        if(!world.isRemote){
            dropStuff(world,x,y,z);
        }
    }



    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return !(entity instanceof EntityDragon);
    }


    //I have added some doubles to make the drops look natural.
    private void dropStuff(World world,int x,int y,int z){

        for (int i = 0; i <this.getDrops(world,x,y,z,0,0).size() ; i++) {
            float f = 0.5F;
            double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            world.spawnEntityInWorld(new EntityItem(world, x+d0, y+d1,z+d2, this.getDrops(world,x,y,z,0,0).get(i)));

        }

    }


}