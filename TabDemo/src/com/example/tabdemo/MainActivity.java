package com.example.tabdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView ls1;
	private TabHost myTabHost;
	int i=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myTabHost = (TabHost) this.findViewById(R.id.tabhost1);
		myTabHost.setup();


		ImageButton btn = (ImageButton) findViewById(R.id.add_btn);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ls1 = new ListView(MainActivity.this);
				TabSpec ts1 = myTabHost.newTabSpec("TAB_TAG_"+i);
				ts1.setIndicator("TAB_TAG_"+i);
				ts1.setContent(new TabHost.TabContentFactory() {
					public View createTabContent(String tag) {
						ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,new String[]{"TAB_TAG_"+i+"item1","TAB_TAG_"+i+"item2","TAB_TAG_"+i+"item3"}); 
						ls1.setAdapter(adapter);
						return ls1;
					}
				});
				myTabHost.addTab(ts1);
				myTabHost.setCurrentTab(i);
				i++;
			}
		});
		
		Button btngo=(Button) findViewById(R.id.button1);
		btngo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), myTabHost.getCurrentTabTag(),Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
