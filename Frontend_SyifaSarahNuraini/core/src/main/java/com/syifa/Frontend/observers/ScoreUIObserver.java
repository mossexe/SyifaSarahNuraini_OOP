package com.syifa.frontend.observers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;

public class ScoreUIObserver implements Observer {
    private BitmapFont font;
    private SpriteBatch batch;

    public ScoreUIObserver() {
        this.font = new BitmapFont();
        this.font.setColor(Color.WHITE);
        this.batch = new SpriteBatch();
    }

    @Override
    public void update(int score) {
        System.out.println("Score has been updated to: " + score);
    }

    public void render(int score) {
        batch.begin();
        font.draw(batch, "Score: " + score, 10,
            com.badlogic.gdx.Gdx.graphics.getHeight() - 10);
        batch.end();
    }

    public void dispose() {
        font.dispose();
        batch.dispose();
    }
}
