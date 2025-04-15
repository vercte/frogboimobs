package net.vercte.frogboimobs.content.item;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.vercte.frogboimobs.ModSounds;
import org.jetbrains.annotations.NotNull;

public class PartyHornItem extends Item {
    public PartyHornItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }

    @Override
    @NotNull
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        player.playSound(ModSounds.PARTY_HORN.get(), 0.8f, 1 + (float)(Math.random() * 0.14f - 0.07f));
        player.startUsingItem(interactionHand);
        player.getCooldowns().addCooldown(this, 40);
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.success(player.getItemInHand(interactionHand));
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntity) {
        return 60;
    }

    @Override
    @NotNull
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.TOOT_HORN;
    }
}
