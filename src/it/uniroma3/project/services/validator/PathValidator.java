package it.uniroma3.project.services.validator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class PathValidator {
	private File source;
	private File dest;
	private final static String IMG_PATH = "img\\menu\\piatti";
	private String sourceString;

	public PathValidator(File source, File dest) {
		super();
		this.source = source;
		this.dest = dest;
	}
	
	public PathValidator() {
	}
	
	public void copyFileToDir(String source, String dest) {
		File sourceFile = new File(source);
		File destFile = new File(dest);
		try  {
			FileUtils.copyFileToDirectory(sourceFile, destFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void copyToImgDir(String source) {
		this.copyFileToDir(source, IMG_PATH);
	}

	public File getSource() {
		return source;
	}

	public void setSource(File source) {
		this.source = source;
	}

	public File getDest() {
		return dest;
	}

	public void setDest(File dest) {
		this.dest = dest;
	}

}
