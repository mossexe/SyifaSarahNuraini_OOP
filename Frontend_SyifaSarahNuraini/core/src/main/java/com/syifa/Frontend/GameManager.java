package com.syifa.frontend;

import com.syifa.frontend.observers.ScoreManager;
import com.syifa.frontend.services.BackendService;
import com.badlogic.gdx.Gdx;

public class GameManager {
    private static GameManager instance;
    private ScoreManager scoreManager;
    private BackendService backendService;
    private String currentPlayerId;
    private int coinsCollected;
    private boolean gameActive;

    private GameManager() {
        scoreManager = new ScoreManager();
        backendService = new BackendService();
        currentPlayerId = null;
        coinsCollected = 0;
        gameActive = false;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void registerPlayer(String username) {
        backendService.createPlayer(username, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                try {
                    if (response.contains("\"playerId\"")) {
                        int start = response.indexOf("\"playerId\":\"") + 12;
                        int end = response.indexOf("\"", start);
                        currentPlayerId = response.substring(start, end);
                        Gdx.app.log("GameManager", "Player registered with ID: " + currentPlayerId);
                    }
                } catch (Exception e) {
                    Gdx.app.error("GameManager", "Error parsing player response: " + e.getMessage());
                }
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "Error registering player: " + error);
            }
        });
    }

    public void startGame() {
        scoreManager.setScore(0);
        coinsCollected = 0;
        gameActive = true;
        Gdx.app.log("GameManager", "Game Started!");
    }

    public void endGame() {
        if (currentPlayerId == null) {
            Gdx.app.error("GameManager", "Cannot submit score: No player ID");
            return;
        }

        int finalScore = scoreManager.getScore() + (coinsCollected * 10);
        int distance = scoreManager.getScore();

        backendService.submitScore(currentPlayerId, finalScore, coinsCollected, distance,
            new BackendService.RequestCallback() {
                @Override
                public void onSuccess(String response) {
                    Gdx.app.log("GameManager", "Score submitted successfully: " + response);
                }

                @Override
                public void onError(String error) {
                    Gdx.app.error("GameManager", "Error submitting score: " + error);
                }
            });

        gameActive = false;
    }

    public void setScore(int distance) {
        if (gameActive) {
            scoreManager.setScore(distance);
        }
    }

    public void addCoin() {
        coinsCollected++;
        Gdx.app.log("GameManager", "COIN COLLECTED! Total: " + coinsCollected);
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public int getCoins() {
        return coinsCollected;
    }

    public String getCurrentPlayerId() {
        return currentPlayerId;
    }

    public void addObserver(com.syifa.frontend.observers.Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(com.syifa.frontend.observers.Observer observer) {
        scoreManager.removeObserver(observer);
    }
}
