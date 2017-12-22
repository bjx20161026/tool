package org.bjx.helper.common;

public class PostfixTool {
    /**
     * get postfix of the path
     * @param path
     * @return
     */
	public static String EMPTY = "";
	public static String POINT = ".";
	
    public static String getPostfix(String path) {
        if (path == null || EMPTY.equals(path.trim())) {
            return EMPTY;
        }
        if (path.contains(POINT)) {
            return path.substring(path.lastIndexOf(POINT) + 1, path.length());
        }
        return EMPTY;
    }
}
