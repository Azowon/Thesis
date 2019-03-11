package david.schweizer.datenauswertung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class Logic {
    @Autowired
    private SportClient sportClient;
    @Autowired
    private ObjectivesClient objectivesClient;
    @Autowired
    private DevelopmentClient developmentClinet;

    public ArrayList<ObjectiveData> getObjectiveData(int id, String type) {
        return objectivesClient.getUserObjectives(id, type);
    }


    public ArrayList<String> getAllData(int id) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<ObjectiveData> Data = objectivesClient.getObjectiveDataById(id);
        Set<String> types = new HashSet<String>();
        for (ObjectiveData d : Data) {
            types.add(d.getType());
        }

        for (String s : types) {
            result.add(getData(id, s));
        }
        ArrayList<String> back = new ArrayList<String>();
        for (ArrayList<String> temp : result) {
            for (String s : temp) {
                back.add(s);
            }
        }
        return back;
    }


    public ArrayList<String> getData(int id, String type) {
        ArrayList<ObjectiveData> objectives = getObjectiveData(id, type);
        ArrayList<String> results = new ArrayList<String>();

        for (ObjectiveData currentObjective : objectives) {
            LocalDate startDate = parseDate(currentObjective.getStartDate());
            LocalDate endDate = parseDate(currentObjective.getEndDate()).isBefore(LocalDate.now()) ? parseDate(currentObjective.getEndDate()) : LocalDate.now();
            Period between = Period.between(startDate, endDate);


            if (currentObjective.getKind().equals("sports")) {
                ArrayList<SportData> data = sportClient.getSportDataWithType(id, type);


                int amount = 0;
                if (currentObjective.isRepetitive()) {
                    amount = between.getDays() * currentObjective.getAmount();
                } else
                    amount = currentObjective.getAmount();
                int resultAmount = 0;
                if (data == null)
                    continue;
                for (SportData d : data) {
                    if (checkDateInPeriod(startDate, endDate, parseDate(d.getDate()))) {
                        resultAmount += d.getAmount();//jetzt durch data iterieren, und alle herausfiltern bei denen das Date zwischen startdate und enddate liegt.
                    }
                }
                String result = "Die Challange beginnt am: " + currentObjective.getStartDate() + " und endet am: " + currentObjective.getEndDate() + " Die Gesamtanzahl von " + currentObjective.getType() + " ist: " + amount + " und davon wurden " + resultAmount + " gemacht.";
                results.add(result);
            } else {
                ArrayList<DevelopmentData> data = developmentClinet.getDevelopmentDataWithType(id, type);


                int amount;
                if (currentObjective.isRepetitive()) {
                    amount = between.getDays() * currentObjective.getAmount();
                } else
                    amount = currentObjective.getAmount();
                int resultAmount = 0;
                if (data == null)
                    continue;
                for (DevelopmentData d : data) {
                    if (checkDateInPeriod(startDate, endDate, parseDate(d.getDate()))) {
                        resultAmount += d.getAmount();//jetzt durch data iterieren, und alle herausfiltern bei denen das Date zwischen startdate und enddate liegt.
                    }
                }
                String result = "Die Challange beginnt am: " + currentObjective.getStartDate() + " und endet am: " + currentObjective.getEndDate() + " Die Gesamtanzahl von " + currentObjective.getType() + " ist: " + amount + " und davon wurden " + resultAmount + " gemacht.";
                results.add(result);
            }
        }
        return results;
    }

    public LocalDate parseDate(String date) {

        return LocalDate.of(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5, 7)), Integer.parseInt(date.substring(8, 10)));

    }

    public boolean checkDateInPeriod(LocalDate startDate, LocalDate endDate, LocalDate checkDate) {
        return checkDate.isBefore(endDate) && checkDate.isAfter(startDate);
    }


}
