package com.syifa.Frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;
    private Vector2 velocity;

    private final float gravity = 2000f;
    private final float force = 4500f;
    private final float maxVerticalSpeed = 700f;

    private final float width = 64f;
    private final float height = 64f;

    private Rectangle collider;

    private float baseSpeed = 300f;
    private float distanceTraveled = 0f;

    public Player(float startX, float startY) {
        position = new Vector2(startX, startY);
        velocity = new Vector2(baseSpeed, 0);
        collider = new Rectangle(position.x, position.y, width, height);
    }

    public void update(float delta, boolean isFlying) {
        updateDistanceAndSpeed(delta);
        applyGravity(delta);
        if (isFlying) fly(delta);
        updatePosition(delta);
        updateCollider();
    }

    private void updateDistanceAndSpeed(float delta) {
        distanceTraveled += velocity.x * delta;
    }

    private void updatePosition(float delta) {
        position.x += velocity.x * delta;
        position.y += velocity.y * delta;
    }

    private void applyGravity(float delta) {
        velocity.y -= gravity * delta;
        velocity.x = baseSpeed;

        if (velocity.y > maxVerticalSpeed)
            velocity.y = maxVerticalSpeed;
        if (velocity.y < -maxVerticalSpeed)
            velocity.y = -maxVerticalSpeed;
    }

    private void fly(float delta) {
        velocity.y += force * delta;
    }

    private void updateCollider() {
        collider.setPosition(position.x, position.y);
    }

    public void checkBoundaries(Ground ground, float ceilingY) {
        if (ground.isColliding(collider)) {
            position.y = ground.getTopY();
            velocity.y = 0;
            updateCollider();
        }
        if (position.y + height > ceilingY) {
            position.y = ceilingY - height;
            velocity.y = 0;
            updateCollider();
        }
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(0.2f, 0.8f, 0.3f, 1f);
        shapeRenderer.rect(position.x, position.y, width, height);
    }

    // Getters
    public Vector2 getPosition() {
        return position;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Rectangle getCollider() {
        return collider;
    }

    public float getDistanceTraveled() {
        return distanceTraveled / 10f;
    }

    public float getX() {
        return position.x;
    }
}
