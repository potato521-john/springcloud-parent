package com.springcloud.yht.config;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public final class MyRuleConstant {
    public static final int FLOW_GRADE_THREAD = 0;
    public static final int FLOW_GRADE_QPS = 5;
    public static final int DEGRADE_GRADE_RT = 0;
    public static final int DEGRADE_GRADE_EXCEPTION_RATIO = 1;
    public static final int DEGRADE_GRADE_EXCEPTION_COUNT = 2;
    public static final int AUTHORITY_WHITE = 0;
    public static final int AUTHORITY_BLACK = 1;
    public static final int STRATEGY_DIRECT = 0;
    public static final int STRATEGY_RELATE = 1;
    public static final int STRATEGY_CHAIN = 2;
    public static final int CONTROL_BEHAVIOR_DEFAULT = 0;
    public static final int CONTROL_BEHAVIOR_WARM_UP = 1;
    public static final int CONTROL_BEHAVIOR_RATE_LIMITER = 2;
    public static final int CONTROL_BEHAVIOR_WARM_UP_RATE_LIMITER = 3;
    public static final String LIMIT_APP_DEFAULT = "default";
    public static final String LIMIT_APP_OTHER = "other";
    public static final int DEFAULT_SAMPLE_COUNT = 2;
    public static final int DEFAULT_WINDOW_INTERVAL_MS = 1000;

    private MyRuleConstant() {
    }
}
