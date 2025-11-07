package com.syifa.Frontend.pools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.syifa.Frontend.obstacles.HomingMissile;
import com.syifa.Frontend.obstacles.HorizontalLaser;
import com.syifa.Frontend.obstacles.VerticalLaser;

public class VerticalLaserPool extends ObjectPool<VerticalLaser> {

    @Override
    protected VerticalLaser createObject() {
        return new VerticalLaser(new Vector2(0, 0), 100);
    }

    @Override
    protected void resetObject(VerticalLaser object) {
        object.setPosition(Gdx.graphics.getWidth(), 0);
        object.setActive(false);
    }

    public VerticalLaser obtain(Vector2 position, int length) {
        VerticalLaser laser = super.obtain();
        laser.initialize(position, length);
        laser.setActive(true);
        return laser;
    }
}
