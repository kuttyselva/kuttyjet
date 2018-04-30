package com.brentaureli.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.brentaureli.game.FlappyDemo;

/**
 * Created by Brent on 6/26/2015.
 */
public class MenuState extends State{
    private Stage stage;
    private Texture background;
    private Texture playBtn;


    private Texture ins;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background = new Texture("bg.png");

        playBtn = new Texture("playbtn.png");
      ins = new Texture("GetReadyTap.png");
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);




    }


    @Override
    public void handleInput() {

       if(Gdx.input.justTouched()) {
           gsm.set(new PlayState(gsm));
       }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y+50);

        sb.draw(ins,cam.position.x - playBtn.getWidth() / 2, cam.position.y-200);
        //sb.draw(ins,cam.position.x - playBtn.getWidth() / 2+100, cam.position.y-100);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Menu State Disposed");
    }
}
