package de.loci2021.reportsystem.util;

import java.util.Date;

public class Report {

    private final String reporterUUID;
    private final String targetUUID;
    private final String reason;
    private final Date date;

    public Report(String reporterUUID, String targetUUID, String reason, Date date, ) {
        this.reporterUUID = reporterUUID;
        this.targetUUID = targetUUID;
        this.reason = reason;
        this.date = date;
    }

    public String getReporterUUID() {
        return reporterUUID;
    }

    public String getTargetUUID() {
        return targetUUID;
    }

    public String getReason() {
        return reason;
    }

    public Date getDate() {
        return date;
    }

}



