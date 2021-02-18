package ch11basicAPI;

public class SystemEnvExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String javaHome = System.getenv("JAVA_HOME");
		System.out.println("JAVA_HOME:" + javaHome);

		String path = System.getenv("Path");
		System.out.println("Path:" + path);

	}

}
