
import java.util.Scanner;


/**
 * Created by colinhill on 9/7/15.
 */
public class Main {
    public static final double EARTH_RADIUS = 6372.795; //km

    public static void main(String[] args) {

            Scanner console = new Scanner(System.in);

            Intro();

            //Prompt for Values
            //This can either go in the intro method or in the Main Method
            System.out.print("1. Enter a value for Latitude 1 (in degrees): ");
            double lat1 = console.nextDouble();
            lat1 = degreesToRad(lat1);

            System.out.print("2. Enter a value for Longitude 1 (in degrees): ");
            double lon1 = console.nextDouble();
            lon1 = degreesToRad(lon1);

            System.out.print("3. Enter a value for Latitude 2 (in degrees): ");
            double lat2 = console.nextDouble();
            lat2 = degreesToRad(lat2);
            System.out.print("4. Enter a value for Longitude 2 (in degrees): ");
            double lon2 = console.nextDouble();
            lon2 = degreesToRad(lon2);

            //Send Degree Values to be converted to Radians
            computeDistance(lat1, lon1, lat2, lon2);

        }

        public static void Intro() {
            // Introduce the user to the Program
            header();
            System.out.println("Enter the Latitude and Longitude of 2");
            System.out.println("locations in degrees, to calculate the");
            System.out.println("spherical distance between the two locations.");
            System.out.println();



        }

        public static void writeChar(char ch, int count) {
            for (int i = 1; i <= count; i++) {
                System.out.print(ch);
            }
            System.out.println();
        }

        public static void header() {
            String welcome ="Welcome to the Gps Distance Calculator";
            writeChar('*', welcome.length());
            writeChar('/', welcome.length());
            System.out.println(welcome.toUpperCase());
            writeChar('\\', welcome.length());
            writeChar('*', welcome.length());
            System.out.println();

        }





        //Converts degree values to Radians
        public static double degreesToRad (double coordinate) {
            double coordinateInRad = Math.toRadians(coordinate);

            return coordinateInRad;
        }

        //Pass in Radians then computes the Distance
        public static double computeDistance (double omega1, double lambda1, double omega2, double lambda2) {

            double sphericalLaw = Math.acos(Math.sin(omega1) * Math.sin(omega2) +
                    Math.cos(omega1) * Math.cos(omega2) *
                            (Math.cos(lambda2 - lambda1)));

            System.out.println("Spherical Law answer = " + sphericalLaw);

            double angularDistance = EARTH_RADIUS * sphericalLaw;
            angularDistance = Math.round(angularDistance * 100.0) / 100.0;


            double miles = angularDistance * 0.621371;
            miles = Math.round(miles * 100.0) / 100.0;

            System.out.println("The distance between the two locations is " +
                    angularDistance + " km or " + miles + " miles");

            return angularDistance;
        }


    }




