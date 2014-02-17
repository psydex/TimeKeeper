package com.apps.timekeeper.view;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apps.timekeeper.R;
import com.apps.timekeeper.db.entity.Job;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.job_item)
public class JobItemView extends RelativeLayout {

	@ViewById
	TextView clientName;

	@ViewById
	TextView jobName;

	public JobItemView(Context context) {
		super(context);
	}

	public void bind(Job job) {
		clientName.setText(job.getClientName());
		jobName.setText(job.getJobName());
	}
}
