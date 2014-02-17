package com.apps.timekeeper;

import android.util.Log;
import android.widget.EditText;

import com.apps.timekeeper.db.DatabaseHelper;
import com.apps.timekeeper.db.entity.Job;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

@EActivity(R.layout.activity_add_job)
public class AddJobActivity extends OrmLiteBaseActivity<DatabaseHelper> {

	private static final String TAG = "TimeKeeper";

	@ViewById
	EditText clientName;

	@ViewById
	EditText jobName;

	@AfterViews
	void init() {
	}

	@Click(R.id.createJobButton)
	void createJob() {

		String clientNameString = this.clientName.getText().toString();
		String jobNameString = this.jobName.getText().toString();

		if (clientNameString == null || clientNameString.length() == 0
				|| jobNameString == null || jobNameString.length() == 0) {
			return;
		}

		Log.i(TAG, "Creating new job");
		RuntimeExceptionDao<Job, Integer> dao = getHelper().getJobDao();
		Job job = new Job();
		job.setClientName(clientName.getText().toString());
		job.setJobName(jobName.getText().toString());
		job.setStartTime(System.currentTimeMillis());
		dao.create(job);
	}

}
