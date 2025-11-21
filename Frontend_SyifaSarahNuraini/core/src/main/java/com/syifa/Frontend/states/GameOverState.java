package com.syifa.frontend.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState implements GameState{
    private final GameStateManager gsm;
    private final BitmapFont font;

    public GameOverState(GameStateManager gsm, BitmapFont font){
        this.gsm = gsm;
        this.font = new BitmapFont();
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            gsm.set(new PlayingState(gsm))
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        font.draw(batch, "Game Over", Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-200)
        font.draw(batch, "Press SPACE to restart", Gdx.graphics.getWidth()+200, Gdx.graphics.getHeight()+200)
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
