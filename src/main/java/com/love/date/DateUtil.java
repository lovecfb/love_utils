package com.love.date;

import com.love.common.Assert;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2018 XXX, Inc. All rights reserved. <p>
 * Company: XX科技有限公司<p>
 *
 * @author lisheng
 * @since 2018/12/14 15:42
 */

public final class DateUtil {

    private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final long DAY1 = 24 * 60 * 60 * 1000L;

    private static final long DAY3 = 3 * 24 * 60 * 60 * 1000L;

    private static final long DAY7 = 7 * 24 * 60 * 60 * 1000L;

    private DateUtil() {
        throw new RuntimeException("DateUtil can't be initialized ...");
    }


    /**
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate2Str(Date date, String pattern) {
        Assert.isTrue(date == null);
        if (pattern != null) {
            return DateFormatUtils.format(date, pattern);
        } else {
            return DateFormatUtils.format(date, DATE_FORMAT);
        }
    }


    /**
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date formatStr2Date(String dateStr, String pattern) {
        Assert.isTrue(dateStr == null);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param dateStr
     * @return
     */
    public static Date formatStr2Date(String dateStr) {
        return formatStr2Date(dateStr, DATE_FORMAT);
    }


    /**
     * @param dayNum
     * @param pattern
     * @return
     */
    public static String getPastDay(int dayNum, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -dayNum);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(cal.getTime());
    }


}
