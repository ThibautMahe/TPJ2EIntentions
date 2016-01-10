

import launcher.lab.Launcher;
import java.io.IOException;

public class MainInit {
	private void execute() throws IOException {
		Launcher.startTomcat(getClass());
	}

	public static void main(String[] args) throws IOException {
		new MainInit().execute();
	}
}
