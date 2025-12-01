package com.syifa.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class HardDifficultyStrategy implements DifficultyStrategy {
    @Override
    public float getSpawnInterval() {
        return 2.0f;
    }

    @Override
    public int getDensity() {
        return 2;
    }

    @Override
    public float getMinGap() {
        return 150f;
    }

    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> weights = new HashMap<>();
        weights.put("VerticalLaser", 3);
        weights.put("HorizontalLaser", 3);
        weights.put("HomingMissile", 4);
        return weights;
    }
}
