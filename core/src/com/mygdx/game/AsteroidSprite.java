package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AsteroidSprite extends Sprite {
	
	int numero;

	public AsteroidSprite() {
		// TODO Auto-generated constructor stub
	}

	public AsteroidSprite(Texture texture, int numero) {
		super(texture);
		this.numero = numero;
		// TODO Auto-generated constructor stub
	}

	public AsteroidSprite(TextureRegion region) {
		super(region);
		// TODO Auto-generated constructor stub
	}

	public AsteroidSprite(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public AsteroidSprite(Texture texture, int srcWidth, int srcHeight) {
		super(texture, srcWidth, srcHeight);
		// TODO Auto-generated constructor stub
	}

	public AsteroidSprite(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
		super(texture, srcX, srcY, srcWidth, srcHeight);
		// TODO Auto-generated constructor stub
	}

	public AsteroidSprite(TextureRegion region, int srcX, int srcY, int srcWidth, int srcHeight) {
		super(region, srcX, srcY, srcWidth, srcHeight);
		// TODO Auto-generated constructor stub
	}

}
