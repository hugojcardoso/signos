package com.example.provahugocardoso;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btsigno, btsair;
	private ImageView imgsigno;
	private DatePicker datePicker;
	private int dia = 0;
	private int mes = 0;

	int dados[][] = { { 21, 3, 20, 4, R.drawable.aries },
			{ 21, 4, 21, 5, R.drawable.touro },
			{ 22, 5, 21, 6, R.drawable.gemeos },
			{ 21, 6, 23, 7, R.drawable.cancer },
			{ 24, 7, 23, 8, R.drawable.leao },
			{ 24, 8, 23, 9, R.drawable.virgem },
			{ 24, 9, 23, 10, R.drawable.libra },
			{ 24, 10, 22, 11, R.drawable.escorpiao },
			{ 23, 11, 21, 12, R.drawable.sagitario },
			{ 22, 12, 20, 1, R.drawable.capricornio },
			{ 21, 1, 1, 2, R.drawable.aquario },
			{ 20, 2, 20, 3, R.drawable.peixes } };
	String signos[] = { "Aries", "touro", "Gêmeos", "Câncer", "Leão", "Virgem",
			"Libra", "Escorpião", "Sagitário", "Capricórnio", "Aquário",
			"Peixes" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		btsigno = (Button) findViewById(R.id.btsigno);
		btsair = (Button) findViewById(R.id.btsair);
		imgsigno = (ImageView) findViewById(R.id.imgsigno);
		datePicker = (DatePicker) findViewById(R.id.dtpdatanasc);

		signoClick();

	}

	private void signoClick() {
		btsigno.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mes = datePicker.getMonth() + 1;
				dia = datePicker.getDayOfMonth();
				
				for (int linha = 0; linha < dados.length; linha++) {
					if (((mes == dados[linha][1]) && ((dia >= dados[linha][0])) || ((mes == dados[linha][3]) && (dia <= dados[linha][2])))){

					imgsigno.setImageResource(dados[linha][4]);
					Toast.makeText(getApplicationContext(),
							"Seu signo é "+signos[linha], Toast.LENGTH_LONG).show();
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void sairClick(View view) {

		this.finish();
	}

}
