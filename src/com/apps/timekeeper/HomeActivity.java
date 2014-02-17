package com.apps.timekeeper;

import android.content.Intent;

import com.apps.timekeeper.db.DatabaseHelper;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OptionsItem;
import com.googlecode.androidannotations.annotations.OptionsMenu;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

@EActivity(R.layout.activity_home)
@OptionsMenu(R.menu.home)
public class HomeActivity extends OrmLiteBaseActivity<DatabaseHelper> {

	@OptionsItem(R.id.action_show_jobs)
	void showJobsMenuItemSelected() {
		Intent intent = new Intent(this, ShowJobsActivity_.class);
		startActivity(intent);
	}

	@OptionsItem(R.id.action_add_job)
	void addJobMenuItemSelected() {
		Intent intent = new Intent(this, AddJobActivity_.class);
		startActivity(intent);
	}
}
