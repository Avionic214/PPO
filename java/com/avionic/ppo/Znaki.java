package com.avionic.ppo;

import com.github.chrisbanes.photoview.PhotoView;

import android.app.*;
import android.os.*;

public class Znaki extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.znaki);
		PhotoView photoView = findViewById(R.id.photo_view);
		photoView.setImageResource(R.drawable.znaki30);

    }
}
