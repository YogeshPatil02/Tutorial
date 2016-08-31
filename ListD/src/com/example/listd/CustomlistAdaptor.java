package com.example.listd;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomlistAdaptor extends ArrayAdapter<String> {
	static Activity context;
	String name1[];
	String name2[];
	String name3[];
	String name5[];
	String name4[];
	
	int img_id[];
	public CustomlistAdaptor(MainActivity context, String[] name1,String[] name2, String[] name3, String[] name4, String[] name5, int[] img_id) {
		super(context,R.layout.list_single,name1);
		this.context=context;
		this.name1=name1;
		this.name2=name2;
		this.name3=name3;
		this.name5=name5;
		this.name4=name4;
		this.img_id=img_id;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		int colors[]={Color.parseColor("#009900"),Color.parseColor("#006699"),Color.parseColor("#FF9900"),Color.parseColor("#003366"),Color.parseColor("#EC2C26")};
		int ids[]={R.drawable.selector1,R.drawable.selector2,R.drawable.selector3};
		LayoutInflater inflate=context.getLayoutInflater();
		final View view=inflate.inflate(R.layout.list_single,null,true);
		
		TextView t1=(TextView)view.findViewById(R.id.textView1);
		TextView t2=(TextView)view.findViewById(R.id.textView2);
		TextView t3=(TextView)view.findViewById(R.id.textView3);
		TextView t4=(TextView)view.findViewById(R.id.textView4);
		//Button b1=(Button)view.findViewById(R.id.button1);
		ImageView iv=(ImageView)view.findViewById(R.id.imageView1);
		ImageView iv1=(ImageView)view.findViewById(R.id.imageView2);
		LinearLayout l1=(LinearLayout)view.findViewById(R.id.chk1);
		
		t1.setText(name1[position]);
		t2.setText(name2[position]);
		t3.setText(name3[position]);
		t4.setText(name5[position]);

		//b1.setText(name4[position]);
		/*iv.setBackgroundColor(colors[position]);
		iv1.setImageResource(img_id[position]);*/
		int getcolor=position%ids.length;
		l1.setBackgroundResource(ids[getcolor]);
		return view;
	}
	
}
