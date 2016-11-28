package tools;

public class sqltool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outPrint();
	}

	public static void outPrint() {
		for (int i = 1; i <= 200; i++) {
			int sum = 8000 + i;
			int a = 111111;
			System.out.println("insert into user_trust(phone,auth_code,status)values(" + "'" + "1000000" + sum + "'"
					+ "," + "'" + a + "'" + "," + 0 + ")" + ";");
			
		}
		System.out.println();
	}
}
