package com.me.tft_02.duel.runnables;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.me.tft_02.duel.datatypes.player.PlayerData;
import com.me.tft_02.duel.util.RegionUtils;
import com.me.tft_02.duel.util.player.DuelManager;

public class RegionCheckTask extends BukkitRunnable {

    @Override
    public void run() {
        checkRegion();
    }

    public void checkRegion() {
        for (Player player : PlayerData.getDuelingPlayers()) {
            Location location = player.getLocation();

            if (!RegionUtils.canDuelHere(location)) {
                DuelManager.endDuelInTie(player);
                return;
            }
        }
    }
}
