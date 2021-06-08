package ua.com.alevel;

import ua.com.alevel.annotation.UserCsv;
import ua.com.alevel.model.CsvData;
import ua.com.alevel.model.User;
import ua.com.alevel.util.CsvMapper;
import ua.com.alevel.util.CsvParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        try (InputStream inputStream = Application.class.getResourceAsStream("/user.csv")) {
            CsvData data = CsvParser.parse(inputStream);
            List<User> users = CsvMapper.map(User.class, data);
            for (User user : users) {
                System.out.println(user.toString());
            }

            System.out.println("1) по номеру строки: 1 и столбца 2:\n" + data.getUsersByRowAndColumn(1, 2));
            System.out.println("2) по номеру строки: 1 и тексту заголовка\"name\":\n"
                    + data.getUsersByRowNumberAndNameOfColumn(1, "name"));
            System.out.println("3) список заголовков:\n" + Arrays.toString(data.getHead()));

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
