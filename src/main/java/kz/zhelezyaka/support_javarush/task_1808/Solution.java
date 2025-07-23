package kz.zhelezyaka.support_javarush.task_1808;

import java.io.*;

/* 
Разделение файла
*/

//public class Solution {
//    public static BufferedReader userInput;
//
//    public static void main(String[] args) {
//        String filePath1 = userInputFilePath();
//        String filePath2 = userInputFilePath();
//        String filePath3 = userInputFilePath();
//
//        try {
//            userInput.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ArrayList<Integer> byteList = getAllByteFromFile(filePath1);
//
//        writeInFile(byteList, filePath2, filePath3);
//
//    }
//
//    private static String userInputFilePath() {
//        String filePath = "";
//        try {
//            userInput = new BufferedReader(new InputStreamReader(System.in));
//            filePath = userInput.readLine();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return filePath;
//    }
//
//    private static ArrayList<Integer> getAllByteFromFile(String filePath) {
//
//        ArrayList<Integer> byteList = new ArrayList<>();
//
//        try (FileInputStream inputStream = new FileInputStream(filePath)) {
//            while (inputStream.available() > 0) {
//                byteList.add(inputStream.read());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return byteList;
//    }
//
//    private static void writeInFile(ArrayList<Integer> byteList, String file2, String file3) {
//
//        int oneBlock = 0;
//
//        if (byteList.size() % 2 == 0) {
//            oneBlock = byteList.size() - (byteList.size() / 2);
//            writeInOneFiles(new ArrayList<>(byteList.subList(0, oneBlock)), file2);
//            writeInOneFiles(new ArrayList<>(byteList.subList(oneBlock, byteList.size())), file3);
//        } else {
//            oneBlock = (byteList.size() - (byteList.size() / 2)) - 1;
//            writeInOneFiles(new ArrayList<>(byteList.subList(0, oneBlock)), file2);
//            writeInOneFiles(new ArrayList<>(byteList.subList(oneBlock, byteList.size())), file3);
//        }
//    }
//
//    private static void writeInOneFiles(ArrayList<Integer> byteList, String pathFile) {
//
//        try (FileOutputStream outputStream = new FileOutputStream(pathFile)) {
//            for (Integer cell : byteList) {
//                outputStream.write(cell);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

public class Solution {
    public static void main(String[] args) throws IOException {
        // Считываем имена файлов
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String filePath1 = reader.readLine();
            String filePath2 = reader.readLine();
            String filePath3 = reader.readLine();

            // Читаем и делим файл
            try (FileInputStream inputStream = new FileInputStream(filePath1);
                 FileOutputStream outputStream2 = new FileOutputStream(filePath2);
                 FileOutputStream outputStream3 = new FileOutputStream(filePath3)) {

                // Получаем размер файла
                int totalBytes = inputStream.available();
                // Вычисляем, сколько байт должно быть в file2 (большая часть при нечётном)
                int bytesToFile2 = (totalBytes % 2 == 0) ? totalBytes / 2 : (totalBytes / 2) + 1;

                // Читаем и записываем первую половину в file2
                for (int i = 0; i < bytesToFile2 && inputStream.available() > 0; i++) {
                    outputStream2.write(inputStream.read());
                }

                // Читаем и записываем вторую половину в file3
                while (inputStream.available() > 0) {
                    outputStream3.write(inputStream.read());
                }
            }
        }
    }
}

// Что изменилось:

// Один BufferedReader в try-with-resources для чтения всех трёх имён файлов.
// Правильное разделение байт: file2 получает большую часть при нечётном числе (totalBytes / 2 + 1).
// Чтение и запись напрямую через FileInputStream и FileOutputStream.
// Убраны лишние сообщения об ошибках.
// Все потоки закрываются через try-with-resources.
