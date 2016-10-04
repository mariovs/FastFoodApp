package com.mario22gmail.vasile.projecthamburger;

import android.content.Context;

import java.util.Date;

/**
 * Created by Mario Vasile on 9/30/2016.
 */

public class ObjectForSqlCommand {

    public Context ContextActivity;
    public String ViewId;
    public Date DateFrom;
    public Date DateTo;

    public ObjectForSqlCommand(Context context,Date DateFrom, Date DateTo, String viewId)
    {
        this.ContextActivity = context;
        this.DateFrom = DateFrom;
        this.DateTo = DateTo;
        this.ViewId = viewId;
    }

    public Context getContextActivity() {
        return ContextActivity;
    }

    public void setContextActivity(Context contextActivity) {
        ContextActivity = contextActivity;
    }

    public String getViewId() {
        return ViewId;
    }

    public void setViewId(String viewId) {
        ViewId = viewId;
    }

    public Date getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        DateFrom = dateFrom;
    }

    public Date getDateTo() {
        return DateTo;
    }

    public void setDateTo(Date dateTo) {
        DateTo = dateTo;
    }
}
