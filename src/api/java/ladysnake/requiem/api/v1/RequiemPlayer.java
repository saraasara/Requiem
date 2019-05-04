/*
 * Requiem
 * Copyright (C) 2019 Ladysnake
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
 */
package ladysnake.requiem.api.v1;

import ladysnake.requiem.api.v1.dialogue.DialogueTracker;
import ladysnake.requiem.api.v1.entity.MovementAlterer;
import ladysnake.requiem.api.v1.possession.PossessionComponent;
import ladysnake.requiem.api.v1.remnant.DeathSuspender;
import ladysnake.requiem.api.v1.remnant.RemnantState;
import net.minecraft.entity.player.PlayerEntity;

/**
 * Implemented by {@link PlayerEntity players}.
 */
public interface RequiemPlayer {

    /**
     * @return the player's remnant state
     */
    RemnantState getRemnantState();

    void setRemnantState(RemnantState state);

    /**
     * @return the player's movement alterer
     */
    MovementAlterer getMovementAlterer();

    /**
     * @return the player's possession component
     */
    PossessionComponent getPossessionComponent();

    void setRemnant(boolean remnant);

    boolean isRemnant();

    DeathSuspender getDeathSuspender();

    DialogueTracker getDialogueTracker();
}
