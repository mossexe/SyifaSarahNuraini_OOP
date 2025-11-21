package com.syifa.frontend.states;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.syifa.frontend.strategies.DifficultyStrategy;

public class DifficultyTransitionState implements GameState {
    private final GameStateManager gsm;
    private final PlayingState playingState;
    private final DifficultyStrategy newStrategy;
    private final BitmapFont font;
    private float timer;

    public DifficultyTransitionState(GameStateManager gsm, PlayingState playingState, DifficultyStrategy newStrategy) {
        this.gsm = gsm;
        this.playingState = playingState;
        this.newStrategy = newStrategy;
        this.font = new BitmapFont();
        this.timer = 2.0f;
    }

    @Override
    public void update(float delta) {
        timer -= delta;
        if (timer <= 0) {
            playingState.setDifficulty(newStrategy);
            gsm.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        playingState.render(batch);

        batch.begin();
        String message = "DIFFICULTY INCREASED!";
        String strategyName = newStrategy.getClass().getSimpleName();

        float messageWidth = font.getXHeight() * message.length();
        float nameWidth = font.getXHeight() * strategyName.length();

        font.draw(batch, message,
            (com.badlogic.gdx.Gdx.graphics.getWidth() - messageWidth) / 2,
            com.badlogic.gdx.Gdx.graphics.getHeight() / 2 + 20);
        font.draw(batch, strategyName,
            (com.badlogic.gdx.Gdx.graphics.getWidth() - nameWidth) / 2,
            com.badlogic.gdx.Gdx.graphics.getHeight() / 2 - 20);
        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
