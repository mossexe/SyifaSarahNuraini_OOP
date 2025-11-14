package com.syifa.frontend.commands;

import com.badlogic.gdx.Gdx;
import com.syifa.frontend.Player;

public class JetPackCommand implements Command{
    private Player player;

    public JetPackCommand (Player player){
        this.player = player;
    }
    @Override
    public void execute(){
            player.fly(Gdx.graphics.getDeltaTime());
    }
}
