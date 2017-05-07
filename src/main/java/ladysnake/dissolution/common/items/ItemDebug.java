package ladysnake.dissolution.common.items;

import java.util.List;

import ladysnake.dissolution.common.Reference;
import ladysnake.dissolution.common.capabilities.IncorporealDataHandler;
import ladysnake.dissolution.common.compat.CrystallizerRecipeCategory;
import ladysnake.dissolution.common.entity.EntityMinion;
import ladysnake.dissolution.common.entity.EntityMinionZombie;
import ladysnake.dissolution.common.handlers.CustomTartarosTeleporter;
import ladysnake.dissolution.common.init.ModBlocks;
import mezz.jei.api.gui.IDrawableAnimated.StartDirection;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemDebug extends Item {

	public ItemDebug() {
		super();
		this.setUnlocalizedName(Reference.Items.DEBUG.getUnlocalizedName());
        this.setRegistryName(Reference.Items.DEBUG.getRegistryName());
        this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		int debugWanted = 2;
		switch(debugWanted) {
		case 0 : 
			playerIn.sendStatusMessage(new TextComponentTranslation("dissolution.jei.recipe.crystallizer", new Object[0]), true);
			break;
		case 1 :	
			IncorporealDataHandler.getHandler(playerIn).setIncorporeal(!IncorporealDataHandler.getHandler(playerIn).isIncorporeal(), playerIn);
			break;
		case 2 :
			if(!playerIn.world.isRemote)
				CustomTartarosTeleporter.transferPlayerToDimension((EntityPlayerMP) playerIn, playerIn.dimension == -1 ? 0 : -1);
			break;
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
