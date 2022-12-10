package Day7;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	private String name;
	private List<Folder> folders;
	private List<File> files;
	private int size;
	
	public Folder(String name) {
		this.name = name;
		this.folders = new ArrayList<>();
		this.files = new ArrayList<>();
		this.size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public List<Folder> getFolders() {
		return folders;
	}

	public String getName() {
		return name;
	}

	public List<File> getFiles() {
		return files;
	}
	
	public void increaseSize(int size) {
		this.size += size;
	}
	
	
}
