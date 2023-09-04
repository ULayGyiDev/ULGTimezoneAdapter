package com.ulaygyi.ulgtimezone;

import android.content.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import java.util.concurrent.*;



public class ULGTimezone extends BaseAdapter {
	Context context;
	String[] countryNames;
	LayoutInflater inflter;

	public ULGTimezone(Context applicationContext, String[] countryNames) {
		this.context = applicationContext;
		this.countryNames = countryNames;
		inflter = (LayoutInflater.from(applicationContext));
	}

	@Override
	public int getCount() {
		return countryNames.length;
	}

	@Override
	public Object getItem(int i) {
		return null;
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		view = inflter.inflate(android.R.layout.simple_spinner_item, null);
		TextView names = (TextView) view.findViewById(android.R.id.text1);
		names.setText(displayTimeZone(TimeZone.getTimeZone(countryNames[i])));
		return view;
	}

	private String displayTimeZone(TimeZone tz) {

		long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
		long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
			- TimeUnit.HOURS.toMinutes(hours);
		// avoid -4:-30 issue
		minutes = Math.abs(minutes);

		String result = "";
		if (hours > 0) {
			result = String.format("(GMT +%d:%02d) %s", hours, minutes, tz.getID());
		} else {
			result = String.format("(GMT %d:%02d) %s", hours, minutes, tz.getID());
		}

		return result;

	}
}
