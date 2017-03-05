package com.example.app4_gridview;

import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectorAdapter extends BaseAdapter {
	
	LayoutInflater layoutInflater;
	public static Vector <BookInfo> bookVector;
  
	public SelectorAdapter(Activity a){
		layoutInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
		inicializarVector();
	}
	
	public int getCount(){
		 return bookVector.size();
	}
	
	public Object getItem(int position){
		 return null;
	}
	
	public long getItemId(int position){
		return 0;
	}
	
	public View getView(int position, View convertView , ViewGroup parent){
		 ImageView imageview;
		 TextView audiolibroTextView;
		 BookInfo bookInfo = bookVector.elementAt(position);
		 View view = convertView;
		 if (convertView == null){
			 view = layoutInflater.inflate(R.layout.elemento_selector,  null);
		 }
		 audiolibroTextView = (TextView)view.findViewById(R.id.titulo);
		 imageview=(ImageView)view.findViewById(R.id.imageView1);
		 imageview.setImageResource(bookInfo.resourceImage);
		 imageview.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		 audiolibroTextView.setText(bookInfo.name);
		 return view;
	}
	
	public static void inicializarVector(){
		bookVector = new Vector <BookInfo>();
		bookVector.add(new BookInfo("Palazzo","Hangtu",R.drawable.palazzo,"url"));
		bookVector.add(new BookInfo("Deek Garden","Hangtu",R.drawable.deek,"url"));
	}
}
