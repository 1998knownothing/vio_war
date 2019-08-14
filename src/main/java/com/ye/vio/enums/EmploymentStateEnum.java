package com.ye.vio.enums;

public enum EmploymentStateEnum {


    ERROR(-1001, "招聘信息操作失败"),
    SUCCESS(1, "招聘信息操作成功"),
    NULL_EMPID(-1002, "employmentId为空"),
    NULL_EMPLIST(-1003, "employmentList为空"),
    NULL_EMP_INFO(-1004,"传入空值");

    private int state;

    private String stateInfo;

    private EmploymentStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static EmploymentStateEnum stateOf(int index) {
        for (EmploymentStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
