package com.example.listd;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String name1[]={"Android1","Android2","Android3","Android4","Android5"};
	String name2[]={"data1","data2","data3","data4","data5"};
	String name3[]={"100","200","300","400","500"};
	String name4[]={"data","data","data","data","data"};
	String name5[]={"001","002","003","004","005"};
	int img_id[]={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
	ListView l1;
	Toast t=null;
	CustomlistAdaptor adaptor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		l1=(ListView)findViewById(R.id.listView1);
		adaptor=new CustomlistAdaptor(MainActivity.this,name1,name2,name3,name4,name5,img_id);
		l1.setAdapter(adaptor);
		
		l1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				if(t!=null)
				{
					t.cancel();
				}
				t=Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT);
				t.setText("You clicked : "+name1[position]);				
				t.show();
			}
			
		});
	}
	
	/*public void Testing(View v) {
		
		LayoutInflater inflate=this.getLayoutInflater();
		final View view=inflate.inflate(R.layout.list_single,null,true);
		
		TextView t1=(TextView)view.findViewById(R.id.txt);
		ImageView iv=(ImageView)view.findViewById(R.id.img);
		EditText tv=(EditText)view.findViewById(R.id.editText1);
		System.out.println("Checking : "+l1.getItemAtPosition(1));
	}*/
}
