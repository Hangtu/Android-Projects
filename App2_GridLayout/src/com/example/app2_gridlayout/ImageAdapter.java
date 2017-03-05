package com.example.app2_gridlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	private Context CTX;
	private Integer image_id[]={R.drawable.atro,R.drawable.balon,R.drawable.barcelona,R.drawable.carita,
			R.drawable.fear};
	
	public ImageAdapter(Context CTX){
		 this.CTX=CTX;
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return image_id.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ImageView img;
		TextView tx;
		if(arg1==null){
			img=new ImageView(CTX);
			tx=new TextView(CTX);
			img.setLayoutParams(new GridView.LayoutParams(240,240));
			img.setScaleType(ImageView.ScaleType.CENTER_CROP);
			img.setPadding(10,10,10,10);
			tx.setText("Ejemplo");
		}
		else{
			img=(ImageView) arg1;
		}
		img.setImageResource(image_id[arg0]);
		return img;
	}

}
