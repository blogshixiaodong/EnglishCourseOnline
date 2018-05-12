/*
 * 后台返回时间格式化
 * */
function AppendZero(number) {
	if (number < 10) {
		return "0" + number;
	}
	return number;
}

 function JsonDateToString(dateObject) {
	var year = 1900 + dateObject.year;
	var month = 1 + dateObject.month;
	var day = dateObject.date;
	var hours = dateObject.hours;

	var minutes = dateObject.minutes;

	var seconds = dateObject.seconds;

	return year + "-" + AppendZero(month) + "-" + AppendZero(day) + " "
			+ AppendZero(hours) + ":" + AppendZero(minutes) + ":"
			+ AppendZero(seconds);
}