package utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ClipboardUtils {

    // Function to copy a string to the system clipboard
    public static void copyToClipboard(String text) {
    	
        // Create a StringSelection object with the specified text
        StringSelection stringSelection = new StringSelection(text);
        
        // Get the system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        
        // Set the string selection to the clipboard
        clipboard.setContents(stringSelection, null);
    }
}

