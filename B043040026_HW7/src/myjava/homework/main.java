package myjava.homework;

import com.opencsv.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
//import jdk.nashorn.internal.parser.Scanner;
import javax.swing.*;
import java.io.BufferedReader;
import java.util.*;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
import java.text.DecimalFormat;


//import static myjava.homework.csvReader;

public class main {

    public static void main(String[] args) {


        Scanner keyboard = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        int countA = 0, countB = 0, countC = 0;//count product type
        int countMan = 0, countWoman = 0;//count gender
        int countAlldataSize=0;
        Vector vector_id = new Vector();
        Vector vector_product = new Vector();

        /*read all data from csvfile and put data to hashmap*/
        try {
            FileReader fileReader = new FileReader("query_result.csv");

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();


            int i = 0, j = 0;

            // put data to hashmap
            for (j = 0; j < allData.size(); ++j) {
                map.put("id", allData.get(j)[0]);
                map.put("product_type", allData.get(j)[1]);
                map.put("id_gender", allData.get(j)[2]);
                if (map.get("product_type").equals("Product_A")) {

                    countA++;
                } else if (map.get("product_type").equals("Product_B")) {
                    countB++;
                } else if (map.get("product_type").equals("Product_C")) {
                    countC++;
                }

                if (map.get("id_gender").equals("F")) {
                    countWoman++;
                } else if (map.get("id_gender").equals("M")) {
                    countMan++;
                }

                vector_id.add(map.get("id"));
                vector_product.add(map.get("product_type"));
                countAlldataSize++;
            }



        } catch (Exception e) {
            e.printStackTrace();
        }




        DecimalFormat df = new DecimalFormat("##.00");
        int total = countMan+countWoman;
        double manratio = ((double)countMan/(double)total)*100;
        double womanratio = ((double)countWoman/(double)total)*100;
        double Aratio = ((double)countA/(double)total)*100;
        double Bratio = ((double)countB/(double)total)*100;
        double Cratio = ((double)countC/(double)total)*100;

        //將 double 變數四捨五入到小數點後第二位
        manratio = Double.parseDouble(df.format(manratio));
        womanratio = Double.parseDouble(df.format(womanratio));
        Aratio = Double.parseDouble(df.format(Aratio));
        Bratio = Double.parseDouble(df.format(Bratio));
        Cratio = Double.parseDouble(df.format(Cratio));

        while (true) {

            try {
                int dataChoice = 0;
                int graphChoice = 0;
                String input_id = "";
                System.out.println("Which data of Market you want Graphic ? (1. produce 2. id_gender 3. id purchase history)");
                dataChoice = keyboard.nextInt();

                //break
                if (dataChoice == 0) {
                    return;
                }
                if (dataChoice == 1) {
                    System.out.println("Which kind of Graphic ? 1.Bar Chart 2.PieChart(3D)");
                    graphChoice = keyboard.nextInt();

                    if (graphChoice == 2) {
                        DefaultPieDataset pieDataset = new DefaultPieDataset();
                        //add data
                        pieDataset.setValue("Product_A :" + countA + "(" + Aratio + "%)", countA);
                        pieDataset.setValue("Product_B :" + countB + "(" + Bratio + "%)", countB);
                        pieDataset.setValue("Product_C :" + countC + "(" + Cratio + "%)", countC);

                        JFreeChart a = ChartFactory.createPieChart3D("Products sale situation", pieDataset, true, true, true);

                        ChartFrame frame = new ChartFrame("Products sale situation", a, true);

                        frame.pack();
                        frame.setVisible(true);
                    } else if (graphChoice == 1) {
                        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

                        //add data
                        defaultCategoryDataset.setValue(countA, "Category 1", "ProductA");
                        defaultCategoryDataset.setValue(countB, "Category 1", "ProductB");
                        defaultCategoryDataset.setValue(countC, "Category 1", "ProductC");

                        JFreeChart a = ChartFactory.createBarChart("Products sale situation", "product Compare", // do1
                                // main axis label

                                "Quantity", // range axis label

                                defaultCategoryDataset, // data

                                PlotOrientation.VERTICAL, // orientation

                                true, // include legend

                                true, // tooltips?

                                false // URLs?
                        );

                        ChartFrame frame = new ChartFrame("Products sale situation", a, true);

                        frame.pack();
                        frame.setVisible(true);


                    } else {
                        System.out.println("Please enter correct choice!!(1 or 2)");
                    }


                } else if (dataChoice == 2) {
                    System.out.println("Which kind of Graphic ? 1.Bar Chart 2.PieChart(3D)");
                    graphChoice = keyboard.nextInt();

                    if (graphChoice == 2) {
                        DefaultPieDataset pieDataset = new DefaultPieDataset();

                        //add data
                        pieDataset.setValue("Male :" + countMan + "(" + manratio + "%)", countMan);
                        pieDataset.setValue("Female :" + countWoman + "(" + womanratio + "%)", countWoman);

                        JFreeChart a = ChartFactory.createPieChart3D("id_gender", pieDataset, true, true, true);

                        ChartFrame frame = new ChartFrame("id_gender", a, true);

                        frame.pack();
                        frame.setVisible(true);
                    } else if (graphChoice == 1) {
                        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

                        //add data
                        defaultCategoryDataset.setValue(countMan, "Category 1", "Male");
                        defaultCategoryDataset.setValue(countWoman, "Category 1", "Female");

                        JFreeChart a = ChartFactory.createBarChart("id_gender", "id_gender Compare", // do1
                                // main axis label

                                "Quantity", // range axis label

                                defaultCategoryDataset, // data

                                PlotOrientation.VERTICAL, // orientation

                                true, // include legend

                                true, // tooltips?

                                false // URLs?
                        );

                        ChartFrame frame = new ChartFrame("id_gender", a, true);

                        frame.pack();
                        frame.setVisible(true);


                    } else {
                        System.out.println("Please enter correct choice!!(1 or 2)");
                    }


                } else if (dataChoice == 3) {
                    System.out.println("Input ID :");
                    input_id = keyboard.next();

                    int id_countA = 0, id_countB = 0, id_countC = 0;

                    for (int i = 0; i < vector_id.size(); ++i) {

                        if (vector_id.get(i).equals(input_id)) {
                            if (vector_product.get(i).equals("Product_A")) {
                                id_countA++;
                            } else if (vector_product.get(i).equals("Product_B")) {
                                id_countB++;
                            } else if (vector_product.get(i).equals("Product_C")) {
                                id_countC++;
                            }
                        }
                    }
                    DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

                    //add data
                    defaultCategoryDataset.setValue(id_countA, "Category 1", "ProductA");
                    defaultCategoryDataset.setValue(id_countB, "Category 1", "ProductB");
                    defaultCategoryDataset.setValue(id_countC, "Category 1", "ProductC");

                    JFreeChart a = ChartFactory.createBarChart(input_id + " purchase history", "Products", // do1
                            // main axis label

                            "Quantity", // range axis label

                            defaultCategoryDataset, // data

                            PlotOrientation.VERTICAL, // orientation

                            true, // include legend

                            true, // tooltips?

                            false // URLs?
                    );

                    ChartFrame frame = new ChartFrame(input_id + " purchase history", a, true);

                    frame.pack();
                    frame.setVisible(true);
                } else {
                    System.out.println("Please enter correct choice!!(1 or 2 or 3)");
                }

            }catch(InputMismatchException e){
                System.out.println("Input error : ONLY Integers.");
            }
        }

    }
}
