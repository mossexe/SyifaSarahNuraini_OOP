package com.syifa.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState implements GameState {
    private final GameStateManager gsm;
    private final BitmapFont font;

    public GameOverState(GameStateManager gsm) {
        this.gsm = gsm;
        this.font = new BitmapFont();
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            gsm.set(new PlayingState(gsm));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        String gameOverText = "GAME OVER";
        String restartText = "Press SPACE to restart";

        float gameOverWidth = font.getXHeight() * gameOverText.length();
        float restartWidth = font.getXHeight() * restartText.length();

        font.draw(batch, gameOverText,
            (Gdx.graphics.getWidth() - gameOverWidth) / 2,
            Gdx.graphics.getHeight() / 2 + 20);
        font.draw(batch, restartText,
            (Gdx.graphics.getWidth() - restartWidth) / 2,
            Gdx.graphics.getHeight() / 2 - 20);
        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
