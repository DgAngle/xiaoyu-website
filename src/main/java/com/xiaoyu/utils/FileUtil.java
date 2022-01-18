package com.xiaoyu.utils;

import java.io.*;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/18 15:15
 */
public class FileUtil {

    /**
     * 检查并创建文件夹
     *
     * @param dirPath 文件夹路径
     */
    public static File createDir(String dirPath) {
        // 创建file对象
        File file = new File(dirPath);
        // 如果文件所在文件夹不存在, 新建文件夹
        if (!file.exists()) file.mkdirs();
        return file;
    }

    /**
     * 检查并创建文件 - 父文件夹需要存在
     *
     * @param fileFullPath 文件全路径
     */
    public static File createFile(String fileFullPath) {
        // 创建file对象
        File file = new File(fileFullPath);
        File fileDir = file.getParentFile();
        // 如果文件所在文件夹不存在, 新建文件夹
        if (!fileDir.exists()) fileDir.mkdirs();
        // 如果文件不存在, 新建文件
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 写入文件中
     *
     * @param inputStream 输入流
     * @param filePath    指定文件全路径(包含文件名 + 后缀)
     */
    public static void writeToFile(InputStream inputStream, String filePath) {
        // I/O 操作
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(FileUtil.createFile(filePath));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
