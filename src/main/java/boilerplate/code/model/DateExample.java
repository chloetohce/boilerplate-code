package boilerplate.code.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateExample {
    
    /**
     * Example of how to add a date and test based on hour. 
     */
    @GetMapping("")
    public String conditionalDate(Model model) {
        model.addAttribute("currTime", new Date().toString());
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));

        return "conditional-date";
    }
    
    /**
     * Example of date parsing from String to java.util.Date using
     * SimpleDateFormat.
     * @throws ParseException 
     */
    @SuppressWarnings("unused")
    @GetMapping("")
    public void dateParsing() throws ParseException {
        String dob = "31 Dec 2001 18:13:00.000 zzz";

        // To get a date object, you'll need to have a SimpleDateFormat with a 
        // time zone.
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:MM:ss.SSS zzz");
        TimeZone tz = TimeZone.getTimeZone("Asia/Singapore");
        sdf.setTimeZone(tz);
        Date date = sdf.parse(dob);

        // To get long epoch in milliseconds
        Long epochDob = date.getTime();

        // Get data fron epoch long
        Date newDate = new Date(epochDob);

    }
    
}
