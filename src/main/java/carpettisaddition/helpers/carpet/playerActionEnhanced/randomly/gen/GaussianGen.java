/*
 * This file is part of the Carpet TIS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2023  Fallen_Breath and contributors
 *
 * Carpet TIS Addition is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Carpet TIS Addition is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Carpet TIS Addition.  If not, see <https://www.gnu.org/licenses/>.
 */

package carpettisaddition.helpers.carpet.playerActionEnhanced.randomly.gen;

public class GaussianGen extends RandomGen
{
	private final double mu;
	private final double sigma;

	public GaussianGen(double mu, double sigma2)
	{
		if (sigma2 <= 0)
		{
			throw new RuntimeException("sigma2 < 0");
		}
		this.mu = mu;
		this.sigma = Math.sqrt(sigma2);
	}

	@Override
	protected double generate()
	{
		return this.mu + this.sigma * this.random.nextGaussian();
	}
}