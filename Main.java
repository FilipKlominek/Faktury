package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String content = "";

        ArrayList<String[]> data = new ArrayList<>(); // [invoice number, ičo, price]

        try {
            BufferedReader br = new BufferedReader(new FileReader("VF_2020.dat"));

            br.readLine(); //skip first line

            String nextLine = br.readLine();

            while (nextLine != null) {
                String[] row = nextLine.split(",");
                data.add(row);

                nextLine = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println();
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("VF_celkem.csv", true));

            for (int i = 0; i < data.size(); i++) {
                bw.write(data.get(i)[0]);
                bw.write(";");
                if (data.get(i)[1].equals("05159822")) bw.write("BlueNet, s.r.o.");
                else if (data.get(i)[1].equals("06230932")) bw.write("Epic Internet a.s.");
                else if (data.get(i)[1].equals("18539217")) bw.write("Big žirafa s.r.o.");
                else if (data.get(i)[1].equals("02838109")) bw.write("Martin Nový");
                else if (data.get(i)[1].equals("01846359")) bw.write("GreenStyles, a.s.");
                else if (data.get(i)[1].equals("9831829")) bw.write("Valza, a.s.");
                else bw.write("ZCZ, s.r.o.");
                bw.write(";");
                bw.write(data.get(i)[2]);
                bw.newLine();
            }

                bw.close();
        } catch (IOException e) {
            System.out.println();
        }
    }
}