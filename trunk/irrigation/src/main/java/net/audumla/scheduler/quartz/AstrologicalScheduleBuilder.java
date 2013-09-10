package net.audumla.scheduler.quartz;

import net.audumla.bean.BeanUtils;
import net.audumla.util.Geolocation;
import net.audumla.util.Time;
import org.quartz.ScheduleBuilder;
import org.quartz.spi.MutableTrigger;

import java.util.Calendar;
import java.util.Date;

public class AstrologicalScheduleBuilder extends ScheduleBuilder<AstrologicalTrigger> {

    private AstrologicalSchedule schedule = new AstrologicalSchedule();

    public static class AstrologicalSchedule {
        public Geolocation location = BeanUtils.buildBean(Geolocation.class);
        public ReferenceTime startTime = new SunriseReferenceTime(null, location);
        public ReferenceTime endTime = new SunsetReferenceTime(null, location);
        public int interval = 60 * 30; // 30 minutes
        public int repeat = Integer.MIN_VALUE;
    }

    public static abstract class ReferenceTime {
        int offset;
        Geolocation location;

        protected abstract Date getReferenceTime(Date now);

        public Date getOffsetTime(Date now) {
            Calendar c = Time.newCalendar();
            c.setTime(getReferenceTime(now));
            c.add(Calendar.SECOND, offset);
            return c.getTime();
        }

        protected void set(ReferenceTime rt, Geolocation location) {
            if (rt != null) {
                this.offset = rt.offset;
            }
            this.location = location;
        }
    }

    protected static class SunsetReferenceTime extends ReferenceTime {

        public SunsetReferenceTime() {
        }

        public SunsetReferenceTime(ReferenceTime rt, Geolocation location) {
            set(rt, location);
        }

        @Override
        public Date getReferenceTime(Date now) {
            return Time.getSunset(now, location.getLatitude(), location.getLongitude());
        }

    }

    protected static class SunriseReferenceTime extends ReferenceTime {

        public SunriseReferenceTime() {
        }

        public SunriseReferenceTime(ReferenceTime rt, Geolocation location) {
            set(rt, location);
        }

        @Override
        public Date getReferenceTime(Date now) {
            return Time.getSunrise(now, location.getLatitude(), location.getLongitude());
        }

    }

    public AstrologicalScheduleBuilder offsetStartFromSunset(int seconds) {
        schedule.startTime = new SunsetReferenceTime(schedule.startTime, schedule.location);
        schedule.startTime.offset = seconds;
        return this;
    }

    public AstrologicalScheduleBuilder offsetStartFromSunrise(int seconds) {
        schedule.startTime = new SunriseReferenceTime(schedule.startTime, schedule.location);
        schedule.startTime.offset = seconds;
        return this;
    }

    public AstrologicalScheduleBuilder offsetEndFromSunset(int seconds) {
        schedule.endTime = new SunsetReferenceTime(schedule.endTime, schedule.location);
        schedule.endTime.offset = seconds;
        return this;
    }

    public AstrologicalScheduleBuilder offsetEndFromSunrise(int seconds) {
        schedule.endTime = new SunriseReferenceTime(schedule.endTime, schedule.location);
        schedule.endTime.offset = seconds;
        return this;
    }

    public AstrologicalScheduleBuilder atLocation(double llat, double llong) {
        schedule.location.setLatitude(llat);
        schedule.location.setLongitude(llong);
        return this;
    }

    public AstrologicalScheduleBuilder withSecondInterval(int seconds) {
        schedule.interval = seconds;
        return this;
    }

    public AstrologicalScheduleBuilder withRepeatCount(int count) {
        schedule.repeat = count;
        return this;
    }

    public static AstrologicalScheduleBuilder astrologicalSchedule() {
        return new AstrologicalScheduleBuilder();
    }

    @Override
    protected MutableTrigger build() {
        return new AstrologicalTriggerImpl(schedule);
    }

}
