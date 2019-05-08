package xyz.joseyamut.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorkbookInputPath {
	private static Path resourcePath;
	private static Path inputSrcPath;

	public WorkbookInputPath() { }
	
	static {
		try {
			resourcePath = Paths.get(Properties.getProperties().getApp().getResourcesDir(), Properties.getProperties().getApp().getInputDir());
			inputSrcPath = Paths.get(resourcePath.toString(), Properties.getProperties().getApp().getDatSrcAttr().getWorkbook());
			if (!Files.exists(inputSrcPath)) throw new IOException(inputSrcPath + " file does not exist!");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Path getPath() throws IOException {
		return inputSrcPath;
	}
}
