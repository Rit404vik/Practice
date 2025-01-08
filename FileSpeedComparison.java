import java.io.*;

public class FileSpeedComparison {
    public static void writeWithoutBuffer(String filepath){
        try (FileWriter writer = new FileWriter(filepath)){
            for(int i = 0; i<1000; i++){
                writer.write("Line" + (i+1) + "Writing without Buffer\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeWithBuffer(String filepath){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (int i = 0; i<1000; i++){
                writer.write("Line" + (i+1) + "Writing with Buffer");
                writer.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void compareWriteMethods(String filepath, String filepath2){

        long startTimeWithoutBuffer = System.nanoTime();
        writeWithoutBuffer(filepath2);
        long endTimeWithoutBuffer = System.nanoTime();
        long durationBetweenWithoutBuffer = endTimeWithoutBuffer - startTimeWithoutBuffer;
        System.out.println("Time taken without buffering: " + durationBetweenWithoutBuffer + " nanoseconds");

        long startTimeWithBuffer = System.nanoTime();
        writeWithBuffer(filepath);
        long endTimeWithBuffer = System.nanoTime();
        long durationBetweenWithBuffer = endTimeWithBuffer - startTimeWithBuffer;
        System.out.println("Time taken with buffering: " + durationBetweenWithBuffer + " nanoseconds");

        System.out.println("---------------------");

        if (durationBetweenWithBuffer < durationBetweenWithoutBuffer){
            System.out.println("Time with buffer is faster " + durationBetweenWithBuffer);
        } else {
            System.out.println("Time without buffer is faster " + durationBetweenWithoutBuffer);
        }

    }
    public static void main(String[] args) {

        String filepath = "output.txt";
        String filepath2 = "output_without_buff.txt";

        compareWriteMethods(filepath, filepath2);

    }
}
