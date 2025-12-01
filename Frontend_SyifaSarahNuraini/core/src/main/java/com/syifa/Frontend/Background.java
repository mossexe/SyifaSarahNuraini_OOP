package com.syifa.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
    private Texture backgroundTexture;
    private TextureRegion backgroundRegion;
    private float width;
    private float height;
    private float currentCameraX = 0f;

    public Background() {
        try {
            backgroundTexture = new Texture(Gdx.files.internal("background.png"));
            backgroundRegion = new TextureRegion(backgroundTexture);
            this.width = 2688f;
            this.height = 1536f;
        } catch (Exception e) {
            Gdx.app.error("Background", "Could not load background.png, creating placeholder");
            createPlaceholderTexture();
        }
    }

    private void createPlaceholderTexture() {
        Pixmap pixmap = new Pixmap(800, 600, Pixmap.Format.RGB888);
        pixmap.setColor(com.badlogic.gdx.graphics.Color.BLUE);
        pixmap.fill();
        for (int i = 0; i < 800; i += 50) {
            pixmap.setColor(com.badlogic.gdx.graphics.Color.DARK_GRAY);
            pixmap.drawLine(i, 0, i, 600);
        }
        for (int i = 0; i < 600; i += 50) {
            pixmap.setColor(com.badlogic.gdx.graphics.Color.DARK_GRAY);
            pixmap.drawLine(0, i, 800, i);
        }
        backgroundTexture = new Texture(pixmap);
        pixmap.dispose();
        backgroundRegion = new TextureRegion(backgroundTexture);
        this.width = 800f;
        this.height = 600f;
    }

    public void update(float cameraX) {
        this.currentCameraX = cameraX;
    }

    public void render(SpriteBatch batch) {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float scale = screenHeight / height;
        float scaledWidth = width * scale;
        float scaledHeight = height * scale;
        float startX = (float)Math.floor(currentCameraX / scaledWidth) * scaledWidth;
        for (float x = startX - scaledWidth; x < currentCameraX + screenWidth + scaledWidth; x += scaledWidth) {
            batch.draw(backgroundRegion, x, 0, scaledWidth, scaledHeight);
        }
    }

    public void dispose() {
        if (backgroundTexture != null) {
            backgroundTexture.dispose();
        }
    }
}
