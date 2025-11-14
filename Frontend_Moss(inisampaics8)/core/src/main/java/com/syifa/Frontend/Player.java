package com.syifa.Frontend;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {
    private Vector2 position;
    private Vector2 startPosition;
    private Vector2 velocity;
    private Rectangle collider;

    private float width = 50f;
    private float height = 50f;

    private float gravity = -800f;
    private float flyForce = 400f;
    private float maxVelocityY = 500f;
    private float minVelocityY = -500f;

    private float distanceTraveled = 0f;
    private float moveSpeed = 200f;

    private boolean isDead = false;

    public Player(Vector2 startPosition) {
        this.startPosition = new Vector2(startPosition);
        this.position = new Vector2(startPosition);
        this.velocity = new Vector2(0, 0);
        this.collider = new Rectangle(position.x, position.y, width, height);
    }

    public void update(float delta, boolean isFlying) {
        if (isDead) {
            return;
        }

        // Apply gravity or fly force
        if (isFlying) {
            velocity.y += flyForce * delta;
        } else {
            velocity.y += gravity * delta;
        }

        // Clamp velocity
        if (velocity.y > maxVelocityY) velocity.y = maxVelocityY;
        if (velocity.y < minVelocityY) velocity.y = minVelocityY;

        // Update position
        position.y += velocity.y * delta;

        // Update horizontal distance
        distanceTraveled += moveSpeed * delta;

        // Update collider
        collider.set(position.x, position.y, width, height);
    }

    public void checkBoundaries(Ground ground, float screenHeight) {
        // Check ground collision
        if (position.y <= ground.getTopY()) {
            position.y = ground.getTopY();
            velocity.y = 0;
        }

        // Check ceiling collision
        if (position.y + height >= screenHeight) {
            position.y = screenHeight - height;
            velocity.y = 0;
        }
    }

    public void die() {
        isDead = true;
        velocity.set(0, 0);
    }

    public void reset() {
        isDead = false;
        position.set(startPosition);
        velocity.set(0, 0);
        distanceTraveled = 0f;
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, width, height);
    }

    // Getters
    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getCollider() {
        return collider;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getDistanceTraveled() {
        return distanceTraveled;
    }

    public boolean isDead() {
        return isDead;
    }
}
