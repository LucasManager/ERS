package com.apl.sha.ers.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileUtil {
	public static boolean fileExists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}

	public static long fileLength(String filePath) {
		File file = new File(filePath);
		return file.length();
	}

	/**
	 * @param folderPath
	 * @param time
	 *            (Expired Minutes)
	 */
	public static void delExpiredFiles(String folderPath, int time,
			String fileExt) {
		File folder = new File(folderPath);
		long expiredTime = new Date().getTime() - time * 60 * 1000;
		if (folder.isDirectory()) {
			File[] files = folder.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (!files[i].isDirectory()) {
					String fileName = files[i].getName();
					if (fileName.substring(fileName.lastIndexOf("."))
							.equalsIgnoreCase(fileExt)) {
						if (files[i].lastModified() < expiredTime) {
							files[i].delete();
							try {
								deleteDirectory(new File(folder
										.getCanonicalPath()
										+ "\\" + fileName + "_files"));
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	public static void deleteDirectory(File dir) {
		if ((dir == null) || !dir.isDirectory()) {
			return;
		}
		File[] entries = dir.listFiles();
		int sz = entries.length;
		for (int i = 0; i < sz; i++) {
			if (entries[i].isDirectory()) {
				deleteDirectory(entries[i]);
			} else {
				entries[i].delete();
			}
		}
		dir.delete();
	}
}
