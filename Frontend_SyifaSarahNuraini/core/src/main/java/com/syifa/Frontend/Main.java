package com.syifa.Frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private Player player;
    private Ground ground;
    private GameManager gameManager;

    private OrthographicCamera camera;
    private float cameraOffset = 0.2f;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        gameManager = GameManager.getInstance();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false);

        player = new Player(100, Gdx.graphics.getHeight() / 2f);
        ground = new Ground();

        gameManager.startGame();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        update(delta);

        ScreenUtils.clear(0.5f, 0.8f, 1f, 1f);

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        ground.renderShape(shapeRenderer);
        player.renderShape(shapeRenderer);
        shapeRenderer.end();
    }

    private void update(float delta) {
        boolean isFlying = Gdx.input.isKeyPressed(Input.Keys.SPACE);
        player.update(delta, isFlying);
        updateCamera(delta);
        ground.update(camera.position.x);
        player.checkBoundaries(ground, Gdx.graphics.getHeight());
        int currentDistance = (int) player.getDistanceTraveled();
        gameManager.setScore(currentDistance);
    }

    private void updateCamera(float delta) {
        float cameraFocus = player.getPosition().x + Gdx.graphics.getWidth() * cameraOffset;
        camera.position.x = cameraFocus;
        camera.update();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
