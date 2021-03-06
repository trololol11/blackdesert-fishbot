package ru.namibios.bdofishbot.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public final class MatrixUtils {

	private MatrixUtils() {}

	public static void printSrcMatrix(int[][] tmp){
		int row = tmp.length;
		int column = tmp[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(tmp[i][j]);
			}
			System.out.println();
		}
	}

	public static void printMatrix(int[][] tmp){
		int row = tmp.length;
		int column = tmp[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(tmp[i][j]!= 0 ? 1 : " ");
			}
			System.out.println();
		}
	}

	public static void printMatrix(int[][] tmp, String defaultSymbol){
		int row = tmp.length;
		int column = tmp[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(tmp[i][j]!= 0 ? 1 : defaultSymbol);
			}
			System.out.println();
		}
	}
	
	public static void printTemplate(int[][] tmp){
		int row = tmp.length;
		int column = tmp[0].length;
		
		System.out.println("new int[][]{");
		for (int i = 0; i < row; i++) {
			System.out.print("{");
			for (int j = 0; j < column; j++) {
				System.out.print((tmp[i][j] == 0 ? "0" : "1") + ", ");
			}
			System.out.print("},");
			System.out.println();
		}
		System.out.println("}");
		System.out.println();
	}
	
	public static int[][] importTemplate(List<String> list){
		
		int rowcnt = list.size();
		int columncnt = list.get(0).length();
		
		int[][] mas = new int[rowcnt][columncnt];
		
		for (int row = 0; row < list.size(); row++) {
			String v = list.get(row);
			char[] charArray = v.toCharArray();
			for (int column = 0; column < charArray.length; column++) {
				mas[row][column] = Character.getNumericValue(charArray[column]);
			}
		}
		
		return mas;
	}

	public static void export(int[][] sub) {
        try(FileWriter writer = new FileWriter("resources/templates/statuskapcha/tmp/" + UUID.randomUUID(), false)){

            for (int row = 0; row < sub.length; row++) {
                for (int column = 0; column < sub[0].length; column++) {
                    writer.write(String.valueOf(sub[row][column]));
                }
                writer.write(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}