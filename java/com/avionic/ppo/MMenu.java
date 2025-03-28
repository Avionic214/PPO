package com.avionic.ppo;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;

public class MMenu extends Activity{
	String MenItem;
	
	
	public void mItem(){
		Intent intent = new Intent();
		intent.setClass( 
			getApplicationContext(), Tab.class);

		intent.putExtra("men_item",MenItem);
		startActivity(intent);
	}
}
