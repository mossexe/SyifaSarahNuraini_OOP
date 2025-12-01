package com.syifa.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.syifa.frontend.GameManager;

public class MenuState implements GameState {
    private GameStateManager gsm;
    private Stage stage;
    private Skin skin;
    private TextField nameField;
    private TextButton startButton;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        createBasicSkin();
        buildUI();
    }

    private void createBasicSkin() {
        skin = new Skin();
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        Pixmap whitePixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        whitePixmap.setColor(Color.WHITE);
        whitePixmap.fill();
        skin.add("white", new com.badlogic.gdx.graphics.Texture(whitePixmap));

        Pixmap grayPixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        grayPixmap.setColor(Color.GRAY);
        grayPixmap.fill();
        skin.add("gray", new com.badlogic.gdx.graphics.Texture(grayPixmap));

        Pixmap darkGrayPixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        darkGrayPixmap.setColor(Color.DARK_GRAY);
        darkGrayPixmap.fill();
        skin.add("dark_gray", new com.badlogic.gdx.graphics.Texture(darkGrayPixmap));

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;
        skin.add("default", labelStyle);

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.background = skin.newDrawable("dark_gray");
        textFieldStyle.cursor = skin.newDrawable("white");
        textFieldStyle.selection = skin.newDrawable("gray");
        skin.add("default", textFieldStyle);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.newDrawable("gray");
        textButtonStyle.down = skin.newDrawable("white");
        textButtonStyle.over = skin.newDrawable("dark_gray");
        skin.add("default", textButtonStyle);
    }

    private void buildUI() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label titleLabel = new Label("NETLAB JOYRIDE", skin);
        titleLabel.setFontScale(2f);
        Label promptLabel = new Label("Enter Your Name:", skin);
        nameField = new TextField("", skin);
        nameField.setMessageText("Username...");
        nameField.setAlignment(1);
        startButton = new TextButton("START GAME", skin);

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String inputName = nameField.getText();
                if (inputName.isEmpty()) {
                    inputName = "Guest";
                }
                GameManager.getInstance().registerPlayer(inputName);
                gsm.set(new PlayingState(gsm));
            }
        });

        table.add(titleLabel).padBottom(20f).row();
        table.add(promptLabel).padBottom(10f).row();
        table.add(nameField).width(200f).height(30f).padBottom(20f).row();
        table.add(startButton).width(150f).height(40f);
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render(SpriteBatch batch) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
