package com.housemgt.controller.DTO;

import com.housemgt.model.CountResult;

public class CountResultDTO extends CountResult {

    private String fullTimeCollegeTimeStr; // 全日制大中专上学时间

    private String startWorkTimeStr; // 参加工作时间

    private String schoolWorkTimeStr; // 到校工作时间

    private String timeInJobStr; // 职务职称任职时间

    public String getFullTimeCollegeTimeStr() {
        return fullTimeCollegeTimeStr;
    }

    public void setFullTimeCollegeTimeStr(String fullTimeCollegeTimeStr) {
        this.fullTimeCollegeTimeStr = fullTimeCollegeTimeStr;
    }

    public String getStartWorkTimeStr() {
        return startWorkTimeStr;
    }

    public void setStartWorkTimeStr(String startWorkTimeStr) {
        this.startWorkTimeStr = startWorkTimeStr;
    }

    public String getSchoolWorkTimeStr() {
        return schoolWorkTimeStr;
    }

    public void setSchoolWorkTimeStr(String schoolWorkTimeStr) {
        this.schoolWorkTimeStr = schoolWorkTimeStr;
    }

    public String getTimeInJobStr() {
        return timeInJobStr;
    }

    public void setTimeInJobStr(String timeInJobStr) {
        this.timeInJobStr = timeInJobStr;
    }
}
