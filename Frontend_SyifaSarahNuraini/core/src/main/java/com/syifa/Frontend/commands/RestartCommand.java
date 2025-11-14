package com.syifa.frontend.commands;

import com.syifa.frontend.GameManager;
import com.syifa.frontend.Player;

import static com.badlogic.gdx.graphics.Colors.reset;

public class RestartCommand {
    public Player player;
    public GameManager gameManager;

    public RestartCommand (Player player, GameManager gameManager){
        this.player = player;
        this.gameManager = gameManager;
    }

    public void execute(){
        player.reset();
        gameManager.setScore(0);
    }
}
