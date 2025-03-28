package com.avionic.ppo;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.widget.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException; 
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import java.io.IOException;
import android.view.LayoutInflater;

public class Tab extends Activity{
	String MenItem;
	
	ImageView image;
	String tab, ll, otkaz, prich;
	private DbHelper mDBHelper;
	private SQLiteDatabase mDb;
	private Cursor cursor;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.tab);
		Intent intent = getIntent(); 
		MenItem = intent.getExtras().getString("men_item");
		setContentView(R.layout.tab);
		switch(MenItem){
            case "tab201" :
				tab = "ll201";
				readTab();
				break;
			case "tab202" :
				tab = "ll202";
				readTab();
				break;
			case "tab203" :
				tab = "ll203";
				readTab();
				break;
			case "znaki2" :
				setContentView(R.layout.znaki);
				image = findViewById(R.id.img);
				Uri imgUri = Uri.parse("android.resource://"+getPackageName()+"/drawable/znaki");
				image.setImageURI(imgUri);
				break;
			case "znaki" :
				Intent intent2 = new Intent(); 
				intent2.setAction(Intent.ACTION_VIEW);
				Uri intentUri = Uri.parse("/storage/emulated/0/Download" + "8_mart");
				intent2.setDataAndType(intentUri, "image"); 
				startActivity(intent);
			}
		}
		
		
		public void readTab(){
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
			cursor = mDb.query(tab, null, null, null, null, null, null);
			if (cursor.moveToFirst()){
				do {
				ll= cursor.getString(0);
				otkaz= cursor.getString(1);
				prich= cursor.getString(2);
				cursor.moveToNext();
				
			LinearLayout linLayout =  findViewById(R.id.lin_tab);

			LayoutInflater ltInflater = getLayoutInflater();


			//Log.d("myLogs", "i = " + i);
			View item = ltInflater.inflate(R.layout.tab_fish, linLayout, false);
			TextView lltv = item.findViewById(R.id.ll_txt);
			lltv.setText(String.valueOf(ll));
			TextView otkaztv = item.findViewById(R.id.otkaz_txt);
			otkaztv.setText(String.valueOf(otkaz));
			TextView prichtv = item.findViewById(R.id.prich_txt);
			prichtv.setText(String.valueOf(prich));
			linLayout.addView(item);}
				while (cursor.moveToNext());}
		}
	@Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        mDb.close();
        cursor.close(); }
}
