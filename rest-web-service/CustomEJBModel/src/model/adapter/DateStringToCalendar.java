package model.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Custom XMLAdapter to support JAX-B conversion from String to date so the Customers
 * entity hiredate attribute can be updated with the correct type.
 */
public class DateStringToCalendar extends XmlAdapter<String, Date> {

    public DateStringToCalendar() {
        super();
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String marshal(Date date) throws Exception {
        if (date != null) {
            return dateFormat.format(date);
        } else {
            return null;
        }
    }

    @Override
    public Date unmarshal(String dateString) throws Exception {
        if (dateString != null) {
            Date _date = dateFormat.parse(dateString);
            return _date;
        } else {
            return null;
        }

    }
}
