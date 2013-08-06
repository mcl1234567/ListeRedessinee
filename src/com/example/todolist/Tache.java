package com.example.todolist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

// Création d'une nouvelle liste re-dessinée.
public class Tache extends TextView {

	private Paint marginPaint;
	private Paint linePaint;

	private int paperColor;
	private float margin;

	public Tache(Context context, AttributeSet ats, int ds) 
	{
		super(context, ats, ds);
		init();
	}

	public Tache(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		init();
	}

	/**
	 * Initialisation.
	 */
	private void init() 
	{
		// Récupère une référence à notre table de ressources.
		Resources mResources = getResources();

		// Crée les brosses que nous utiliserons dans la méthode onDraw.
		marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		marginPaint.setColor(mResources.getColor(R.color.notepad_margin));
		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(mResources.getColor(R.color.notepad_lines));

		// Récupère la couleur de fond du papier et la largeur de la marge.
		paperColor = mResources.getColor(R.color.notepad_paper);
		margin = mResources.getDimension(R.dimen.notepad_margin);
	}

	@Override
	public void onDraw(Canvas canvas) 
	{
		// Couleur du papier.
		canvas.drawColor(paperColor);

		// Dessin de(s) ligne(s).
		//canvas.drawLine(0, 0, getMeasuredHeight(), 0, linePaint);
		canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);

		// Dessin de la marge.
		canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);

		// Save the matrix.
		canvas.save();

		// Déplacement du texte à partir de la marge.
		canvas.translate(margin, 0);

		super.onDraw(canvas);

		// Restore the matrix.
		canvas.restore();
	}
}