var xyuCalendar = xyuCalendar || {};

// 获取格式化日期”yyyy-MM-dd“, 空值默认今天
xyuCalendar.getFormatDate = function (date, format) {
    date = date || new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let hour = date.getHours();
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();
    month = month < 10 ? "0" + month : month;
    day = day < 10 ? "0" + day : day;
    hour = hour < 10 ? "0" + hour : hour;
    minutes = minutes < 10 ? "0" + minutes : minutes;
    seconds = seconds < 10 ? "0" + seconds : seconds;
    if (!format || format === commonUtil.dateFormat.formatDay) return year + "-" + month + "-" + day;
    if (format === commonUtil.dateFormat.formatDefault) return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
    if (format === commonUtil.dateFormat.formatMin) return year + "-" + month + "-" + day + " " + hour + ":" + minutes;
}

// 获取某个年月的日历, 空值默认当年当月
xyuCalendar.getCalendarDate = function (year, month) {
    let curDate = new Date();
    if (year !== 0) year = year || curDate.getFullYear(); // 当前年份
    if (month !== 0) month = month || curDate.getMonth(); // 当前月份
    // 现在的年月日
    let curYear = curDate.getFullYear();
    let curMonth = curDate.getMonth();
    let curDay = curDate.getDate();
    let calendarDate = []; // 月日历
    let firstDayWeek = this.getMonthFirstDayWeek(year, month); // 获取指定月份的第一周
    let preMonthEndDay = this.getPreMonthEndDay(year, month); // 获取指定年月上月份的最后一天
    let monthEndDay = this.getMonthEndDay(year, month);
    let k = 1;
    // 日历遍历赋值
    for (let i = 0; i < 6; i++) {
        calendarDate[i] = [];
        for (let j = 0; j < 7; j++) {
            let dayObj = {};
            calendarDate[i][j] = dayObj;
            if (i === 0 && (firstDayWeek - j) >= 1) { // 第一排
                // 上月的
                // calendarDate[i][j].day = preMonthEndDay - (firstDayWeek - j) + 1;
            } else {
                if (k <= monthEndDay) {
                    // calendarDate[i][j] = k++;
                    calendarDate[i][j].day = k++;
                    calendarDate[i][j].dateStr = this.getFormatDate(new Date(year, month, calendarDate[i][j].day), commonUtil.dateFormat.formatDefault);
                    calendarDate[i][j].date = new Date(year, month, dayObj.day);
                    calendarDate[i][j].isToday = year === curYear && month === curMonth && calendarDate[i][j].day === curDay;
                    calendarDate[i][j].isWeekend = this.getWeek(calendarDate[i][j].date) === 0 || this.getWeek(calendarDate[i][j].date) === 6
                    // calendarDate[i][j] = dayObj;
                } else {
                    // k = 1;
                    // month++;
                    // calendarDate[i][j].day = k++;
                }
            } // 如果遍历到最后一天, 从1开始重新计数

        }
    }
    console.log(calendarDate);
    return calendarDate;
}

// 获取指定年月的第一天的星期数, 空值默认当年当月
xyuCalendar.getMonthFirstDayWeek = function (year, month) {
    if (year !== 0) year = year || new Date().getFullYear(); // 当前年份
    if (month !== 0) month = month || new Date().getMonth(); // 当前月份
    let date = new Date(year, month, 1);
    console.log(this.getFormatDate(date))
    // date.setFullYear(year); // 指定年份
    // date.setMonth(month); // 指定月份
    // date.setDate(1); // 指定日
    // 获取本月第一天星期数
    return this.getWeek(new Date(date));
}

// 获取指定年月上月份的最后一天, 空值默认当年当月
xyuCalendar.getPreMonthEndDay = function (year, month) {
    if (year !== 0) year = year || new Date().getFullYear(); // 当前年份
    if (month !== 0) month = month || new Date().getMonth(); // 当前月份
    let date = new Date(year, month, 0);
    return date.getDate();
}

// 获取指定年月下月份的第一天, 空值默认当年当月
xyuCalendar.getNextMonthFirstDay = function (year, month) {
    if (year !== 0) year = year || new Date().getFullYear(); // 当前年份
    if (month !== 0) month = month || new Date().getMonth(); // 当前月份
    let date = new Date(year, month + 1, 1);
    return date.getDate();
}

// 获取指定年月的第一天
xyuCalendar.getMonthFirstDay = function (year, month) {
    if (year !== 0) year = year || new Date().getFullYear(); // 当前年份
    if (month !== 0) month = month || new Date().getMonth(); // 当前月份
    let date = new Date(year, month, 1);
    return date.getDate();
}

// 获取指定年月的最后一天
xyuCalendar.getMonthEndDay = function (year, month) {
    if (year !== 0) year = year || new Date().getFullYear(); // 当前年份
    if (month !== 0) month = month || new Date().getMonth(); // 当前月份
    let date = new Date(year, month + 1, 0);
    return date.getDate();
}

// 获取指定日期是星期几, 传空默认为今天
xyuCalendar.getWeek = function (date) {
    date = date || new Date();
    // console.log("星期" + date.getDay());
    return date.getDay();
}