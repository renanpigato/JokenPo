import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Main {
	
	final static String GAME_FILE = "game.json";

	public static void main(String[] args) {
		
		try {
			
			JsonObject game = Main.readGame();
			
			if(!game.containsKey("game")) {
				throw new Exception("Não existe um jogo realizado");
			}
			
			JsonArray games = game.getJsonArray("game");
			
			for (int i = 0; i < games.size(); i++) {
				
				JsonObject gm = games.getJsonObject(i);
				
				if(!gm.containsKey("players")) {
					throw new Exception("O jogo "+ gm.getString("name") +"não contem jogadores");
				}
				
				Game g = new Game(gm, new Judge());
				System.out.println(g.result());
			}
		
		} catch (Exception e) {
			
			StackTraceElement[] trace = e.getStackTrace();
			
			System.out.println(e.getMessage());
			System.out.println("");
			
			for (int i = 0; i < trace.length; i++) {
				
				StackTraceElement traceElement = trace[i];
				String traceStr = new String("--> Trace: ");
				
				traceStr += "(Line: "+ traceElement.getLineNumber() +") ";
				traceStr += traceElement.getClassName();
				
				System.out.println(traceStr);
			}
		}
	}
	
	public static JsonObject readGame() throws Exception {
		
		String content = new String("");
		BufferedReader buffer = new BufferedReader(new FileReader(Main.GAME_FILE));
		
		while(buffer.ready()) {
			content += buffer.readLine();
		}
		buffer.close();
		
		JsonReader jsonR = Json.createReader(new StringReader(content));
		return jsonR.readObject();
	}
}
