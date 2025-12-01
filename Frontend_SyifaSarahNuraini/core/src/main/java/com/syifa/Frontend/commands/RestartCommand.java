package com.syifa.frontend.commands;

import com.syifa.frontend.GameManager;
import com.syifa.frontend.Player;

public class RestartCommand implements Command {
    private Player player;
    private GameManager gameManager;

    public RestartCommand(Player player, GameManager gameManager) {
        this.player = player;
        this.gameManager = gameManager;
    }

    @Override
    public void execute() {
        player.reset();
        gameManager.setScore(0);
    }
}
