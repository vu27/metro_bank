package util;

import model.Manager;
import model.bank_accounts.Credit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * This is just a testing ground to test code out
 */


public class test {







    public static void main(String[] args) throws ParseException {

        List<Credit> credits = new ArrayList();
        List<Integer> studentIDs = new ArrayList<>();
        HashMap<Integer, Integer> studentHighest = new HashMap<Integer, Integer>();
        ArrayList<ArrayList<Integer> > aList =
                new ArrayList<ArrayList<Integer> >();
        ArrayList<Integer> inner = new ArrayList<>();


        int highestID = 0;
        credits = Manager.getCredit();
        Credit credit = credits.get(1);
        credit.setBalance(100);
        MySQLConnect mysql = new MySQLConnect();
        String queryString2 = "UPDATE metro_bank.credit " + " SET balance =  \""+ credit.getBalance() + "\"," +
                "statement_balance = \"" + credit.getStatementBalance() + "\"" +
                " WHERE student_id = " +  credit.getStudentId() + ";";
        mysql.executeStatement(queryString2);
        for(int i = 0; i < credits.size(); i++){
            highestID = 0;
            int studentID = credits.get(i).getStudentId();

            if(!studentHighest.containsKey(studentID)){
                //studentIDs.add(studentID);
                studentHighest.put(studentID,0);


                for(int j = 0; j < credits.size(); j++){
                    highestID = credits.get(j).getId();

                    if(studentHighest.get(studentID) < highestID && credits.get(j).getStudentId() == studentID){

                        highestID = credits.get(j).getId();
                        //studentIDs.add(highestID);
                        studentHighest.put(studentID, highestID);
                        highestID = 0;

                    }
                }




                //


                //aList.add(inner);
            }







        }
        System.out.println(studentHighest);

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SimpleDateFormat formatter3=new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate = formatter3.parse(dtf.format(now));
        //String dateNow(dtf.format(now));


        System.out.println(dtf.format(now));

        //nowDate = dtf.format(now);

        //String date2 = dtf.format(now);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat formattter2 = new SimpleDateFormat("dd");



        //Date newDate1 = formatter3.parse(date2);


        for(int i = 0; i < studentHighest.size(); i++){

            if(studentHighest.containsKey(credits.get(i).getStudentId())){

                String[] str;
                String date =  credits.get(i).getDateOpened();
                str = date.split("T");
                //dtf.format(date);
                //date.replace("2021-","");

                Date date2 = formatter.parse(str[0]);
                //String sDate1=str[0].substring(5,9);

                LocalDate currentDate
                        = LocalDate.parse(dtf.format(now));




                Date newDate = formatter3.parse(date);
                newDate.getDay();

                Calendar cal = Calendar.getInstance();
                cal.setTime(date2);
                System.out.println(currentDate.getDayOfMonth());




                //Date date3 = formattter2.parse(date2);
                //System.out.println(str[0]);
                //System.out.println(date2);

                System.out.println(nowDate);
                System.out.println(nowDate.getYear());

                if(nowDate.getDay()==date2.getDay()){
                    System.out.println("it works");
                }









            }

        }





    }
}
