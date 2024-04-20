package com.example.calculatorapp;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class historyHandler {
    List<String> data = new ArrayList<>();
    public  void append(String str){
        data.add(str);
    }
    public void write (Context context) throws IOException {
        StringBuilder str = new StringBuilder();
        data.forEach(str::append);
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("CalcData.txt", Context.MODE_PRIVATE));
//            outputStreamWriter.write(str.toString());
//            outputStreamWriter.close();
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "MyAppData");
            if (!storageDir.exists() && !storageDir.mkdirs()) {
                Toast.makeText(context, "Failed to create directory", Toast.LENGTH_SHORT).show();
                return;
            }

            File file = new File(storageDir, "data.txt");
            try (FileWriter writer = new FileWriter(file)) {
                for (String item : data) {
                    writer.write(item + "\n");
                }
                Toast.makeText(context, "Data written to file", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(context, "Failed to write file: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
//        catch (IOException e) {
//            Log.e("Exception", "File write failed: " + e);
//        }
    }
}
