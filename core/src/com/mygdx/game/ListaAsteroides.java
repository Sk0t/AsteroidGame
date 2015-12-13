package com.mygdx.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;

public class ListaAsteroides {
	
	ArrayList<AsteroidSprite> lista;
	AsteroidSprite asteroideMaximo;
	AsteroidSprite asteroidePulsado;
	boolean rotandoDerecha = true;
	
	public ListaAsteroides(int i) {
		//Crea asteroidSprites y los almacena en el atributo lista.
		this.lista = new ArrayList<AsteroidSprite>();
		for ( int j = 1; j<=i; j++) {
			String s = "asteroides/asteroide" + Integer.toString(j) + ".png";
			Texture textura = new Texture(s);
			AsteroidSprite a = new AsteroidSprite(textura, j);
			lista.add(a);
		}
	}
	
	public void barajearLista() {
		long seed = System.nanoTime();
		Collections.shuffle(this.lista, new Random(seed));
		distribuyeElementos();
	}

	private void distribuyeElementos() {
		int j = 0;
		int i = 0;
		boolean primerElementoSegundaFila = true;
		for (AsteroidSprite ast : this.lista) {
			if (i <= 5) {
				ast.setCenterY(Gdx.graphics.getHeight() / 2);
				ast.translateX((float) 100 * (j));
			} else {
				if (primerElementoSegundaFila) {
				j = 0;
				primerElementoSegundaFila = false;
				}
				
				ast.setCenterY(Gdx.graphics.getHeight() / 2 - (ast.getHeight() + 10));
				ast.translateX((float) 100 * (j));
			}
			i++;
			j++;
		}
	}

	
	public void calculaAsteroideMaximo() {
		//Calcula cuál es el asteroideMáximo dentro de lista y apunta a él.
		int referencia = 0;
		for (AsteroidSprite ast:this.lista) {
			if (ast.numero > referencia) {
				referencia = ast.numero;
				this.asteroideMaximo = ast;
			}
		}

	}
	
	public void determinaAsteroidePulsado() {
		//atributo asteroidePulsado cambia en función de cuál se pulse.
		//1. Recorrer lista
		//2. uno a uno preguntando si se ha pulsado este.
	}
	
	public void actualizarLista() {
		if(asteroideMaximo == asteroidePulsado){
			lista.remove(asteroideMaximo);
		}
	}
	
	public void dibujaLista(SpriteBatch batch) {
		
		for (AsteroidSprite ast: this.lista) {
			ast.draw(batch);
		}
	}
	
	public void actualizaPulsado(int x, int y) {
		int y1 = Gdx.graphics.getHeight() - y;
		for (AsteroidSprite ast: this.lista) {
			if(ast.getBoundingRectangle().contains(x,y1))
				//ast es el objeto tocado
				this.asteroidePulsado = ast;
		}
	}
	
	public void hasPulsadoMayor() {
		if(this.asteroidePulsado == this.asteroideMaximo) {
			lista.remove(asteroideMaximo);
		}
	}
	
	public void rotarAsteroides() {
		Logger log = new Logger("Log 1");
		for (AsteroidSprite ast: this.lista) {

			float rotation = ast.getRotation();
			log.info(Float.toString(rotation));
			if (rotandoDerecha == true) {
				log.info("Rotando derecha");
				if(rotation > 45) {
					rotandoDerecha = false;
				} else {
					ast.rotate(0.5f);
				}
			}
			if (rotandoDerecha == false) {
				log.info("Rotando izquierda");
				if(rotation < -45) {
					rotandoDerecha = true;
				}else {
					ast.rotate(-0.5f);
				}
			}

	}
	
}
}
