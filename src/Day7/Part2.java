package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
	
	private static Folder root = new Folder("");
	private final static int STORAGE_SIZE = 70000000;
	private final static int NEED_SPACE_OVERALL = 30000000;
	private static int needSpace = 0;
	private static TreeSet<Integer> set = new TreeSet<>();

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day7\\data.txt";
		
		final String[] str = Files.readString(Path.of(path)).lines().toArray(String[]::new);

		String currentPath = "";
		for (String s : str) {
			Matcher cdRoot = Pattern.compile("^\\$ cd /$").matcher(s);
			if (cdRoot.find()) {
				currentPath = "";
				continue;
			}
			
			Matcher cdLevelUp = Pattern.compile("^\\$ cd ..$").matcher(s);
			if (cdLevelUp.find()) {
				String[] pathSplitted = currentPath.split("/");
				String tempPath = "";
				for (int i=0; i<pathSplitted.length-1; i++) {
					tempPath += pathSplitted[i] + "/";
				}
				
				currentPath = tempPath;
				continue;
			}
			
			Matcher cdFolder = Pattern.compile("^\\$ cd (\\w+)$").matcher(s);
			if (cdFolder.find()) {
				currentPath = currentPath + cdFolder.group(1) + "/";
				continue;
			}
			
			if (Pattern.compile("^\\$ ls$").matcher(s).find()) {
				continue;
			}
			
			Matcher dir = Pattern.compile("^dir (\\w+)$").matcher(s);
			if (dir.find()) {
				continue;
			}
			
			Matcher file = Pattern.compile("^(\\d+) ([a-z\\.]+)$").matcher(s);
			if (file.find()) {
				storeFile(currentPath, Integer.parseInt(file.group(1)), file.group(2));
				continue;
			}
			
			System.out.println("Error!");
		}
		
		countSizeOfFolder(root);
		
		needSpace = NEED_SPACE_OVERALL - (70000000 - root.getSize());
		fillSet(root);
		
		System.out.println(set.first());
	}
	
	public static void storeFile(String path, int size, String name) {
		String[] pathSplitted = path.split("/");
		Folder temp = root;
		
		//create folder structure from root if it is not exist
		for (String nameFolder : pathSplitted) {
			if (nameFolder.equals("")) {
				continue;
			}
			
			List<Folder> folders = temp.getFolders();
			
			boolean needCreateFolder = true;
			for (Folder folder : folders) {
				if (folder.getName().equals(nameFolder)) {
					needCreateFolder = false;
					temp = folder;
					break;
				}
			}
			
			if (needCreateFolder) {
				Folder newFolder = new Folder(nameFolder);
				folders.add(newFolder);
				temp = newFolder;
			}
		}
		
		// now temp has address of Folder instance where we should store File
		for (File file : temp.getFiles()) {
			if (file.getName().equals(name)) {
				return; //file exists, do nothing
			}
		}
		
		temp.getFiles().add(new File(name, size));
	}

	public static void fillSet(Folder folder) {
		int sizeTemp = folder.getSize();
		if (sizeTemp >= needSpace) {
			set.add(sizeTemp);
		}
		
		for (Folder f : folder.getFolders()) {
			fillSet(f);
		}
	}
	
	public static void countSizeOfFolder(Folder folder) {
		int sum = 0;
		
		for (File file : folder.getFiles()) {
			sum += file.getSize();
		}
		
		for (Folder f : folder.getFolders()) {
			countSizeOfFolder(f);
			sum += f.getSize();
		}
		
		folder.setSize(sum);
	}
}