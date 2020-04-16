
/*
Maximum byte
Enter the file name from the console.
Find the maximum byte in the file, display it on the screen.
Close the I / O stream.


Requirements:
1. The program should read the file name from the console.
2. To read from a file, use the FileInputStream stream.
3. The maximum byte read from the file should be output to the console.
4. The stream of reading from the file should be closed.
*/

import java.io.*;

public class MaxFileByte {
    public static void main(String[] args) {
        String filePathAndName = null;
        FileInputStream fileForRead = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            filePathAndName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileForRead = new FileInputStream(filePathAndName);
            int mustCompareByte = fileForRead.read();
            int mustCompareByteNext;
            while ((mustCompareByteNext = fileForRead.read()) != -1) {
                if (mustCompareByteNext > mustCompareByte) {
                    mustCompareByte = mustCompareByteNext;
                }
            }
            System.out.println(mustCompareByte);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileForRead != null) {
                    fileForRead.close();
                }
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }
}