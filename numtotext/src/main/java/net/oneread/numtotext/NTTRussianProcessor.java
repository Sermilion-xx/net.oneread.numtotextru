package net.oneread.numtotext;

import net.oneread.numtotext.Exception.NanException;
import net.oneread.numtotext.Exception.NumberOverTrillionException;
import net.oneread.numtotext.Interfaces.NTTProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ---------------------------------------------------
 * Created by Sermilion on 14/12/2016.
 * Project: Library
 * ---------------------------------------------------
 * <a href="http://www.ucomplex.org">ucomplex.org</a>
 * <a href="http://www.github.com/sermilion>github</a>
 * ---------------------------------------------------
 */

public class NTTRussianProcessor implements NTTProcessor {

    private static final int STR_LESS_THAN_TWENTY = 0;
    private static final int LESS_THAN_HUNDRED = 1;
    private static final int LESS_THAN_THOUSAND = 2;
    private static final int SEX_FEMALE = 1;
    private static final int SEX_MALE = 0;

    private final String[][] sex = {
            {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
    };
    private final String[][] str1_10_100 = {
            {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать"},
            {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"},
            {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"}
    };
    private final String[][] forms = {
            {"тысяч", "тысяча", "тысячи", "тысячи", "тысячи", "тысяч", "тысяч", "тысяч", "тысяч", "тысяч", "тысяч"},
            {"миллионов", "миллион", "миллиона", "миллиона", "миллиона", "миллионов", "миллионов", "миллионов", "миллионов", "миллионов"},
            {"миллиардов", "миллиард", "миллиарда", "миллиарда", "миллиарда", "миллиардов", "миллиардов", "миллиардов", "миллиардов", "миллиардов"},
            {"триллион", "триллион", "триллиона"},
    };

    private NTTRussianProcessor() {

    }

    public static NTTRussianProcessor getInstance() {
        return new NTTRussianProcessor();
    }

    //TODO: можно добавить многопоточную работу

    /**
     * Публичный метод для начала процесса перевода цифр в строки
     * @param items лист цифр
     * @return лист цифр в строковом виде
     */
    @Override
    public List<String> process(List<String> items) throws NanException {
        List<String> processedItems = new ArrayList<>();
        for (String word : items) {
            if(!isNum(word)){
                throw new NanException();
            }
            processedItems.add(numToString(Integer.valueOf(word)));
        }
        return processedItems;
    }

    public static boolean isNum(String strNum) {
        boolean ret = true;
        try {
            Integer.parseInt(strNum);
        }catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }

    /**
     * Главный метод, инициирующий перевод числа в его строковой вид.
     *
     * @param num - входной номер
     * @return строковой вид числа
     */
    public String numToString(long num) {
        StringBuilder result;
        if (num > 1000000000000L) {
            throw new NumberOverTrillionException();
        }
        result = new StringBuilder();
        //делим число на части по сотням
        ArrayList<Long> numberParts = splitNumberToParts(num);
        ArrayList<String> partsList = new ArrayList<>();
        //обрабатываем каждую часть числа отдельно переводя в строку
        for (int i = 0; i < numberParts.size(); i++) {
            String part = processPart(numberParts.get(i), i);
            if (!part.equals("")) {
                partsList.add(part);
            }
        }
        Collections.reverse(partsList);
        //собираем строковые части в конечную строку
        for (String part : partsList) {
            result.append(part);
            result.append(" ");
        }
        return result.toString().trim();

    }

    /**
     * Обрабатывает каждую часть числа, переводя ее в строку
     *
     * @param numberPart    - часть числа (<1000)
     * @param numberSection - чсть числа (1 - сотая, 2 - тысячная ...)
     * @return строковой вид части числа
     */
    private String processPart(long numberPart, int numberSection) {
        StringBuilder result;
        if (numberSection == 0) {
            result = processHundreds(numberPart);
        } else if (numberSection == 1) {
            result = processGreaterThanThousend(numberPart, numberSection, SEX_FEMALE);
        } else {
            result = processGreaterThanThousend(numberPart, numberSection, SEX_MALE);
        }
        return result != null ? result.toString().trim() : "";
    }

    /**
     * Метод для обработки части номера больше 999
     *
     * @param numberPart    - часть числа (<1000)
     * @param numberSection - чсть числа (1 - сотая, 2 - тысячная ...)
     * @param gender        - склонение чисел от 0 - 9
     * @return строковой вид части числа
     */
    private StringBuilder processGreaterThanThousend(long numberPart, int numberSection, int gender) {
        StringBuilder result = new StringBuilder();
        if (numberPart > 0) {
            if (numberPart < 10) {
                result.append(sex[gender][(int) numberPart]);
                result.append(" ");
                result.append(forms[numberSection - 1][(int) numberPart]);
            } else {
                int remainder;
                int divisor;
                if (numberPart < 100) {
                    remainder = (int) numberPart % 10;
                    divisor = 10;
                    result.append(str1_10_100[LESS_THAN_HUNDRED][(int) numberPart / divisor]);
                } else {
                    remainder = (int) numberPart % 100;
                    divisor = 100;
                    result.append(str1_10_100[LESS_THAN_THOUSAND][(int) numberPart / divisor]);
                }
                StringBuilder lvlTwo = processHundreds(remainder);
                if (lvlTwo.length() > 0) {
                    result.append(" ");
                    result.append(processHundreds(remainder));
                }
                result.append(" ");
                int temp = (int) numberPart;
                while (temp > 10) {
                    temp = temp % 10;
                }
                result.append(forms[numberSection - 1][temp]);
            }
        }
        return result;
    }

    /**
     * Метод для обработки части номера меньше 999
     *
     * @param part - часть числа
     * @return строковой вид части числа
     */
    private StringBuilder processHundreds(long part) {
        StringBuilder result = new StringBuilder();
        if (part < 10) {
            result.append(sex[SEX_MALE][(int) part]);
        } else if (part < 21) {
            result.append(str1_10_100[STR_LESS_THAN_TWENTY][(int) part % 10]);
        } else if (part < 100) {
            result.append(str1_10_100[LESS_THAN_HUNDRED][(int) part / 10]);
            result.append(" ");
            result.append(sex[SEX_MALE][(int) part % 10]);
        } else {
            result.append(str1_10_100[LESS_THAN_THOUSAND][(int) part / 100]);
            result.append(" ");
            result.append(processPart((int) part % 100, 0));
        }
        return result;
    }

    /**
     * Метод для разделения числа на части из сотен
     * Пример: 230 567 304 - лист [304, 567, 230]
     *
     * @param num номер для обработки
     * @return лист с частями номера
     */
    private ArrayList<Long> splitNumberToParts(long num) {
        ArrayList<Long> parts = new ArrayList<>();
        int divisor = 1000;
        while (num > 999) {
            long part = num % divisor;
            parts.add(part);
            num = num / divisor;
            System.out.println();
        }
        parts.add(num);
        return parts;
    }
}
