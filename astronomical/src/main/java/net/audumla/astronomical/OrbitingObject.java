package net.audumla.astronomical;

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
import java.util.Date;

/**
 * Interface description
 *
 * @author         Marius Gleeson
 */
public interface OrbitingObject {
    int SUN = 0;
    int MERCURY = 1;
    int VENUS = 2;
    int MARS = 3;
    int JUPITER = 4;
    int SATURN = 5;
    int URANUS = 6;
    int NEPTUNE = 7;
    int PLUTO = 8;
    int EARTH = 9;

    /**
     *
     * @return Returns the type of the object represented
     */
    int getType();

    /**
     *
     *
     * @param date      The Day that will be used to base the transit time on.
     * @param location  The location on the Earth to measure the transit of the object
     * @param altitude  The "standard" altitude in degrees i.e. the geometric altitude of the centre of the body at the time of the apparent rising or setting. For stars and planets, you would normally use -0.5667, for the Sun you would use -0.8333 and for the moon you would use 0.7275 * PI - 0.5666 where PI is the Moon's horizontal parallax in degrees (If no great accuracy is required, the mean value of h0 = 0.125 can be used).
     *
     * @return Returns details about the objects transit for a given day
     */
    TransitDetails getTransitDetails(Date date, Geolocation location, double altitude);
}


//~ Formatted by Jindent --- http://www.jindent.com
