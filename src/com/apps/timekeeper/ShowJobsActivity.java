package com.apps.timekeeper;

import android.app.Activity;
import android.widget.ListView;

import com.apps.timekeeper.adapter.JobsListAdapter;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_show_jobs)
public class ShowJobsActivity extends Activity {

	@ViewById
	ListView jobsList;

	@Bean
	JobsListAdapter adapter;

	@AfterViews
	void bindAdapter() {
		jobsList.setAdapter(adapter);
	}
}
