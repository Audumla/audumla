package net.audumla.astronomical.algorithims;

/*
 * *********************************************************************
 *  ORGANIZATION : audumla.net
 *  More information about this project can be found at the following locations:
 *  http://www.audumla.net/
 *  http://audumla.googlecode.com/
 * *********************************************************************
 *  Copyright (C) 2012 - 2013 Audumla.net
 *  Licensed under the Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 *  You may not use this file except in compliance with the License located at http://creativecommons.org/licenses/by-nc-nd/3.0/
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 *  "AS IS BASIS", WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 */

import net.audumla.astronomical.Geolocation;
import net.audumla.astronomical.Location;
import net.audumla.astronomical.OrbitingObject;
import net.audumla.astronomical.TransitDetails;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public abstract class EllipticalObject implements OrbitingObject {

    protected EllipticalObject() {
    }

    public abstract double eclipticLongitude(double JD);

    public abstract double eclipticLatitude(double JD);

    public abstract double radiusVector(double JD);

    @Override
    public TransitDetails getTransitDetails(Date date, Geolocation location, double altitude) {
        JulianTransitDetails details = calcTransitDetails(date,location,altitude);
        JulianTransitDetails detailsAdj = null;
        if (!DateUtils.isSameDay(date,details.getRiseTime())) {
            detailsAdj = calcTransitDetails(DateUtils.addHours(date,date.after(details.getRiseTime()) ? 24 : -24),location,altitude);
            details.setRise((detailsAdj.getJulianRise().julian() - details.getReferenceTime().julian())*24);
        }

        if (!DateUtils.isSameDay(date,details.getSetTime())) {
            detailsAdj = calcTransitDetails(DateUtils.addHours(date,date.after(details.getSetTime()) ? 24 : -24),location,altitude);
            details.setSet((detailsAdj.getJulianSet().julian() - details.getReferenceTime().julian())*24);
        }

        return details;
    }

    protected JulianTransitDetails calcTransitDetails(Date date, Geolocation location, double altitude) {
        JulianDate jd = new JulianDate(date);
        EllipticalPlanetaryDetails aoDetails = Elliptical.calculate(jd.julian() - 1, this);
        double Alpha1 = aoDetails.ApparentGeocentricRA;
        double Delta1 = aoDetails.ApparentGeocentricDeclination;
        aoDetails = Elliptical.calculate(jd.julian(), this);
        double Alpha2 = aoDetails.ApparentGeocentricRA;
        double Delta2 = aoDetails.ApparentGeocentricDeclination;
        aoDetails = Elliptical.calculate(jd.julian() + 1, this);
        double Alpha3 = aoDetails.ApparentGeocentricRA;
        double Delta3 = aoDetails.ApparentGeocentricDeclination;

        return RiseTransitSet.calculate(jd.julian(), Alpha1, Delta1, Alpha2, Delta2, Alpha3, Delta3, location.getLongitude(Geolocation.Direction.WEST), location.getLatitude(Geolocation.Direction.NORTH), altitude);

    }
}
