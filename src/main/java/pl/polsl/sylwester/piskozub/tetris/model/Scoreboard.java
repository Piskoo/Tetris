package pl.polsl.sylwester.piskozub.tetris.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents scoreboard, holds data associated with scoreboard.
 *
 * @author Sylwester Piskozub
 * @version 1.4
 */
public class Scoreboard {

    /**
     * Scoreboard data
     */
    private final List<Record> data = new ArrayList<>();
    /**
     * Limit for how many records should be used
     */
    private final int sizeLimit = 10;
    /**
     * File name
     */
    private String fileName = "scoreboard.csv";

    /**
     * Non-parameter constructor
     */
    public Scoreboard() {
    }

    /**
     * File name getter
     *
     * @return file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * File name setter
     *
     * @param fileName file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method returns record data in String array format.
     *
     * @param index index of requested record
     * @return String array that contains, position, name, score in order
     */
    public String[] getRow(int index) {
        String[] row = new String[3];
        row[0] = Integer.toString(data.get(index).getPosition());
        row[1] = data.get(index).getName();
        row[2] = Integer.toString(data.get(index).getPoints());
        return row;
    }

    /**
     * Method returns scoreboard size, limited to sizeLimit.
     *
     * @return scoreboard size
     */
    public int getSize() {
        if (data.size() < sizeLimit) {
            return data.size();
        } else {
            return sizeLimit;
        }
    }

    /**
     * Method adds player score and name to scoreboard in the right position.
     *
     * @param player player information
     */
    public void addRow(Player player) {
        data.add(new Record(Integer.MAX_VALUE, player.getPlayerName(), player.getPlayerScore()));
        sortData();
        reassignPositions();
    }

    /**
     * Method loads data from specified file to data collection. If record is
     * corrupted it gets skipped. When finished loading data gets sorted and
     * positions in record reassigned.
     *
     *
     * @throws IOException when failed to open specified file
     */
    public void readDataFromFile() throws IOException {
        try ( BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                try {
                    int position = Integer.parseInt(values[0]);
                    String name = values[1];
                    int points = Integer.parseInt(values[2]);
                    Record newRecord = new Record(position, name, points);
                    data.add(newRecord);
                } catch (NumberFormatException e) {
                    //do nothing, skip record
                }
            }
            sortData();
            reassignPositions();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /**
     * Method saves data from data collection to in csv format to specified
     * file.
     *
     * @throws IOException when failed to open specified file
     */
    public void saveDataToFile() throws IOException {
        try ( FileWriter csvWriter = new FileWriter(fileName)) {
            for (Record record : data) {
                csvWriter.append(Integer.toString(record.getPosition()));
                csvWriter.append(",");
                csvWriter.append(record.getName());
                csvWriter.append(",");
                csvWriter.append(Integer.toString(record.getPoints()));
                csvWriter.append("\n");
            }
            csvWriter.flush();
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    /**
     * Method sorts data by points in record in descending order
     */
    private void sortData() {
        data.sort((r1, r2) -> r2.getPoints() - r1.getPoints());
    }

    /**
     * Method reassigns positions according to current record order in data
     */
    private void reassignPositions() {
        int i = 1;
        for (Record rec : data) {
            rec.setPosition(i++);
        }
    }
}
