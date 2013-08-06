package com.example.todolist;

import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

// Cr�ation d'une liste de t�ches.
public class NouvelleListe extends Activity {

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.liste);

		// R�cup�ration des r�f�rences aux widgets de l'interface.
		// Cr�ation de l'ArrayAdapter pour lier la ListView � l'ArrayList.
		ListView _lTaches = (ListView) findViewById(R.id.ListViewTaches);
		final Button _bNouvelleTache = (Button) findViewById(R.id.BoutonNouvelleTache);
		final EditText nomTache = (EditText) findViewById(R.id.EditTextNomTache);

		final ArrayList<String> taches = new ArrayList<String>();
		final ArrayAdapter<String> adapterTaches = new ArrayAdapter<String>(this, R.layout.tache, taches);
		_lTaches.setAdapter(adapterTaches);

		// Lecture du contr�le ( �coute des clics sur un Dpad ( clavier num�rique ) et de la touche Entr�e.
		/**nomTache.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View _view, int _keyCode, KeyEvent _event) {
				if(_event.getAction() == KeyEvent.ACTION_DOWN) {
					if(_keyCode == KeyEvent.KEYCODE_DPAD_CENTER || _keyCode == KeyEvent.KEYCODE_ENTER) {
						taches.add(0, nomTache.getText().toString());
						adapterTaches.notifyDataSetChanged();
						nomTache.setText("");

						return true;
					}
				}

				return false;
			}
		});*/

		_bNouvelleTache.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				taches.add(0, nomTache.getText().toString());
				adapterTaches.notifyDataSetChanged();
				nomTache.setText("");
			}
		});
	}
}