package util;

import model.Manager;
import model.Student;
import model.bank_accounts.Credit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class is responsible for adding interests to the credit cards
 */

public class interestTimer implements Runnable {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //date format
    private List<Credit> credits = new ArrayList(); //list of credits
    HashMap<Integer, Integer> studentHighest = new HashMap<Integer, Integer>(); //hash map of student id and transactions



        public void run(){
            credits = Manager.getCredit(); // get credit cards
            try {
                chargeCreditCardInterest(); //
                chargeInterest();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }

    /**
     * find the most recent balance of all students credit cards transactions and put it into the hashmap
     */
    public void chargeCreditCardInterest(){

            int highestID = 0;

            for(int i = 0; i < credits.size(); i++){

                int studentID = credits.get(i).getStudentId();

                if(!studentHighest.containsKey(studentID)){
                    studentHighest.put(studentID,0);
                    highestID = 0;

                    //find most recent transaction made by the student ID
                    for(int j = 0; j < credits.size(); j++){
                        highestID = credits.get(j).getId();
                        if(studentHighest.get(studentID) < highestID && credits.get(j).getStudentId() == studentID){
                            highestID = credits.get(j).getId();
                            studentHighest.put(studentID, highestID);

                        }
                    }

                }

                highestID = 0;

            }
        }


    /**
     * if today and the day account opened, charge interests
     * @throws ParseException
     */
    public void chargeInterest() throws ParseException {

            //search through the hashmap
            for(int i = 0; i < studentHighest.size(); i++){
                LocalDateTime now = LocalDateTime.now(); //get today's date

                if(studentHighest.containsKey(credits.get(i).getStudentId())){
                    String[] str; //use for splitting up the date
                    String dateOpened =  credits.get(i).getDateOpened(); //get date the credit account opened
                    str = dateOpened.split("T"); //split up the date and time

                    // convert into localdate
                    LocalDate currentDate
                            = LocalDate.parse(dtf.format(now));

                    LocalDate openedDate
                            = LocalDate.parse(str[0]);

                    int today = currentDate.getDayOfMonth(); //get day of Month of today
                    int day = openedDate.getDayOfMonth(); //get day of month when account opened

                    if(day==today && credits.get(i).isActive() == true){ // if account date matches today then charge

                        Credit credit = credits.get(i); //get credit to charge interests

                        // calculate the new balance
                        double charge = (credit.getBalance() + credit.getStatementBalance()) * credit.getApr();
                        double newStatementBalance = charge + credit.getBalance() + credit.getStatementBalance();
                        newStatementBalance = round(newStatementBalance,2); //round up to decimals places

                        credit.setStatementBalance(newStatementBalance);
                        credit.setBalance(newStatementBalance);
                        addInterest(credit); //mysql statement to call
                    }
                }

            }

        }


    /**
     * use the MySql to exe the database
     * @param credit object to change
     */
    public void addInterest(Credit credit){

            MySQLConnect mysql = new MySQLConnect(); //connect to sql
        //sql statement to run
            String queryString = "INSERT INTO metro_bank.credit " +
                    "(date_opened, is_active, student_id, " +
                    "balance, statement_balance ,available_credit ,apr, payment_made) VALUES (" +
                    "\"" + credit.getDateOpened() + "\"," +
                    "\"" + 1 + "\"," +
                    "\"" + credit.getStudentId() + "\"," +
                    "\"" + credit.getBalance() + "\"," +
                    "\"" + credit.getStatementBalance() + "\"," +
                    "\"" + credit.getAvailableCredit() + "\"," +
                    "\"" + credit.getApr()  + "\"," +
                    "\"," + 0 + "\");";

            String queryString2 = "UPDATE metro_bank.credit " + " SET balance =  \""+ credit.getBalance() + "\"," +
                    "statement_balance = \"" + credit.getStatementBalance() + "\"" +
                    " WHERE student_id = " +  credit.getStudentId() + ";";



            mysql.executeStatement(queryString);
            System.out.println("Interest Charged");
        }

    /**
     * round up a double to an x decimal places
     * @param value to round up
     * @param places how many places to round up to
     * @return final double
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP); //round up
        return bd.doubleValue();
    }


    /**
     * main
     * @param args
     */
        public static void main(String[] args) {

            interestTimer ex = new interestTimer();
            Thread t1 = new Thread(ex); //thread


            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Chicago"));
            ZonedDateTime nextRun = now.withHour(5).withMinute(0).withSecond(0); // when to run
            if(now.compareTo(nextRun) > 0) {
                nextRun = nextRun.plusDays(1); //caluclate new run
            }
            Duration duration = Duration.between(now, nextRun);
            long initalDelay = duration.getSeconds(); //amount of time to wait for first run

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(t1,
                    initalDelay, //wait before first run
                    TimeUnit.DAYS.toSeconds(1), //convert 1 day to seconds
                    TimeUnit.SECONDS);

        }


}
