package dectohex;
import constants.*;
import constants.WeekDays.Days;

public class decimaltohexadec {
 public static void d2h() {
	 System.out.println("dec to hex");
		Days wk; 			//wk is an enumeration variable of type WeekDays
		wk = WeekDays.Days.FRIDAY;//wk can be assigned only the constants defined under enum type Weekdays
		System.out.println("Today is "+wk);
 }
}


