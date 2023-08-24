import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Введите дату в формате dd.MM.yyyy: ");
            String input = in.nextLine();
            date = ft.parse(input);
        } catch (ParseException e) {
            System.out.println("Ошибка ввода даты!");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Увеличить дату на 45 дней
        calendar.add(Calendar.DAY_OF_MONTH, 45);
        System.out.println("Дата через 45 дней: " + ft.format(calendar.getTime()));

        // Сдвинуть дату на начало года
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Дата в начале года: " + ft.format(calendar.getTime()));

        // Увеличить дату на 10 рабочих дней
        calendar.setTime(date);
        int day = 10;
        while (day > 0) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                day--;
            }
        }
        System.out.println("Дата через 10 рабочих дней: " + ft.format(calendar.getTime()));

        // Ввести вторую дату
        Date date2 = null;
        try {
            System.out.print("Введите вторую дату в формате dd.MM.yyyy: ");
            String input = in.nextLine();
            date2 = ft.parse(input);
        } catch (ParseException e) {
            System.out.println("Ошибка ввода даты!");
        }

        // Посчитать количество рабочих дней между датами
        int working_day = 0;
        calendar.setTime(date);
        while (calendar.getTime().before(date2)) {
            int week_day = calendar.get(Calendar.DAY_OF_WEEK);
            if (week_day != Calendar.SATURDAY && week_day != Calendar.SUNDAY) {
                working_day++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println("Количество рабочих дней между датами: " + working_day);
    }
}