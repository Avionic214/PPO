package com.avionic.ppo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TestAdapter extends ArrayAdapter<Rez>
{private LayoutInflater inflater;
    private int layout;
    private List<Rez>rez;

    public TestAdapter(Context context, int resource, List<Rez> rez) {
        super(context, resource, rez);
        this.rez = rez;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
}
	public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);
		
        TextView KoView = view.findViewById(R.id.Ko);
		TextView konturView = view.findViewById(R.id.kontur);
        TextView LnView = view.findViewById(R.id.Ln);
        TextView LpView = view.findViewById(R.id.Lp);
        TextView KView = view.findViewById(R.id.K);

        Rez rezel = rez.get(position);
		
        KoView.setText(rezel.getfullCode());
		konturView.setText(rezel.getKontur());
        LnView.setText(rezel.getLn());
        LpView.setText(rezel.getLp());
        KView.setText(rezel.getK());

        return view;
    }
}
