package com.syifa.frontend.factories;

import com.syifa.frontend.pools.CoinPool;
import com.syifa.frontend.Coin;
import java.util.ArrayList;
import java.util.List;

public class CoinFactory {
    public final CoinPool coinPool;
    private List<Coin> activeCoins;

    public CoinFactory() {
        this.coinPool = new CoinPool();
        this.activeCoins = new ArrayList<>();
    }

    public List<Coin> getActiveCoins() {
        activeCoins.removeIf(coin -> !coin.isActive());
        return activeCoins;
    }

    public void releaseCoin(Coin coin) {
        coin.setActive(false);
        coinPool.release(coin);
        activeCoins.remove(coin);
    }

    public void releaseAll() {
        activeCoins.clear();
        coinPool.releaseAll();
    }
}
