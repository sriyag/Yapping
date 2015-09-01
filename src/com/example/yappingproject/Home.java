package com.example.yappingproject;

import android.app.ActionBar.LayoutParams;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Home extends Activity implements OnItemClickListener {

	EditText question;
	Button ask;
	ListView lvcontent;
	private DrawerLayout drawerlayout;
	private ActionBarDrawerToggle drawerlistener;
	private ListView drawerlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		question = (EditText) findViewById(R.id.etQuestion);
		ask = (Button) findViewById(R.id.bAsk);
		lvcontent = (ListView) findViewById(R.id.listView1);

		drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
		drawerlistener = new ActionBarDrawerToggle(this, drawerlayout,
				R.drawable.final1, R.string.hello_world, R.string.hello_world) {
			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(drawerView);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerOpened(drawerView);
			}
		};
		drawerlayout.setDrawerListener(drawerlistener);
		drawerlist = (ListView) findViewById(R.id.drawerlist);
		drawerlist.setAdapter(new MyAdapter1(this));
		drawerlist.setOnItemClickListener(this);
		ActionBar ab = getActionBar();

		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		ab.show();

		question.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View view, MotionEvent event) {

				question.setHeight(500);

				ask.setVisibility(View.VISIBLE);
				lvcontent.setVisibility(View.INVISIBLE);

				return false;
			}
		});
		ask.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),
						Category.class));
			}
		});

		lvcontent.setAdapter(new MyAdapter(this));
		lvcontent.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

	}

}

class MyAdapter extends BaseAdapter {
	Context context;
	String[] questions;

	public MyAdapter(Context c) {
		// TODO Auto-generated constructor stub
		this.context = c;
		questions = c.getResources().getStringArray(R.array.homedata);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return questions.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return questions[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = null;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.home_row, parent, false);
		} else {
			row = convertView;
		}
		TextView t = (TextView) row.findViewById(R.id.questions);
		CheckBox c = (CheckBox) row.findViewById(R.id.checkBox1);
		t.setText(questions[position]);
		c.setChecked(false);

		return row;

	}

}

class MyAdapter1 extends BaseAdapter {
	Context context;
	String[] ndstring;

	public MyAdapter1(Context c) {
		// TODO Auto-generated constructor stub
		this.context = c;
		ndstring = c.getResources().getStringArray(R.array.nd);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ndstring.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return ndstring[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = null;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.home_row, parent, false);
		} else {
			row = convertView;
		}
		TextView t = (TextView) row.findViewById(R.id.questions);

		t.setText(ndstring[position]);

		return row;

	}

}
