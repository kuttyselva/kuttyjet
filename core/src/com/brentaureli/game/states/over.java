package com.brentaureli.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brentaureli.game.FlappyDemo;

public class over extends State {
    private Texture background;
    private Texture playBtn;
    SpriteBatch batch;
    BitmapFont font;
    PlayState p=new PlayState(gsm);

    public over(GameStateManager gsm) {
        super(gsm);  cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background = new Texture("bg.png");
        playBtn = new Texture("gameover.png");
        font=new BitmapFont();

        font.setColor(Color.BLACK);
        font.getData().setScale(5);

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
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
        sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y);
        font.draw(sb,String.valueOf(p.score),cam.position.x - playBtn.getWidth() / 2+80, cam.position.y-50);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Menu State Disposed");
    }
}
