package com.avionic.ppo;


import android.app.*;
import android.os.*;
import android.content.Intent;
import android.widget.Button; 
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.*;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import android.widget.RadioGroup.*;
import android.net.Uri;
import java.io.File;

public class MainActivity extends Activity
implements OnClickListener 
{
	MMenu menu;
	private ToggleButton testTb;
	
	private TextView sText;
	private TextView iText;
	private TextView kText;
	private TextView qText;
	private TextView l1Text;
	private TextView l2Text;
	TextView t1tv;

	public String testNum="123";
	public String fText;
	public String fullCode;
	public String sCode;
	public String LCode;
	public String SCode;
	public String ICode;
	public String KCode;

	String S;
	String I;
	String K;
	String Q;
	String L1;
	String L2;
	
	Uri picUri;
	
	
	private int i;
	private int j=1;
	String MenItem;
	int[] fullcode=new int[20];

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		if (savedInstanceState !=null){
			S=savedInstanceState.getString("S");
			I=savedInstanceState.getString("I");
			Q=savedInstanceState.getString("Q");
			K=savedInstanceState.getString("K");
			L1=savedInstanceState.getString("L1");
			L2=savedInstanceState.getString("L2");
			i=savedInstanceState.getInt("i");
		}

		sText = (TextView)findViewById(R.id.textS);
		iText = (TextView)findViewById(R.id.textI);
		kText = (TextView)findViewById(R.id.textK);
		qText = (TextView)findViewById(R.id.textQ);
		l1Text = (TextView)findViewById(R.id.textL1);
		l2Text = (TextView)findViewById(R.id.textL2);
		
		final Button button1 = (Button) findViewById(R.id.button1); 
		final Button button2 = (Button) findViewById(R.id.button2);
		final Button button3 = (Button) findViewById(R.id.button3); 
		final Button button4 = (Button) findViewById(R.id.button4);
		final Button button5 = (Button) findViewById(R.id.button5); 
		final Button button6 = (Button) findViewById(R.id.button6);
		final Button button7 = (Button) findViewById(R.id.button7); 
		final Button button8 = (Button) findViewById(R.id.button8);
		final Button button9 = (Button) findViewById(R.id.button9); 
		final Button buttonsb = (Button) findViewById(R.id.buttonsb);
		final Button button0 = (Button) findViewById(R.id.button0); 
		final Button buttonvv = (Button) findViewById(R.id.buttonvv);
		final Button buttonac = (Button) findViewById(R.id.addcode);
		testTb = findViewById(R.id.tb1);

		button1.setOnClickListener(this); 
		button2.setOnClickListener(this);
		button3.setOnClickListener(this); 
		button4.setOnClickListener(this);
		button5.setOnClickListener(this); 
		button6.setOnClickListener(this);
		button7.setOnClickListener(this); 
		button8.setOnClickListener(this); 
		button9.setOnClickListener(this); 
		button0.setOnClickListener(this); 
		buttonsb.setOnClickListener(this); 
		buttonvv.setOnClickListener(this);
		buttonac.setOnClickListener(this);
		testTb.setOnCheckedChangeListener(new OnCheckedChangeListener(){
				public void onCheckedChanged( 
					CompoundButton buttonView, boolean isChecked) { 
					if (isChecked) { 
						testNum="44";} 
					else { 
						testNum="123";}
						
		}});

		yst();
		
	} 
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState){
		savedInstanceState.putString("S",S);
		savedInstanceState.putString("I",I);
		savedInstanceState.putString("K",K);
		savedInstanceState.putString("Q",Q);
		savedInstanceState.putString("L1",L1);
		savedInstanceState.putString("L2",L2);
		savedInstanceState.putInt("i",i);}
		
	
	@Override 
	public void onClick(View v) { 
		switch (v.getId()) { 
			case R.id.button1: 
				fText="1";
				sWin();
				i++;
				break;
			case R.id.button2: 
				fText="2"; 
				sWin();
				i++;
				break;
			case R.id.button3: 
				fText="3"; 
				sWin();
				i++;
				break;
			case R.id.button4: 
				fText="4"; 
				sWin();
				i++;
				break;
			case R.id.button5: 
				fText="5"; 
				sWin();
				i++;
				break;
			case R.id.button6: 
				fText="6"; 
				sWin();
				i++;
				break;
			case R.id.button7: 
				fText="7"; 
				sWin();
				i++;
				break;
			case R.id.button8: 
				fText="8"; 
				sWin();
				i++;
				break;
			case R.id.button9: 
				fText="9"; 
				sWin();
				i++;
				break;
			case R.id.button0: 
				fText="0"; 
				sWin();
				i++;
				break;
			case R.id.buttonsb:
				sbros();
				break;

			case R.id.buttonvv:
				if (i!=6)
				{	Toast.makeText(getApplicationContext(), 
								 "Неверный код", Toast.LENGTH_LONG).show();
					sbros();}
				else{
					VV();}

				break;
			case R.id.addcode:
				if (i!=6)
				{	Toast.makeText(getApplicationContext(), 
								 "Неверный код", Toast.LENGTH_LONG).show();
					sbros();}
				else{
					addCode();}
				}
	        	}


	public void sWin(){

		switch(i){
			case 0:
				S=fText;
			    sText.setText(S);
				break;
			case 1:
				I=fText;
				iText.setText(I);
				break;
			case 2:
				K=fText;
				kText.setText(K);
				break;
			case 3:
				Q=fText;
				qText.setText(Q);
				break;
			case 4:
				L1=fText;
				l1Text.setText(L1);
				break;
			case 5:
				L2=fText;
				l2Text.setText(L2);
				break;
		}
	}
	public void sbros(){
		i=0;
		fText=null;
		sText.setText(fText);
		iText.setText(fText);
		kText.setText(fText);
		qText.setText(fText);
		l1Text.setText(fText);
		l2Text.setText(fText);
	}
	public void yst(){
		sText.setText(S);
		iText.setText(I);
		kText.setText(K);
		qText.setText(Q);
		l1Text.setText(L1);
		l2Text.setText(L2);
	}
	public void VV(){
		
		fullCode=sText.getText().toString()+ iText.getText().toString()+
			kText.getText().toString()+qText.getText().toString()+
			l1Text.getText().toString() +l2Text.getText().toString();
		
		fullcode[j-1]=Integer.parseInt(fullCode);
        j++;
		Intent intent = new Intent();
		intent.setClass( 
			getApplicationContext(), TestRez.class);
		intent.putExtra("fullcode",fullcode);
		intent.putExtra("testNum", testNum);
        intent.putExtra("leightcode",j);
		startActivity(intent);
	}
	
	public void addCode(){
		fullCode=sText.getText().toString()+ iText.getText().toString()+
			kText.getText().toString()+qText.getText().toString()+
			l1Text.getText().toString() +l2Text.getText().toString();
				
		
		fullcode[j-1]=Integer.parseInt(fullCode);
		j++;
		sbros();
	}

	public void rdb(){
		Intent intent = new Intent();
		intent.setClass( 
			getApplicationContext(), TestRez.class);

		startActivity(intent);
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.tab201 :
				MenItem="tab201";
                 mItem();
                return true;
            case R.id.tab202:
                MenItem="tab202";
                mItem();
                return true;
            case R.id.tab203:
                MenItem="tab203";
                mItem();
                return true;
			case R.id.znaki:
				Intent intent = new Intent();
				intent.setClass( 
					getApplicationContext(), Znaki.class);

				startActivity(intent);
				return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
	public void mItem(){
		Intent intent = new Intent();
		intent.setClass( 
			getApplicationContext(), Tab.class);

		intent.putExtra("men_item",MenItem);
		startActivity(intent);}
		public void pz(){
		Intent intent = new Intent();
		intent.setClass( 
		getApplicationContext(), Znaki.class);
		startActivity(intent);}
		
}
