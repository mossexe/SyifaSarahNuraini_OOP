package com.mygame.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MossBoxGame extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private float mossX, mossY;
    private float mossSize = 50;
    private int colorState = 0; // 0=Red, 1=Yellow, 2=Blue
    private float moveSpeed = 200f; // pixels per second

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();

        // Position moss box in center of screen
        mossX = (Gdx.graphics.getWidth() - mossSize) / 2;
        mossY = (Gdx.graphics.getHeight() - mossSize) / 2;

        // Mouse click listener
        Gdx.input.setInputProcessor(new com.badlogic.gdx.InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                cycleColor();
                return true;
            }
        });
    }

    @Override
    public void render() {
        // Clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Handle input
        handleMossMovement();

        // Draw the moss box
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        switch (colorState) {
            case 0: // Red
                shapeRenderer.setColor(1, 0, 0, 1);
                break;
            case 1: // Yellow
                shapeRenderer.setColor(1, 1, 0, 1);
                break;
            case 2: // Blue
                shapeRenderer.setColor(0, 0, 1, 1);
                break;
        }

        shapeRenderer.rect(mossX, mossY, mossSize, mossSize);
        shapeRenderer.end();
    }

    private void handleMossMovement() {
        float delta = Gdx.graphics.getDeltaTime();
        float movement = moveSpeed * delta;

        // Arrow Keys or WASD
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            mossY += movement;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            mossY -= movement;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            mossX -= movement;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            mossX += movement;
        }

        // BONUS: Keep moss box within screen bounds
        mossX = Math.max(0, Math.min(mossX, Gdx.graphics.getWidth() - mossSize));
        mossY = Math.max(0, Math.min(mossY, Gdx.graphics.getHeight() - mossSize));
    }

    private void cycleColor() {
        colorState = (colorState + 1) % 3;

        // Print color change to terminal
        switch (colorState) {
            case 0:
                System.out.println("Color changed to: RED");
                break;
            case 1:
                System.out.println("Color changed to: YELLOW");
                break;
            case 2:
                System.out.println("Color changed to: BLUE");
                break;
        }
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
