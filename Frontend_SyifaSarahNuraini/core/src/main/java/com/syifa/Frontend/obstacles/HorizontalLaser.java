package com.syifa.Frontend.obstacles;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.syifa.Frontend.obstacles.BaseObstacle;

public class HorizontalLaser extends BaseObstacle {

    public HorizontalLaser(Vector2 startPosition, int length) {
        super(startPosition, length);
    }

    @Override
    public void initialize(Vector2 startPosition, int length) {
        super.initialize(startPosition, length);
    }

    @Override
    protected void updateCollider() {
        collider = new Rectangle((int) position.x, (int) position.y, (int) length, (int) WIDTH);
    }

    @Override
    protected void drawShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, length, WIDTH);
    }

    @Override
    protected float getRenderWidth() {
        return length;
    }
}
