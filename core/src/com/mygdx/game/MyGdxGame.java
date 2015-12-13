package com.mygdx.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	ListaAsteroides listaAst;
	int j = 3; //Número elementos iniciales listaAst
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		listaAst = new ListaAsteroides(j);
		listaAst.barajearLista();
		
		Gdx.input.setInputProcessor(this);
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		listaAst.rotarAsteroides();
		listaAst.calculaAsteroideMaximo();
		listaAst.hasPulsadoMayor();
		
		if(listaAst.lista.isEmpty()) { //Está vacía: Crea nueva lista
			j = j + 1;
			if (j < 11) {
			listaAst = new ListaAsteroides(j);
			listaAst.barajearLista();
			}
		}
		if (listaAst.asteroideMaximo != null)
		System.out.println(listaAst.asteroideMaximo.numero);
		
		batch.begin();
		listaAst.dibujaLista(batch);
		batch.end();
		
	}
	
	@Override
	public void dispose () {
		super.dispose();
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		listaAst.actualizaPulsado(screenX, screenY);
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
