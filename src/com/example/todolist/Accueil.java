package com.example.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Accueil extends Activity {

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accueil);

		Button _bNouvelleListetache = (Button) this.findViewById(R.id.nouvelleListeTache);

		_bNouvelleListetache.setOnClickListener(new OnClickListener() {
			public void onClick(View _view) {
				Intent intent = new Intent(Accueil.this, NouvelleListe.class);
				startActivity(intent);
			}
		});

	}
}
