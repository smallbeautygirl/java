//package myjava.homework;
//import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
//
//import java.io.FileReader;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class csvReader {
//    public void csvReadDatatoHashMap(String csvfile , Map hashMap){
//        try{
//            FileReader fileReader = new FileReader(csvfile);
//
//            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
//            List<String[]> allData = csvReader.readAll();
//
//            int i=0;
//            for(String[] row : allData){
//                for(String cell : row){
//                    HashMap.put(i,cell);
//                }
//                i++;
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//}
