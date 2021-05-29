package com.tms.hm12.task0;
/**
 * Программа проверяет на валидность номера документов, которые считывает из файла. Записывает их в файл с комментарием
 * валиден он или нет.
 */

import java.io.*;
import java.util.*;


public class CheckDocNumberOfFiles5 {

    public static void main(String[] args) {
       boolean isContinue = true;

       ArrayList<String> listOfDoc = new ArrayList<>();
       HashSet<String> hashDocNum = new HashSet<>();
       HashMap<String, String> result = new HashMap<>();

        // записываем все пути документов в 1 массив
       while (isContinue == true){
           Scanner inWay = new Scanner(System.in);
           System.out.println("Укажите путь к файлу с номерами документов. Для завершения ввода нажмите 0.");
           String wayToDoc = inWay.next();

           if (wayToDoc.equals("0")){
               isContinue = false;
           } else{
               listOfDoc.add(wayToDoc);
           }
       }

       //записываем номера документов в 1 файл без повторений
        for (String item : listOfDoc){
            try(BufferedReader docNumberRd = new BufferedReader(new FileReader(item))){
                String line;
                while ((line = docNumberRd.readLine()) != null){
                    hashDocNum.add(line);
                }
            }catch (IOException e){
                e.getMessage();
            }
        }

        //проверяем номера документов на валидность и записываем в HashMap
        for (String item : hashDocNum) {
            if (isSizeCorrect(item)){
                if (isStartCorrect(item)){
                    if (isOnlyLettersAndNum(item)){
                        result.put(item, " - номер документа валиден.");
                    } else {
                        result.put(item, " - номер документа содержит не только буквы и цифры.\n");
                    }
                } else {
                    result.put(item, " - документ начинается неправильно.\n");
                }
            } else if (isSizeMore(item)){
                result.put(item, " - размер больше 15 символов.\n");
            } else {
                result.put(item, "- размер меньше 15 символов.\n");
            }
        }

        //записываем номера документов в файл
        try (BufferedWriter docNumberResult = new BufferedWriter(new FileWriter("docNumberResult.txt"))){
            for (String item : result.keySet()){
                docNumberResult.write(item + result.get(item) + "\n");
            }
        } catch (IOException e){
            e.getMessage();
        }
    }

    private static boolean isSizeCorrect(String docNumber){
        if (docNumber.length() == 15){
            return true;
        } else {
            return false;
        }
    }

    private static boolean isSizeMore(String docNumber){
        if (docNumber.length() > 15){
            return true;
        } else {
            return false;
        }
    }
    private static boolean isStartCorrect(String docNumber){
        if (docNumber.substring(0,6).equals("docnum") || docNumber.substring(0,8).equals("kontract")){
            return true;
        } else {
            return false;
        }
    }

    private static boolean isOnlyLettersAndNum(String docNumber){
        if (docNumber.matches("[A-Za-z_0-9]+")){
            return true;
        } else {
            return false;
        }
    }

}
