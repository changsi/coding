import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ChangXS {

	public static void coding(String input, String output) {
		File input_file = new File(input);
		StringBuffer input_buffer = new StringBuffer();
		if (!input_file.exists()) {
			System.out.println("Please typein a valid input file name!");
		} else {
			try{
				String line;
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(input_file)));
				line = reader.readLine();
				while (line != null) {
					input_buffer.append(line);
					line = reader.readLine();
				}
				
				for(int i=0;i<input_buffer.length();i++){
					char a = input_buffer.charAt(i);
					if(a>='a' && a<='z'){
						a = (char) (((int)a)+13);
						if(a>'z'){
							a = (char) ('a'+(a -'z'-1));
						}
					}
					if(a>='A' && a<='Z'){
						a = (char) (((int)a)+13);
						if(a>'Z'){
							a = (char) ('A'+(a -'Z'-1));
						}
					}
					if(a>='0'&& a<='9'){
						a = (char) (a+5);
						if(a>'9'){
							a = (char) ('0'+(a-'9'-1));
						}
					}
					input_buffer.setCharAt(i, a);
				}
				
				reader.close();
				File output_file = new File(output);
				if(!output_file.exists()){
					output_file.createNewFile();
				}
				BufferedWriter utput = new BufferedWriter(new FileWriter(output_file));
				utput.write(input_buffer.toString());
				utput.close();
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("please input the correct arguments!");
		} else {
			ChangXS.coding(args[0], args[1]);
		}

	}

}
