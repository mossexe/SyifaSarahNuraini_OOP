package com.syifa.frontend.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    private final Stack<GameState> states;
    public GameStateManager(Stack<GameState> states){

        this.states = new Stack<>();
    }
    public push(GameState state){
        states.push(state);
    };
    public pop(){

    };
    public set(GameState state){

    };
    public update(float delta){

    };
    public render (SpriteBatch batch){

    };
}
