package com.apps.timekeeper.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.apps.timekeeper.db.DatabaseHelper;
import com.apps.timekeeper.db.entity.Job;
import com.apps.timekeeper.view.JobItemView;
import com.apps.timekeeper.view.JobItemView_;
import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

@EBean
public class JobsListAdapter extends BaseAdapter {

	List<Job> jobs;

	@RootContext
	Context context;

	@AfterInject
	void initAdapter() {
		RuntimeExceptionDao<Job, Integer> dao = OpenHelperManager.getHelper(
				context, DatabaseHelper.class).getJobDao();
		jobs = dao.queryForAll();
	}

	@Override
	public int getCount() {
		return jobs != null ? jobs.size() : 0;
	}

	@Override
	public Job getItem(int index) {
		if (jobs == null || jobs.size() < index) {
			return null;
		}
		return jobs.get(index);
	}

	@Override
	public long getItemId(int position) {
		return jobs.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		JobItemView jobItemView;
		if (convertView == null) {
			jobItemView = JobItemView_.build(context);
		} else {
			jobItemView = (JobItemView) convertView;
		}
		jobItemView.bind(getItem(position));
		return jobItemView;
	}
}
