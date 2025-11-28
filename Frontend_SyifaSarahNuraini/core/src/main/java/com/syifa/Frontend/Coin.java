package com.syifa.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15f;
    private boolean active;

    private float bobOffset;
    private float bobSpeed;

    public Coin (Vector2 startPosition, Rectangle collider){
        this.collider = collider;
    }

    public update(float delta){
        bobOffset = bobSpeed * delta;
        updatecollider ();
    }

    public void renderShape(ShapeRenderer shapeRenderer){
        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
        shapeRenderer.setColor(1f, 1f, 0f, 1f);
        shapeRenderer.circle(position.x, drawY, radius);
        if (!active) return;
    }

    public boolean isColliding(Rectangle playerCollider){
        return active && collider.overlaps(playerCollider)
        }
}
