package com.syifa.frontend.pools;

import com.syifa.frontend.Coin;
import com.badlogic.gdx.math.Vector2;

public class CoinPool extends ObjectPool<Coin> {
    @Override
    protected Coin createObject() {
        return new Coin(new Vector2(0,0));
    }

    @Override
    protected void resetObject(Coin coin) {
        coin.setActive(false);
    }

    public Coin obtain(float x, float y) {
        Coin coin = super.obtain();
        coin.setPosition(x, y);
        return coin;
    }
}
