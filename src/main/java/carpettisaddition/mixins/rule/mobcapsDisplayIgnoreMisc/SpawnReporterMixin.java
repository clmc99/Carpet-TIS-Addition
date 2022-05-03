package carpettisaddition.mixins.rule.mobcapsDisplayIgnoreMisc;

import carpet.utils.SpawnReporter;
import carpettisaddition.CarpetTISAdditionSettings;
import net.minecraft.entity.EntityCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;

@Mixin(SpawnReporter.class)
public abstract class SpawnReporterMixin
{
	@Redirect(
			method = "printMobcapsForDimension",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/entity/EntityCategory;values()[Lnet/minecraft/entity/EntityCategory;"
			),
			require = 0
	)
	private static EntityCategory[] mobcapsDisplayIgnoreMisc()
	{
		EntityCategory[] values = EntityCategory.values();
		if (CarpetTISAdditionSettings.mobcapsDisplayIgnoreMisc)
		{
			values = Arrays.stream(values).
					filter(entityCategory -> entityCategory != EntityCategory.MISC).
					toArray(EntityCategory[]::new);
		}
		return values;
	}
}