package com.avionic.ppo;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException; 
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleAdapter;
import android.widget.ListAdapter;
import android.widget.*;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import java.util.List;
import java.util.Arrays;
import java.io.IOException;
public class TestRez extends Activity {

    // Объявим переменные компонентов
    
    TextView textView;
	TextView header;
		
	ArrayList<Rez> rez = new ArrayList<Rez>();
	ListView rezView;
	
	// Переменная для работы с БД
	
    private DbHelper mDBHelper;
    private SQLiteDatabase mDb;
	private String table;
	private String kontur;
	private int[] fullcode;
	private int code44;
	private int n;
	private int k;
	String MenItem;
	String testNum;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rez);
		
		table="ll201";
		testNum="123";
	
		Intent intent = getIntent(); 
		fullcode = intent.getExtras().getIntArray("fullcode");
		n= intent.getExtras().getInt("leightcode");
		testNum= intent.getExtras().getString("testNum");
		
		
		
			for(k=0; k<n-1; k++){
	    	switch (testNum){
				case "123":
			oneCode();
			ListView rezList;
			rezList = findViewById(R.id.rezList);
      		TestAdapter testAdapter = new TestAdapter(this, R.layout.fish, rez);
       		rezList.setAdapter(testAdapter);
			break;
				case "44":
				t44();
				break;}
			}
		}
	   
	   public void oneCode(){
		 
		   String fullCode=Integer.toString(fullcode[k]);
		   String lCode=fullCode.substring(4,6);
		   String SCode=fullCode.substring(0,1);
		   switch (SCode){
			   case "1":
				   table="ll201";
				   kontur="продольный канал управления основного контура";
				   break;
			   case "2":
				   table="ll202";
				   kontur="поперечный канал управления основного контура";
				   break;
			   case "3":
				   table="ll203";
				   kontur="резервный контур";
				   break;}

		   mDBHelper = new DbHelper(this);

		   try {
			   mDBHelper.updateDataBase();
		   } catch (IOException mIOException) {
			   throw new Error("UnableToUpdateDatabase");
		   }

		   try {
			   mDb = mDBHelper.getWritableDatabase();
		   } catch (SQLException mSQLException) {
			   throw mSQLException;
		   }
		   Cursor cursor = mDb.query(table, null,"_id=?", new String[] {lCode}, null, null, null);
		   cursor.moveToFirst();


		   String Kcode = fullCode.substring(2,3);
		   String Neispr= cursor.getString(1);
		   String  Prich= cursor.getString(2);

		   cursor.close();


		   // начальная инициализация списка
		   rez.add(new Rez (fullCode,Neispr,Prich, Kcode, kontur));
	   }
	public void t44(){
		setContentView(R.layout.rez44);
		LinearLayout lltab44 =  findViewById(R.id.tab44);
		
		//sikqll 123456
		code44=fullcode[k];
		int L = code44 % 10;
		int Q = (code44 /100)%10;
		int I = (code44 / 10000)%10;
		int S = code44 / 100000;
		
		
		
		

		LayoutInflater ltInflater = getLayoutInflater();


		//Log.d("myLogs", "i = " + i);
		View item = ltInflater.inflate(R.layout.fish44, lltab44, false);
		TextView kotv = item.findViewById(R.id.ko44);
		kotv.setText(Integer.toString(fullcode[k]));
		TextView  s44tv=item.findViewById(R.id.s44);
		switch(S){
			case 4:
				s44tv.setText("СДУ-6");
				break;
			case 5:
				s44tv.setText("ПАБ-204");
				break;}
		TextView i44tv= item.findViewById(R.id.i44);
		switch(I){
			case 0:
				i44tv.setText("основной контур");
				break;
			case 3:
				i44tv.setText("резервный контур");
				break;}
		TextView q44tv= item.findViewById(R.id.ql44);
		switch(Q){
			case 1:
				q44tv.setText("руль высоты- " + L);
				break;
			case 2:
				q44tv.setText("ПАБ СТАБ- " + L);
				break;
			case 3:
				q44tv.setText("ПАБ МР3- " + L);
				break;
			case 4:
				q44tv.setText("элероны- " + L);
				break;
			case 5:
				q44tv.setText("интерцепторы- " + L);
				break;
			case 6:
				q44tv.setText("руль направления- " + L);
				break;}
		lltab44.addView(item);
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
			//case R.id.prav_znak:
				//MenItem="znaki";
                //mItem();
				//return true;
        }
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }
	public void mItem(){
		Intent intent = new Intent();
		intent.setClass( 
			getApplicationContext(), Tab.class);

		intent.putExtra("men_item",MenItem);
		startActivity(intent);
	}
}
	
