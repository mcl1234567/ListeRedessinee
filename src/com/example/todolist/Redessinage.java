package com.example.todolist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

// Création d'une nouvelle interface visuelle, puis dessin du contrôle.
public class Redessinage extends View 
{
	public Redessinage(Context context) {
		super(context);
	}

	// Constructeurs pour la désérialisation à partir d'une ressource.
	public Redessinage(Context context, AttributeSet ats, int defaultStyle) {
		super(context, ats, defaultStyle);
	}

	public Redessinage(Context context, AttributeSet ats ) {
		super(context, ats);
	}

	@Override
	protected void onMeasure(int wMeasureSpec, int hMeasureSpec) {
		int measuredHeight = measureHeight(hMeasureSpec);
		int measuredWidth = measureWidth(wMeasureSpec);

		// Appel à setMeasureDimension() obligatoire pour éviter qu'une exception ne soit produite lorsque le contrôle sera placé.
		setMeasuredDimension(measuredHeight, measuredWidth);
	}

	private int measureHeight(int measureSpec) {
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);
		// [Calcul de la hauteur de la vue ...]

		// Taille par défaut si aucune limite n'est indiquée.
		int result = 500;

		if(specMode == MeasureSpec.AT_MOST) {
			// Calcule la taille idéale de votre contrôle dans les limites de la taille maximale.
			// Si votre contrôle remplit l'espace disponible, renvoie la borne externe.
			result = specSize;
		} 
		else if (specMode == MeasureSpec.EXACTLY) {
			// Si votre contrôle tient exactement dans ces bornes, renvoie la taille.
			result = specSize;
		}

		return result;
	}

	private int measureWidth(int measureSpec) {
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);
		// [Calcul de la largeur de la vue ...]
		
		// Taille par défaut si aucune limite n'est indiquée.
		int result = 500;

		if(specMode == MeasureSpec.AT_MOST) {
			// Calcule la taille idéale de votre contrôle dans les limites de la taille maximale.
			// Si votre contrôle remplit l'espace disponible, renvoie la borne externe.
			result = specSize;
		} 
		else if(specMode == MeasureSpec.EXACTLY) {
			// Si votre contrôle tient exactement dans ces bornes, renvoie la taille.
			result = specSize;
		}

		return result;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// [Dessinez votre interface visuelle... ]
		// Récupère la taille du contrôle en fonction du dernier appel à onMeasure.
		int hauteur = getMeasuredHeight();
		int largeur =  getMeasuredWidth();

		// Détermine le centre.
		int px = hauteur / 2;
		int py = largeur / 2;

		// Crée les nouvelles brosses
		// NOTE : Par souci d'efficatité, cela doit être fait dans le constructeur de la vue.
		Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mTextPaint.setColor(Color.WHITE);

		// Définit le texte.
		String displayText = "Hello World !";

		// Mesure la largeur du texte.
		float textWidth = mTextPaint.measureText(displayText);

		// Affiche le texte au centre du contrôle.
		canvas.drawText(displayText, px-textWidth/2, py, mTextPaint);
	}

}
