import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * A simple and efficient client to run Stockfish from Java
 *
 * @author Rahul A R
 *
 */
public class Stockfish {

    private Process engineProcess;
    private BufferedReader processReader;
    private OutputStreamWriter processWriter;

    public boolean startEngine(String path) {
        try {
            engineProcess = Runtime.getRuntime().exec(path);
            processReader = new BufferedReader(new InputStreamReader(engineProcess.getInputStream()));
            processWriter = new OutputStreamWriter(engineProcess.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error starting Engine");
            return false;
        }
        return true;
    }

    public String getBestMove(String fen, int waitTime) {
        sendCommand("position fen " + fen);
        sendCommand("go movetime " + waitTime);
        String out = "";
        try {
            out = getOutput(waitTime + 200).split("bestmove ")[1].split(" ")[0];
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid move");
            out = "_____";
        }
        System.out.println(out);
        return out;
    }

    public void stopEngine() {
        try {
            sendCommand("quit");
            processReader.close();
            processWriter.close();
        } catch (IOException e) {
            System.out.println("Error closing engine");
            e.printStackTrace();
        }
    }

    private void sendCommand(String command) {
        try {
            processWriter.write(command + "\n");
            processWriter.flush();
        } catch (IOException e) {
            System.out.println("Error sending command");
            e.printStackTrace();
        }
    }

    private String getOutput(int waitTime) {
        StringBuffer buffer = new StringBuffer();
        try {
            Thread.sleep(waitTime);
            sendCommand("isready");
            while (true) {
                String text = processReader.readLine();
                if (text.equals("readyok"))
                    break;
                else
                    buffer.append(text + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error getting output");
            e.printStackTrace();
        }
        return buffer.toString();
    }

}
