/*
 * Requiem
 * Copyright (C) 2017-2021 Ladysnake
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses>.
 *
 * Linking this mod statically or dynamically with other
 * modules is making a combined work based on this mod.
 * Thus, the terms and conditions of the GNU General Public License cover the whole combination.
 *
 * In addition, as a special exception, the copyright holders of
 * this mod give you permission to combine this mod
 * with free software programs or libraries that are released under the GNU LGPL
 * and with code included in the standard release of Minecraft under All Rights Reserved (or
 * modified versions of such code, with unchanged license).
 * You may copy and distribute such a system following the terms of the GNU GPL for this mod
 * and the licenses of the other code concerned.
 *
 * Note that people who make modified versions of this mod are not obligated to grant
 * this special exception for their modified versions; it is their choice whether to do so.
 * The GNU General Public License gives permission to release a modified version without this exception;
 * this exception also makes it possible to release a modified version which carries forward this exception.
 */
package ladysnake.requiem.common.item;

import ladysnake.requiem.common.entity.RequiemEntityAttributes;
import net.minecraft.Bootstrap;
import net.minecraft.SharedConstants;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class EmptySoulVesselItemTest {

    @BeforeClass
    public static void setUp() {
        SharedConstants.createGameVersion();
        Bootstrap.initialize();
    }

    @Test
    public void computeSoulDefense() {
        LivingEntity piglinBrute = Mockito.mock(LivingEntity.class);
        AttributeContainer attributes = Mockito.mock(AttributeContainer.class);
        Mockito.when(attributes.hasAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE)).thenReturn(true);
        Mockito.when(piglinBrute.getAttributeValue(RequiemEntityAttributes.SOUL_DEFENSE)).thenReturn(0.0);
        Mockito.when(piglinBrute.getAttributeBaseValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)).thenReturn(7.0);
        Mockito.when((double) piglinBrute.getMaxHealth()).thenReturn(50.0);
        Mockito.when(piglinBrute.getHealth()).thenReturn(50.0F);
        Mockito.when(piglinBrute.getAttributes()).thenReturn(attributes);
        System.out.println(EmptySoulVesselItem.computeSoulDefense(piglinBrute));    // "integration testing"
        Mockito.when(piglinBrute.getHealth()).thenReturn(1.0F);
        System.out.println(EmptySoulVesselItem.computeSoulDefense(piglinBrute));    // "integration testing"
    }
}
