package com.example.todolist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

// Cr�ation d'une nouvelle interface visuelle, puis dessin du contr�le.
public class Redessinage extends View 
{
	public Redessinage(Context context) {
		super(context);
	}

	// Constructeurs pour la d�s�rialisation � partir d'une ressource.
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

		// Appel � setMeasureDimension() obligatoire pour �viter qu'une exception ne soit produite lorsque le contr�le sera plac�.
		setMeasuredDimension(measuredHeight, measuredWidth);
	}

	private int measureHeight(int measureSpec) {
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);
		// [Calcul de la hauteur de la vue ...]

		// Taille par d�faut si aucune limite n'est indiqu�e.
		int result = 500;

		if(specMode == MeasureSpec.AT_MOST) {
			// Calcule la taille id�ale de votre contr�le dans les limites de la taille maximale.
			// Si votre contr�le remplit l'espace disponible, renvoie la borne externe.
			result = specSize;
		} 
		else if (specMode == MeasureSpec.EXACTLY) {
			// Si votre contr�le tient exactement dans ces bornes, renvoie la taille.
			result = specSize;
		}

		return result;
	}

	private int measureWidth(int measureSpec) {
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);
		// [Calcul de la largeur de la vue ...]
		
		// Taille par d�faut si aucune limite n'est indiqu�e.
		int result = 500;

		if(specMode == MeasureSpec.AT_MOST) {
			// Calcule la taille id�ale de votre contr�le dans les limites de la taille maximale.
			// Si votre contr�le remplit l'espace disponible, renvoie la borne externe.
			result = specSize;
		} 
		else if(specMode == MeasureSpec.EXACTLY) {
			// Si votre contr�le tient exactement dans ces bornes, renvoie la taille.
			result = specSize;
		}

		return result;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// [Dessinez votre interface visuelle... ]
		// R�cup�re la taille du contr�le en fonction du dernier appel � onMeasure.
		int hauteur = getMeasuredHeight();
		int largeur =  getMeasuredWidth();

		// D�termine le centre.
		int px = hauteur / 2;
		int py = largeur / 2;

		// Cr�e les nouvelles brosses
		// NOTE : Par souci d'efficatit�, cela doit �tre fait dans le constructeur de la vue.
		Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mTextPaint.setColor(Color.WHITE);

		// D�finit le texte.
		String displayText = "Hello World !";

		// Mesure la largeur du texte.
		float textWidth = mTextPaint.measureText(displayText);

		// Affiche le texte au centre du contr�le.
		canvas.drawText(displayText, px-textWidth/2, py, mTextPaint);
	}

}
