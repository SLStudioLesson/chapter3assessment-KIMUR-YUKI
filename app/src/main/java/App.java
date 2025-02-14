import java.io.BufferedReader;
import java.io.InputStreamReader;

//import com.recipeapp.datahandler.CSVDataHandler;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            
            switch(choice){
                case "1"://1を選択した場合
                    //CSVDataHandler csvDataHandler = new CSVDataHandler();//CSVDataHandlerインスタンスを生成する
                    break;
                case "2"://2を選択した場合
                    //JSONDataHandler jsonDataHandler = new JSONDataHandler();//JSONDataHandlerインスタンスを生成する
                default://それ以外の不正な入力の場合
                    //CSVDataHandler csvDataHandler = new CSVDataHandler();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}