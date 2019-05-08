package xyz.joseyamut.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PresentationOutputPath {
	private static Path outputDirPath;

	public PresentationOutputPath() { }
	
	static {
		try {
			outputDirPath = Paths.get(Properties.getProperties().getApp().getResourcesDir(), Properties.getProperties().getApp().getOutputDir());
			if (!Files.isDirectory(outputDirPath)) Files.createDirectory(outputDirPath);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}		
	}

	public static Path getPath() throws IOException {
		return Paths.get(outputDirPath.toString(), Properties.getProperties().getPresentation().getName());
	}
}
